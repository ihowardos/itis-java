package services;

import DAO.WardenDAO;
import DAO.WardenDAOImpl;
import db.DBConnection;
import models.Warden;
import utils.Hashing;
import verifiers.WardenVerifier;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Сергей on 26.11.2016.
 */
public class WardenServiceImpl implements WardenService {
    WardenDAOImpl wardenDAO = null;
    private Connection connection;

    public WardenServiceImpl() {
        this.connection = DBConnection.getConnection();
        this.wardenDAO = new WardenDAOImpl(connection);
    }

    public boolean checkNotBusyEmail(String email) {
    LinkedList<String> list;
    list = wardenDAO.getAllEmail();
    for (int i = 0; i < list.size(); i++) {
        if(list.get(i).equals(email)) return false;
    }
    return true;
}
    public void create(String email, String password, String firstname, String lastname, Date date) {
        Hashing hashing = new Hashing();
        Warden warden = new Warden(email, hashing.md5Custom(password), date, firstname, lastname);
        wardenDAO.create(warden);
    }

    public int getId(String email) throws SQLException {
       return wardenDAO.getId(email);
    }

    public boolean checkEmailPs(String email, String password) {
        WardenVerifier wardenVerifier = new WardenVerifier(connection);
        if (wardenVerifier.psVerifier(email, password)) return true;
        return false;
    }

    public void setPrisonId(int prisonId, String email) throws SQLException {
        wardenDAO.setPrisonId(prisonId, email);
    }
}
