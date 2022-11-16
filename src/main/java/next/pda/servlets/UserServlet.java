
package next.pda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.pda.dao.daoImp.UserDaoImp;
import next.pda.entity.Responsable;
import next.pda.entity.User;
import next.pda.enu.Roles;
import next.pda.enu.TypesResponsable;
import next.pda.services.ParticipantService;
import next.pda.services.ResponsableService;
import next.pda.services.serviceImp.ParticipantServiceImp;
import next.pda.services.serviceImp.ResponsableServiceImp;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/pda/v1/users")
public class UserServlet extends HttpServlet {
    ParticipantService participantService = new ParticipantServiceImp();
    ResponsableService responsableService = new ResponsableServiceImp();
    UserDaoImp userDao = new UserDaoImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        List<User> usersList = this.userDao.getAll();
        request.setAttribute("usersList", usersList);
        
        request.setAttribute("active", "users");
        getServletContext().getRequestDispatcher("/pda/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
