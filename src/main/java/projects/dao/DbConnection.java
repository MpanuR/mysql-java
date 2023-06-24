package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.DbException;

public class DbConnection {

    private static String URL = "jdbc:mysql://localhost:3306/projects";
    private static String USERNAME = "projects";
    private static String PASSWORD = "projects";

    public static Connection getConnection() throws DbException {

        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new DbException("Error connecting to the database.", e);
        }

    }
}
