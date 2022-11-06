package next.pda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import next.pda.entity.Activity;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ActivityServlet", value = "/pda/v1/activity")
public class ActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Activity> activities = new ArrayList<>();
        Activity activity1 = new Activity();
        Activity activity2 = new Activity();
        activity1.setId(1);
        activity1.setTitle("Act1");
        activity1.setEtat(true);
        activity1.setDateDebut(new Date());
        activity1.setDateFin(new Date());
        activity1.setDescription("description 1");

        activity2.setId(2);
        activity2.setTitle("Act2");
        activity2.setEtat(false);
        activity2.setDateDebut(new Date());
        activity2.setDateFin(new Date());
        activity2.setDescription("description 2");
        // add to list
        activities.add(activity1);
        activities.add(activity2);
        request.setAttribute("activities", activities);
        // send to home page
        request.setAttribute("active", "activity");
        getServletContext().getRequestDispatcher("/pda/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Activity activity = new Activity();
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dateDebut = request.getParameter("dateDebut");
        String dateFin = request.getParameter("dateFin");
        String responsableId = request.getParameter("responsable");
        String exercises = Arrays.toString(request.getParameterValues("exercise"));
        System.out.println("------------------------------");
        System.out.println(title);
        System.out.println(description);
        System.out.println(dateDebut);
        System.out.println(dateFin);
        System.out.println(responsableId);
        System.out.println(exercises);
    }
}
