package next.pda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.pda.entity.Exercice;
import next.pda.enu.StatusExercice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ExerciceServlet", value = "/pda/v1/exercise")
public class ExerciceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exercice> exercises = new ArrayList<>();
        Exercice exercice1 = new Exercice();
        Exercice exercice2 = new Exercice();
        exercice1.setExercice_id(1);
        exercice1.setAnnee("12-12-2022");
        exercice1.setStatus(StatusExercice.EN_COURS);
        exercice1.setDateDebut(new Date());
        exercice1.setDateFin(new Date());

        exercice2.setExercice_id(2);
        exercice2.setAnnee("12-12-2022");
        exercice2.setStatus(StatusExercice.TERMINE);
        exercice2.setDateDebut(new Date());
        exercice2.setDateFin(new Date());

        exercises.add(exercice1);
        exercises.add(exercice2);

        request.setAttribute("exercises", exercises);

        // redirect to home
        request.setAttribute("active", "exercise");
        getServletContext().getRequestDispatcher("/pda/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
