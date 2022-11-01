package next.pda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import next.pda.dao.ActivitiesDao;
import next.pda.dao.daoImp.ActivityDaoImp;
import next.pda.entity.Activity;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "hello-servlet", value = "/hello-servlet")
    public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Activity activity = new Activity();
        activity.setTitle("intervention");
        activity.setDescription("dfvghjksjhjs");
        activity.setDateDebut(new Date());
        activity.setEtat(true);
        ActivitiesDao activitiesDao = new ActivityDaoImp();
        activitiesDao.add(activity);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Activity activity = new Activity();
        ActivitiesDao activitiesDao = new ActivityDaoImp();
        //activity = activitiesDao.getOne(id);
        List<Activity> activities = activitiesDao.getAllActivities(activity);
        System.out.println(activities);
    }
}
