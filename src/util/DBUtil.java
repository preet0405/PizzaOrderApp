package util;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/preet_pizza_db";
    private static final String USER = "root";         // Change if your MySQL user/pass are different
    private static final String PASS = "";             // Change if your MySQL password is different

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}


