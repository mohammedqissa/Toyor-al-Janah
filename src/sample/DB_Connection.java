package sample;

 

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection  {
	public Connection connection = null;

	public Connection getConnection() {
		System.out.println("Mysql Testing");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Store", "root", "159951123");

		} catch (Exception ex) {
			System.out.println("Connection Error");
			ex.printStackTrace();
		} finally {
			if (connection != null) {
				System.out.println("Connection Success");
			} else {
				System.out.println("Connection Failed!");
			}

		}
		return connection;
	}
}