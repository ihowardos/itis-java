package services;

import DAO.PrisonerDAOImpl;
import db.DBConnection;
import models.Prisoner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 06.12.2016.
 */
public class PrisonerServiceImpl implements PrisonerService {
    Connection connection;
    PrisonerDAOImpl prisonerDAO;

    public PrisonerServiceImpl() {
        this.connection = DBConnection.getConnection();
        prisonerDAO = new PrisonerDAOImpl();
    }

    public void create(Prisoner prisoner) throws SQLException {
        prisonerDAO.create(prisoner);
    }

    @Override
    public LinkedList<Prisoner> getAllPrisoners(int idPrison) throws SQLException {
        return prisonerDAO.getAllPrisoners(idPrison);
    }

    @Override
    public int getIdPrisoner() throws SQLException {
        return prisonerDAO.getIdPrisoner();
    }

}
