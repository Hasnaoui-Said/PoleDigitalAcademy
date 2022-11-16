package next.pda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import next.pda.entity.Activity;
import next.pda.entity.Exercice;
import next.pda.entity.Responsable;
import next.pda.enu.TypesActivity;
import next.pda.services.ActivityService;
import next.pda.services.ExerciseService;
import next.pda.services.ResponsableService;
import next.pda.services.serviceImp.ActivityServiceImp;
import next.pda.services.serviceImp.ExerciceServiceImp;
import next.pda.services.serviceImp.ResponsableServiceImp;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ActivityServlet", value = "/pda/v1/activity")
public class ActivityServlet extends HttpServlet {
    private ActivityService activityService = new ActivityServiceImp();
    private ExerciseService exerciseService = new ExerciceServiceImp();
    private ResponsableService responsableService = new ResponsableServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession maSession = request.getSession();
        List<Activity> activities = this.activityService.getAll();
        List<Exercice> exercices = this.exerciseService.getAll();
        List<Responsable> responsables = this.responsableService.getAll();
        if (request.getParameter("delete") != null){
            int id = Integer.parseInt(request.getParameter("delete"));
            //this.activityService.deleteById(id);
            maSession.setAttribute("message", "Activity deleted successfully.");
            maSession.setAttribute("className", "danger");
        }
        if (request.getParameter("edit") != null){
            int id = Integer.parseInt(request.getParameter("edit"));
            Activity activity = this.activityService.getOneById(id);
            request.setAttribute("edit", id);
            request.setAttribute("activity", activity);
            request.setAttribute("responsablesListEdit", responsables);
            request.setAttribute("exercisesListEdit", exercices);
        }

        // add to request
        request.setAttribute("responsablesList", responsables);
        request.setAttribute("exercisesList", exercices);
        request.setAttribute("activities", activities);

        // send to home page
        request.setAttribute("active", "activity");
        getServletContext().getRequestDispatcher("/pda/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession maSession = request.getSession();
            Activity activity = this.createActivity(request);
            int idResp = -1;
            if (request.getParameter("responsable") != null)
                idResp = Integer.parseInt(request.getParameter("responsable"));
            String[] ex = request.getParameterValues("exercises");
            List exercises = new ArrayList<>();
            if(ex!=null)
                for(String s: ex)
                    if (s != null)
                        exercises.add(Integer.parseInt(s));
            if (request.getParameter("update") != null){
                int id = Integer.parseInt(request.getParameter("id"));
                activity.setId(id);
                this.activityService.update(activity, exercises, idResp);
                maSession.setAttribute("message", "Activity updated successfully.");
                maSession.setAttribute("className", "info");
            }else{
                this.activityService.add(activity, exercises, idResp);
                maSession.setAttribute("message", "Activity saved successfully.");
                maSession.setAttribute("className", "success");
            }
            //ParseException
        } catch (Exception e) {
            request.setAttribute("Exception", "Error! Exception: "+ e.getMessage());
        }
        response.sendRedirect("activity");
    }

    private Activity createActivity(HttpServletRequest request) throws Exception {
        try {
            Activity activity = new Activity();
            activity.setTitle(request.getParameter("title"));
            if(request.getParameter("type") != null)
                activity.setType(TypesActivity.valueOf(request.getParameter("type")));
            else
                throw new NullPointerException("Type of formation is required");
            activity.setEtat(Boolean.parseBoolean(request.getParameter("status")));
            activity.setDescription(request.getParameter("description"));
            activity.setDescription(request.getParameter("description"));
            activity.setDateFin(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateDebut")));
            activity.setDateDebut(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateFin")));
            //activity.setTitle(request.getParameter("responsable");
            //String exercises = Arrays.toString(request.getParameterValues("exercises"));
            return activity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
