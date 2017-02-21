package verifiers;

import DAO.WardenDAO;
import DAO.WardenDAOImpl;
import db.DBConnection;
import utils.Hashing;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by Сергей on 27.11.2016.
 */
public class WardenVerifier {
    Connection connection;

    WardenVerifier() {
        this.connection = DBConnection.getConnection();
    }

    public WardenVerifier(Connection connection) {
        this.connection = connection;
    }

    public boolean psVerifier(String email, String password) {
        Hashing hashing = new Hashing();
        String hPassword = hashing.md5Custom(password);
        WardenDAOImpl wardenDAO = new WardenDAOImpl(connection);
        LinkedList<String> list = wardenDAO.getAllPs();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(hPassword) && email.equals(wardenDAO.getEmail(hPassword)))
                return true;
        }
        return false;
    }
}
