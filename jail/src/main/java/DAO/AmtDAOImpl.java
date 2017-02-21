package DAO;

import db.DBConnection;

import java.sql.*;

/**
 * Created by Сергей on 14.12.2016.
 */
public class AmtDAOImpl implements AmtDAO {
    Connection connection;

    public AmtDAOImpl() {
        this.connection = DBConnection.getConnection();
    }
    @Override
    public int getAmt(int idPrison) throws SQLException {
        String query = "CALL get_amt(?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idPrison);
        ResultSet resultSet = preparedStatement.executeQuery();
        int amt = -1;
        while (resultSet.next()) {
            amt = resultSet.getInt("amt");
        }
        return amt;
    }
}
