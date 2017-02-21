package DAO;

import models.Warden;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергей on 25.11.2016.
 */
public interface WardenDAO {
    void create(Warden warden);
    List<String> getAllEmail();
    List<String> getAllPs();
    int getId(String email) throws SQLException;
    String getEmail(String password);
    boolean checkEmailPs(String email, String password);
    void setPrisonId(int id, String email) throws SQLException;
}
