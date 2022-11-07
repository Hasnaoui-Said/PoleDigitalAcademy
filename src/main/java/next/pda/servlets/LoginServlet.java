package next.pda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import next.pda.entity.Administrateur;
import next.pda.entity.User;
import next.pda.enu.Roles;
import next.pda.services.ActivityService;
import next.pda.services.AdminService;
import next.pda.services.serviceImp.ActivityServiceImp;
import next.pda.services.serviceImp.AdminServiceImp;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/pda/v1/login")
public class LoginServlet extends HttpServlet {
    private AdminService adminService =  new AdminServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession maSession = request.getSession();
        Administrateur administrateur = (Administrateur)maSession.getAttribute("userSession");
        if (administrateur.getLogin() != null){
            response.sendRedirect("home");
            return;
        }
        getServletContext().getRequestDispatcher("/pda/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Administrateur user = this.adminService.loginByEmailAndPassword(username, password);
        if ( user != null ) {
            user.setPassword("");
            HttpSession maSession = request.getSession();
            maSession.setAttribute("userSession", user);

            maSession.setAttribute("message", "Connected successfully.");
            maSession.setAttribute("className", "info");
            response.sendRedirect("home");
        } else {
            String message = "Unknown username or password. Please retry.";
            request.setAttribute("username", username);
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/pda/login.jsp").forward(request, response);
        }
    }
}
