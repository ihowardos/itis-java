package servlets;

import models.Article;
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
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Сергей on 06.12.2016.
 */
@WebServlet("/newPrisoner")
public class NewPrisoner extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("current_user");

        if (user != null) {
            try {
                PrisonServiceImpl prisonService = new PrisonServiceImpl();
                AmtServiceImpl amtService = new AmtServiceImpl();
                WardenServiceImpl wardenService = new WardenServiceImpl();
                int amt = amtService.getAmt(prisonService.getId(wardenService.getId(user)));
                int capacity = prisonService.getCapacity(wardenService.getId(user));

                if(amt < capacity) {
                    ArticleServiceImpl articleService = new ArticleServiceImpl();
                    LinkedList<Article> articles = articleService.getAllArticles();
                    req.setAttribute("articles", articles);
                    req.getRequestDispatcher("newPrisonerForm.jsp").include(req, resp);
                } else resp.sendRedirect("/home");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else resp.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("current_user");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        Date dateOfBirth = Date.valueOf(req.getParameter("dateOfBirth"));
        Date detention = Date.valueOf(req.getParameter("detention"));
        Date released = Date.valueOf(req.getParameter("released"));
        String[] articles = req.getParameterValues("articles");
        for (int i = 0; i < articles.length; i++) {
            System.out.println("Article " + articles[i]);
        }
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        LinkedList<Article> listArticles = new LinkedList<>();
        Article article;
        String description;
        int idArticle;
        for (int i = 0; i < articles.length; i++) {
            idArticle = Integer.valueOf(articles[i]);
            try {
                description = articleService.getDescription(idArticle);
                article = new Article(idArticle, description);
                listArticles.add(article);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < listArticles.size(); i++) {
            System.out.println(listArticles.get(i).getNumber() + ". " + listArticles.get(i).getDescription());
        }
        try {
            WardenServiceImpl wardenService = new WardenServiceImpl();
            PrisonServiceImpl prisonService = new PrisonServiceImpl();
            PrisonerServiceImpl prisonerService = new PrisonerServiceImpl();
            PrisonerHasArticlesServiceImpl prisonerHasArticlesService = new PrisonerHasArticlesServiceImpl();
            int wardenId = wardenService.getId(email);
            int idPrison = prisonService.getId(wardenId);
            Prisoner prisoner = new Prisoner(firstname, lastname, dateOfBirth, detention, released, idPrison);
            prisonerService.create(prisoner);
            int idPrisoner = prisonerService.getIdPrisoner();
            for (int i = 0; i < listArticles.size(); i++) {
                prisonerHasArticlesService.create(idPrisoner, listArticles.get(i).getNumber());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/home");
    }
}
