package com.ig.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ig", "root", "Vard1234@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
