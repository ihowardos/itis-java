package DAO;

import db.DBConnection;
import models.Prisoner;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 06.12.2016.
 */
public class PrisonerDAOImpl implements PrisonerDAO {
    Connection connection;

    public PrisonerDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    public void create(Prisoner prisoner) throws SQLException {
        String query = "CALL create_prisoner(?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, prisoner.getFirstname());
        preparedStatement.setString(2, prisoner.getLastname());
        preparedStatement.setDate(3, prisoner.getDateOfBirth());
        preparedStatement.setDate(4, prisoner.getDetention());
        preparedStatement.setDate(5, prisoner.getReleased());
        preparedStatement.setInt(6, prisoner.getIdPrison());
        preparedStatement.executeUpdate();
    }

    // добавить articles
    @Override
    public LinkedList<Prisoner> getAllPrisoners(int idPrison) throws SQLException {
        LinkedList<Prisoner> prisoners = new LinkedList<>();
        String query = "SELECT * FROM prisoners WHERE id_prison = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idPrison);
        ResultSet resultSet = preparedStatement.executeQuery();
        Prisoner prisoner;
        String firstname;
        String lastname;
        Date dateOfBirth;
        Date detention;
        Date released;
        int idPrisoner;
        while (resultSet.next()) {
            firstname = resultSet.getString("firstname");
            lastname = resultSet.getString("lastname");
            dateOfBirth = resultSet.getDate("date_of_birth");
            detention = resultSet.getDate("detention");
            released = resultSet.getDate("released");
            idPrisoner = resultSet.getInt("id_prisoner");
            prisoner = new Prisoner(firstname, lastname, dateOfBirth, detention, released, idPrisoner);
            prisoners.add(prisoner);
        }
        return prisoners;
    }

    @Override
    public int getIdPrisoner() throws SQLException {
        String query = "SELECT id_prisoner FROM prisoners_info HAVING max(reg_time);";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        int idPrisoner = -1;
        while (resultSet.next()) {
            idPrisoner = resultSet.getInt("id_prisoner");
        }
        return idPrisoner;
    }

}
