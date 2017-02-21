package DAO;


import db.DBConnection;
import models.Prison;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Сергей on 26.11.2016.
 */
public class PrisonDAOImpl implements PrisonDAO {

    private Connection connection;

    public PrisonDAOImpl() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.connection = DBConnection.getConnection();
    }

    public PrisonDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void create(Prison prison) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        String query = "INSERT INTO prisons (name, city, capacity, id_warden) VALUES(?, ?, ?, ?);";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, prison.getName());
        preparedStatement.setString(2, prison.getCity());
        preparedStatement.setInt(3, prison.getCapacity());
        preparedStatement.setInt(4, prison.getWardenId());
        preparedStatement.executeUpdate();
    }

    public LinkedList<String> getPrisonNames() throws SQLException {
        LinkedList<String> list = new LinkedList<String>();
        String query = "SELECT name FROM prisons;";
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            list.add(name);
        }
        return list;
    }

    public int getId(int wardenId) throws SQLException {
        String query = "SELECT id_prison FROM prisons WHERE id_warden = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, wardenId);
        ResultSet resultSet  = preparedStatement.executeQuery();
        int id = -1;
        while (resultSet.next()) {
            id = resultSet.getInt("id_prison");
        }
        return id;
    }

    public String getName(int wardenId) throws SQLException {
        String query = "SELECT name FROM prisons WHERE id_warden = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, wardenId);
        ResultSet resultSet = preparedStatement.executeQuery();
        String name = null;
        while (resultSet.next()) {
            name = resultSet.getString("name");
        }
        return name;
    }

    public String getCity(String name) throws SQLException {
        String query = "SELECT city FROM prisons WHERE name = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        String city = null;
        while (resultSet.next()) {
            city = resultSet.getString("city");
        }
        return city;
    }

    public int getCapacity(int idWarden) throws SQLException {
        String query = "SELECT capacity FROM prisons WHERE id_warden = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idWarden);
        ResultSet resultSet = preparedStatement.executeQuery();
        int capacity = -1;
        while (resultSet.next()) {
            capacity = resultSet.getInt("capacity");
        }
        return capacity;
    }
}
