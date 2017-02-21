package DAO;

import db.DBConnection;
import models.Article;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 12.12.2016.
 */
public class ArticleDAOImpl implements ArticleDAO {
    Connection connection;

    public ArticleDAOImpl() {
        connection = DBConnection.getConnection();
    }
    public void create(Article article) throws SQLException {
        String query = "CALL create_articles(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, article.getNumber());
        preparedStatement.setString(2, article.getDescription());
        preparedStatement.executeUpdate();
    }

    public LinkedList<Article> getAllArticles() throws SQLException {
        LinkedList<Article> list = new LinkedList<>();
        String query = "SELECT * FROM list_articles";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int idArticle = resultSet.getInt("id_article");
            String description = resultSet.getString("description");
            Article article = new Article(idArticle, description);
            list.add(article);
        }
        return list;
    }

    @Override
    public String gedDescription(int idArticle) throws SQLException {
        String query = "SELECT description FROM list_articles WHERE id_article = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idArticle);
        ResultSet resultSet = preparedStatement.executeQuery();
        String description = null;
        while (resultSet.next()) {
            description = resultSet.getString("description");
        }
        return description;
    }

    @Override
    public LinkedList<Integer> getArticlesOfPrisoner(int idPrisoner) throws SQLException {
        LinkedList<Integer> articlesOfPrisoner = new LinkedList<>();
        String query = "SELECT id_article FROM prisoners_has_articles WHERE id_prisoner = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idPrisoner);
        ResultSet resultSet = preparedStatement.executeQuery();
        int idArticle = -1;
        while (resultSet.next()) {
            idArticle = resultSet.getInt("id_article");
            articlesOfPrisoner.add(idArticle);
        }
        return articlesOfPrisoner;
    }
}
