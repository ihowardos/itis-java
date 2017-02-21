package DAO;

import models.Prison;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергей on 26.11.2016.
 */
public interface PrisonDAO {
    void create(Prison prison) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;
    List getPrisonNames() throws SQLException;
    int getId(int WardenId) throws SQLException;
    String getName(int wardenId) throws SQLException;
    String getCity(String name) throws SQLException;
    int getCapacity(int idWarden) throws SQLException;
}
