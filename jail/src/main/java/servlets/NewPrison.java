package servlets;

import services.PrisonServiceImpl;
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

@WebServlet("/newPrison")
public class NewPrison extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("current_user");
        if (email != null) req.getRequestDispatcher("newPrisonForm.jsp").forward(req, resp);
        else resp.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        int capacity = Integer.parseInt(req.getParameter("capacity"));
        String email = (String) session.getAttribute("current_user");
        try {
            PrisonServiceImpl prisonService = new PrisonServiceImpl();
            WardenServiceImpl wardenService = new WardenServiceImpl();
            int wardenId = wardenService.getId(email);
            if (prisonService.getId(wardenId) == -1) {
                if (prisonService.checkPrisonName(name)) {
                    prisonService.create(name, city, capacity, wardenId);
                    resp.sendRedirect("/home");
                } else {
                    String error = "This name of prison is already in use!";
                    req.setAttribute("thisNameInUse", error);
                    req.getRequestDispatcher("newPrisonForm.jsp").include(req, resp);
                }
            } else {
                resp.sendRedirect("/home");
            }

            } catch(Exception e){
                e.printStackTrace();
            }
    }
}
