package DAO;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Сергей on 15.12.2016.
 */
public class PrisonerHasArticlesDAOImpl implements PrisonerHasArticlesDAO {
    private Connection connection;

    public PrisonerHasArticlesDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void create(int idPrisoner, int idArticle) throws SQLException {
        String query = "CALL create_prisoners_has_articles(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idPrisoner);
        preparedStatement.setInt(2, idArticle);
        preparedStatement.executeUpdate();
    }
}
