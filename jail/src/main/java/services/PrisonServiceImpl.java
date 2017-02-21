package services;

import DAO.PrisonDAOImpl;
import db.DBConnection;
import models.Prison;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Сергей on 29.11.2016.
 */

public class PrisonServiceImpl implements PrisonService {

    PrisonDAOImpl prisonDAO = null;
    private Connection connection;

    public PrisonServiceImpl() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.connection = DBConnection.getConnection();
        this.prisonDAO = new PrisonDAOImpl();
    }

    public PrisonServiceImpl(Connection connection) {
        this.connection = connection;
        prisonDAO = new PrisonDAOImpl(connection);
    }

    public void create(String name, String city, int capacity, int wardenId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Prison prison = new Prison(name, city, capacity, wardenId);
        prisonDAO.create(prison);
    }

    public boolean checkPrisonName(String name) throws SQLException {
        LinkedList<String> list = prisonDAO.getPrisonNames();
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i))) return false;
        }
        return true;
    }

    public int getId(int wardenId) throws SQLException {
        return prisonDAO.getId(wardenId);
    }

    public String getName(int wardenId) throws SQLException {
        return prisonDAO.getName(wardenId);
    }

    public String getCity(String name) throws SQLException {
        return prisonDAO.getCity(name);
    }

    public int getCapacity(int idWarden) throws SQLException {
        return prisonDAO.getCapacity(idWarden);
    }
}
