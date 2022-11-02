package next.pda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import next.pda.dao.GenericDao;
import next.pda.dao.daoImp.ActivityDaoImp;
import next.pda.dao.daoImp.ExerciceDaoImp;
import next.pda.entity.Activity;
import next.pda.entity.Exercice;
import next.pda.enu.StatusExercice;
import next.pda.exeption.Ex;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "hello-servlet", value = "/hello-servlet")
    public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exercice exercice = new Exercice();
        Activity activity = new Activity();
        GenericDao genericDao = new ActivityDaoImp();
        GenericDao exerciceDao = new ExerciceDaoImp();
        exercice.setStatus(StatusExercice.EN_COURS);
        activity.setTitle("evenement2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Exercice exercice = new Exercice();
        Activity activity = new Activity();



    /*
        exercice.setStatus(StatusExercice.TERMINE);
        genericDao.update(exercice);
        List<Exercice> exercices = genericDao.getAll(exercice);
        exercice =(Exercice) genericDao.getOne(id);
        System.out.println(exercice.toString());
        /*
        System.out.println(exercices);*/
    }
}
