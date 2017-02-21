package services;

import DAO.AmtDAOImpl;
import db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Сергей on 14.12.2016.
 */
public class AmtServiceImpl implements AmtService {
    Connection connection;
    AmtDAOImpl amtDAO;

    public AmtServiceImpl() {
        this.connection = DBConnection.getConnection();
        amtDAO = new AmtDAOImpl();
    }
    @Override
    public int getAmt(int idPrison) throws SQLException {
        return amtDAO.getAmt(idPrison);
    }
}
