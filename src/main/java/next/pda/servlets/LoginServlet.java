package next.pda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import next.pda.entity.User;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/pda/v1/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pda/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        //user = userService.getUserByUsernameAndPassword(username, password)
        if ( 1 == 1 ) {
            user.setEmail("admin@gmail.com");
            user.setFirstName("said");
            user.setLastName("hasnaoui");
            HttpSession maSession = request.getSession();
            maSession.setAttribute("userSession", user);
            response.sendRedirect("home");
        } else {
            String message = "Unknown username or password. Please retry.";
            request.setAttribute("username", username);
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/pda/login.jsp").forward(request, response);
        }
    }
}
