package com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
private static String url="jdbc:mysql://localhost:3306/academy";
private static String username="root";
private static String password="Savita@98";

public static Connection getConnection()
{
	Connection con = null;
		
	try {
		con=DriverManager.getConnection(url,username,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
	
}
}


