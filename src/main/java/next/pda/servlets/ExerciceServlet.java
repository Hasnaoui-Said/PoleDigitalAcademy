package next.pda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import next.pda.entity.Activity;
import next.pda.entity.Exercice;
import next.pda.enu.StatusExercice;
import next.pda.services.ExerciseService;
import next.pda.services.serviceImp.ExerciceServiceImp;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ExerciceServlet", value = "/pda/v1/exercise")
public class ExerciceServlet extends HttpServlet {
    ExerciseService exerciseService = new ExerciceServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession maSession = request.getSession();
        if (request.getParameter("delete") != null){
            int id = Integer.parseInt(request.getParameter("delete"));
            System.out.println("delete element: "+id);
            //this.exerciseService.deleteById(id);
            maSession.setAttribute("message", "Exercise deleted successfully.");
            maSession.setAttribute("className", "danger");
        }
        if (request.getParameter("edit") != null){
            int id = Integer.parseInt(request.getParameter("edit"));
            Exercice exercice = this.exerciseService.getOneById(id);
            request.setAttribute("edit", id);
            request.setAttribute("exercise", exercice);
        }
        List<Exercice> exercises = this.exerciseService.getAll();

        request.setAttribute("exercises", exercises);

        // redirect to home
        request.setAttribute("active", "exercise");
        getServletContext().getRequestDispatcher("/pda/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Exercice exercice = this.createExercise(request);
            HttpSession maSession = request.getSession();
            if (request.getParameter("update") != null){
                int id = Integer.parseInt(request.getParameter("id"));
                exercice.setExercice_id(id);
                this.exerciseService.update(exercice);
                maSession.setAttribute("message", "Exercise updated successfully.");
                maSession.setAttribute("className", "info");
            }else{
                this.exerciseService.add(exercice);
                maSession.setAttribute("message", "Exercise saved successfully.");
                maSession.setAttribute("className", "success");
            }
        } catch (ParseException e) {
            request.setAttribute("parseException", "Error! parseException: "+ e.getMessage());
        }
        response.sendRedirect("exercise");
    }
    private Exercice createExercise(HttpServletRequest request) throws ParseException {

        Exercice exercice = new Exercice();
        exercice.setAnnee(request.getParameter("annee"));
        exercice.setTitle(request.getParameter("title"));
        exercice.setStatus(StatusExercice.valueOf(request.getParameter("status")));
        exercice.setDateFin(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateDebut")));
        exercice.setDateDebut(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateFin")));
        return exercice;
    }
}
