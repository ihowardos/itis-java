package services;

import DAO.ArticleDAOImpl;
import models.Article;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Сергей on 12.12.2016.
 */
public class ArticleServiceImpl implements ArticleService {
    ArticleDAOImpl articleDAO = null;

    public ArticleServiceImpl() {
        this.articleDAO = new ArticleDAOImpl();
    }

    public void create(Article article) throws SQLException {
        articleDAO.create(article);
    }

    public LinkedList<Article> getAllArticles() throws SQLException {
        return articleDAO.getAllArticles();
    }

    @Override
    public String getDescription(int idArticle) throws SQLException {
        return articleDAO.gedDescription(idArticle);
    }

    @Override
    public LinkedList<Integer> getArticlesOfPrisoner(int idPrisoner) throws SQLException {
        return articleDAO.getArticlesOfPrisoner(idPrisoner);
    }
}
