package servlets;

import services.WardenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Сергей on 27.11.2016.
 */

@WebServlet("/login")
public class LogIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("current_user");
        if (user != null) {
            resp.sendRedirect("/home");
        } else
            req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        WardenServiceImpl wardenService = new WardenServiceImpl();
        if (wardenService.checkEmailPs(email, password)) {
            session.setAttribute("current_user", email);
            resp.sendRedirect("/signup");
        } else {
            String invalidPsOrEmail = "Invalid email or password!";
            req.setAttribute("invalidPsOrEmail", invalidPsOrEmail);
            req.getRequestDispatcher("login.jsp").include(req, resp);
        }
    }
}
