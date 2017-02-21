package services;

import models.Prison;

import java.sql.SQLException;

/**
 * Created by Сергей on 29.11.2016.
 */
public interface PrisonService {
    void create(String name, String city, int capacity, int wardenId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
    boolean checkPrisonName(String name) throws SQLException;
    int getId(int wardenId) throws SQLException;
    String getName(int wardenId) throws SQLException;
    String getCity(String name) throws SQLException;
    int getCapacity(int idWarden) throws SQLException;

}
