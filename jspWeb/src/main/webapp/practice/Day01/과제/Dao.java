package Day01.과제;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Dao {
	Connection con ;
	PreparedStatement ps;
	ResultSet rs;
	
	
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	private Dao() {
		try {
			// 웹 서버 : 해당 MYSOQ 드라이버[라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver"); //  
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsp",
					"root",
					"1234"
					);
			System.out.println("연동 성공");
		} catch (Exception e) {System.out.println(e);}
		
	}
	
	public boolean setData(String data) {
		String sql = "insert into data0 values (?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {e.printStackTrace();}
		
		
		return false;
	}
	
	public ArrayList<String> getData() {
		String sql = "select * from data0 ";
		
		ArrayList<String> list = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
		} catch (SQLException e) {e.printStackTrace();}
		
		
		return list;
	}
	
}
