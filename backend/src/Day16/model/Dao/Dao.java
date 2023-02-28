package Day16.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	protected Connection con;		//DB연동
	protected PreparedStatement ps;	//조작
	protected ResultSet rs;			//결과
	
	public Dao() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardDb","root","1234"
					);
		} catch (SQLException e) {System.out.println(e);}
				
	}
}
