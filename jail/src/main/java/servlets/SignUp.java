package servlets;

import DAO.WardenDAOImpl;
import models.Warden;
import services.WardenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Сергей on 26.11.2016.
 */

@WebServlet("/signup")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("current_user");
        if (user != null) {
            resp.sendRedirect("/home");
        } else
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Date date = Date.valueOf(req.getParameter("date"));
        WardenServiceImpl wardenService = new WardenServiceImpl();

        if (wardenService.checkNotBusyEmail(email)) {
            wardenService.create(email, password, firstname, lastname, date);
            resp.sendRedirect("/login");
        } else {
            String emailBusy = "Sorry, this email busy!";
            req.setAttribute("emailBusy", emailBusy);
            req.getRequestDispatcher("signup.jsp").include(req, resp);
        }
    }
}
