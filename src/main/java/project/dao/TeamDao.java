package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TeamDao {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME = "c##iidev";
    private static final String PASSWORD = "123456";

    protected Connection getConnection() throws SQLException {
    	try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
