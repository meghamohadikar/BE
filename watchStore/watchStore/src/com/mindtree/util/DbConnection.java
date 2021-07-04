package com.mindtree.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static Connection con = null;

	public void createConnection() {
		System.out.println("Connecting");
		System.out.println();
		try {

			Class.forName(Support.DRIVER);
			con = DriverManager.getConnection(Support.URL, Support.USERNAME, Support.PASSWORD);
			if (con != null) {
				System.out.println("Connection established");

			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection Failed");

		}

	}

	public static Connection getConnection() {
		return con;
	}

}
