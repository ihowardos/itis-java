package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Сергей on 09.12.2016.
 */

@WebServlet("/exit")
public class Exit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("current_user");
        if (email != null) {
            session.setAttribute("current_user", null);
            resp.sendRedirect("/login");
        } else resp.sendRedirect("/login");
    }
}
