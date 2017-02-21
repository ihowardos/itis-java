package services;

import DAO.PrisonerHasArticlesDAOImpl;
import db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Сергей on 15.12.2016.
 */
public class PrisonerHasArticlesServiceImpl implements PrisonerHasArticlesService {
    private Connection connection;
    private PrisonerHasArticlesDAOImpl prisonerHasArticlesDAO = null;

    public PrisonerHasArticlesServiceImpl() {
        connection = DBConnection.getConnection();
        prisonerHasArticlesDAO = new PrisonerHasArticlesDAOImpl();
    }
    @Override
    public void create(int idPrisoner, int idArticle) throws SQLException {
        prisonerHasArticlesDAO.create(idPrisoner, idArticle);
    }
}
