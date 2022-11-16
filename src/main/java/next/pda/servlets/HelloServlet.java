package next.pda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import next.pda.entity.Activity;
import next.pda.entity.Exercice;
import next.pda.services.serviceImp.ActivityServiceImp;
import next.pda.services.GenericService;

import java.io.IOException;

@WebServlet(name = "hello-servlet", value = "/hello-servlet")
    public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title ="Activité3";
        String description="Presentation sur devops";
        boolean etat = true;
        Activity activity1 = new Activity();
        activity1.setTitle(title);
        activity1.setDescription(description);
        activity1.setEtat(etat);
        GenericService activityService = new ActivityServiceImp();
        activityService.add(activity1);
        System.out.println("hahahah");
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Exercice exercice = new Exercice();
        Activity activity = new Activity();

    }
}
