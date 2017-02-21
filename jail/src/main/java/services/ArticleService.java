package services;

import models.Article;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Сергей on 12.12.2016.
 */
public interface ArticleService {
    void create(Article article) throws SQLException;
    LinkedList<Article> getAllArticles() throws SQLException;
    String getDescription(int idArticle) throws SQLException;
    LinkedList<Integer> getArticlesOfPrisoner(int idPrisoner) throws SQLException;
}
