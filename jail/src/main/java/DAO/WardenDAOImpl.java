package DAO;

import db.DBConnection;
import models.Warden;
import utils.Hashing;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 25.11.2016.
 */
public class WardenDAOImpl implements WardenDAO {
    private Connection connection;

    public WardenDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    public WardenDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void create(Warden warden) {
        String query = "CALL create_warden(?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, warden.getFirstname());
            preparedStatement.setString(2, warden.getLastname());
            preparedStatement.setString(3, warden.getEmail());
            preparedStatement.setDate(4, (Date) warden.getDateOfBirth());
            preparedStatement.setString(5, warden.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> getAllEmail() {
        LinkedList<String> list = new LinkedList<String>();
        Statement statement;
        String query = "SELECT email FROM wardens;";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String email = rs.getString("email");
                list.add(email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public LinkedList<String> getAllPs() {
        LinkedList<String> list = new LinkedList<String>();
        String query = "SELECT password FROM wardens;";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                list.add(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public int getId(String email) throws SQLException {
        String query = "SELECT id_warden FROM wardens WHERE email = ?;";
        PreparedStatement preparedStatement;
        int id = -1;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
            id = resultSet.getInt("id_warden");
        return id;
    }


    public String getEmail(String password) {
        String query = "SELECT email FROM wardens WHERE password = ?;";
        PreparedStatement preparedStatement;
        String email = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                email = resultSet.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return email;
    }

    public boolean checkEmailPs(String email, String password) {
        return false;
    }

    public void setPrisonId(int prisonId, String email) throws SQLException {
        String query = "UPDATE wardens SET id_prison = ? WHERE email = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, prisonId);
        preparedStatement.setString(2, email);
        preparedStatement.executeUpdate();
    }


}
