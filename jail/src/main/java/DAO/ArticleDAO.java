package DAO;

import models.Article;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 12.12.2016.
 */
public interface ArticleDAO {
    void create(Article article) throws SQLException;
    List<Article> getAllArticles() throws SQLException;
    String gedDescription(int idArticle) throws SQLException;
    LinkedList<Integer> getArticlesOfPrisoner(int idPrisoner) throws SQLException;
}
