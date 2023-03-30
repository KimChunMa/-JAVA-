package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Dao {
	
	public static Connection con;
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public static Connection getConnection() throws Exception {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/xe",
					"root",
					"1234"
					);
		
			return con;
	}
	
	public Dao() {
		try {
		con = getConnection();
		}catch(Exception e) {System.out.println(e);}
	}
}
