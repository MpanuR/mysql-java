package projects;

import projects.exception.DbException;
import projects.dao.DbConnection;

public class ProjectsApp {
    public static void main(String[] args) {

        try {
            DbConnection.getConnection();
            System.out.println("Connection successful!");
        } catch (DbException e) {
            System.err.println(e.getMessage());
        }

    }
}
