package db;

import java.sql.*;


/**
 * Created by Сергей on 25.11.2016.
 */

public final class DBConnection {
    public static Connection connection;

    public static Connection getConnection()  {
        String url = "jdbc:mysql://localhost:3306/";
        String name = "prisons";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "root";
        if (connection == null) {
            try {
                Class.forName(driver).newInstance();
                connection = DriverManager.getConnection(url + name, username, password);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }
}
