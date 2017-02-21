package DAO;

import db.DBConnection;
import models.Prisoner;
import services.PrisonerServiceImpl;

import java.sql.*;

/**
 * Created by Сергей on 11.12.2016.
 */
public class test {
    public static void main(String[] args) throws SQLException {
        PrisonerServiceImpl prisonerService = new PrisonerServiceImpl();
        Date date = Date.valueOf("1996-07-07");
        Prisoner prison = new Prisoner("gdg", "gdfgd", date, date, date, 8);
        prisonerService.create(prison);
    }
}
