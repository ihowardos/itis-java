package services;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Сергей on 26.11.2016.
 */
public interface WardenService {
    boolean checkNotBusyEmail(String email);
    void create(String email, String password, String firstname, String lastname, Date date);
    int getId(String email) throws SQLException;
    void setPrisonId(int id, String email) throws SQLException;
}
