package com.ig.courseproject.Util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtil {

	
	public static Connection getConnection()  throws Exception{
		 Properties properties= new Properties();
		 FileInputStream input = new FileInputStream("C:\\javaworkspace\\insight\\mavenapp1\\src\\main\\resources\\jdbc.properties");
		String driver = properties.getProperty("jdbc.driverClassName");
		String url = properties.getProperty("jdbc.url");
		 String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		 
		System.out.println(driver+"  "+url +"  "+username +"  "+password);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname","root","password");
		
		System.out.println("hello");
		return con;
		 
		

}
}