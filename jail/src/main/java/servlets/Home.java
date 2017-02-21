package servlets;

import models.Prison;
import models.Prisoner;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;

/**
 * Created by Сергей on 27.11.2016.
 */
@WebServlet("/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("current_user");
        if (user != null) {
            try {
                PrisonServiceImpl prisonService = new PrisonServiceImpl();
                WardenServiceImpl wardenService = new WardenServiceImpl();
                PrisonerServiceImpl prisonerService = new PrisonerServiceImpl();
                int idWarden = wardenService.getId(user);
                int idPrison = prisonService.getId(idWarden);

                if (idPrison != -1) {
                    String name = prisonService.getName(idWarden);
                    String city = prisonService.getCity(name);
                    int capacity = prisonService.getCapacity(idWarden);
                    AmtServiceImpl amtService = new AmtServiceImpl();
                    LinkedList<Prisoner> prisoners = prisonerService.getAllPrisoners(idPrison);
                    LinkedList<Prisoner> prisonersWithArticles = new LinkedList<Prisoner>();
                    ArticleServiceImpl articleService = new ArticleServiceImpl();
                    Prisoner prisoner;
                    for (int i = 0; i < prisoners.size(); i ++) {
                        String firstname = prisoners.get(i).getFirstname();
                        String lastname = prisoners.get(i).getLastname();
                        Date dateOfBirth = prisoners.get(i).getDateOfBirth();
                        Date detention = prisoners.get(i).getDetention();
                        Date released = prisoners.get(i).getReleased();
                        int idPrisoner = prisoners.get(i).getIdPrisoner();
                        LinkedList<Integer> listArticles = articleService.getArticlesOfPrisoner(idPrisoner);
                        prisoner = new Prisoner(firstname, lastname, dateOfBirth, detention, released, listArticles, idPrisoner);
                        prisonersWithArticles.add(prisoner);
                    }
                    Prison prison = new Prison(idPrison, name, city, capacity, idWarden);

                    req.setAttribute("prisonersWithArticles", prisonersWithArticles);
                    req.setAttribute("amt", amtService.getAmt(idPrison));
                    //req.setAttribute("prisoners", prisoners);
                    req.setAttribute("prison", prison);
                } else {
                    String prisonIsNotCreate = "Prison is not create!";
                    req.setAttribute("prisonIsNotCreate", prisonIsNotCreate);
                }
                    req.getRequestDispatcher("home.jsp").include(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else resp.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
