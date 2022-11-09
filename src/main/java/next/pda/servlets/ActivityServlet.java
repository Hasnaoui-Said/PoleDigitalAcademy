package next.pda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import next.pda.entity.Activity;
import next.pda.services.ActivityService;
import next.pda.services.serviceImp.ActivityServiceImp;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

@WebServlet(name = "ActivityServlet", value = "/pda/v1/activity")
public class ActivityServlet extends HttpServlet {
    private ActivityService activityService = new ActivityServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession maSession = request.getSession();
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
        }
        List<Activity> activities = this.activityService.getAll();
        request.setAttribute("activities", activities);
        // send to home page
        request.setAttribute("active", "activity");
        getServletContext().getRequestDispatcher("/pda/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Activity activity = this.createActivity(request);
            HttpSession maSession = request.getSession();
            if (request.getParameter("update") != null){
                int id = Integer.parseInt(request.getParameter("id"));
                activity.setId(id);
                this.activityService.update(activity);
                maSession.setAttribute("message", "Activity updated successfully.");
                maSession.setAttribute("className", "info");
            }else{
                System.out.println("save");
                this.activityService.add(activity);
                maSession.setAttribute("message", "Activity saved successfully.");
                maSession.setAttribute("className", "success");
            }
        } catch (ParseException e) {
            request.setAttribute("parseException", "Error! parseException: "+ e.getMessage());
        }
        response.sendRedirect("activity");
    }

    private Activity createActivity(HttpServletRequest request) throws ParseException {

        Activity activity = new Activity();
        activity.setTitle(request.getParameter("title"));
        activity.setDescription(request.getParameter("description"));
        activity.setDateFin(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateDebut")));
        activity.setDateDebut(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateFin")));
        //List<Exercice> exercices = new ArrayList<>();
        //activity.setTitle(request.getParameter("responsable");
        //String exercises = Arrays.toString(request.getParameterValues("exercise"));
        return activity;
    }
}
