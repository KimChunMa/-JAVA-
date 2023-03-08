package practice.Day02.과제;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class aDao {
	Connection con;
	PreparedStatement pr;
	ResultSet rs;
	
	private static aDao adao = new aDao();
	private aDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/students",
					"root", 
					"1234" 
					);
		} catch (Exception e) {e.printStackTrace();}
	}
	public static aDao getInstance() {return adao;}
	
	//입력
	public boolean setData(aDto adto) {
							
		String sql = "insert into information values(?,?,?,?,?,?,?,?,?)";
				
		try {
			pr = con.prepareStatement(sql);
			pr.setString(1, adto.getName()); pr.setString(2, adto.getTel());
			pr.setFloat(3, adto.getTall()); pr.setInt(4, adto.getAge());
			pr.setString(5, adto.getSubmit()); pr.setString(6, adto.getSex());
			pr.setBoolean(7, adto.isAgree()); pr.setString(8, adto.getRegion());
			pr.setString(9, adto.getIntroduce());
			
			pr.executeUpdate();
		}
		catch (Exception e) {System.out.println(e);}
		
		
		return true;
	}
	
	//출력
	
	public ArrayList<aDto> getData() {
		ArrayList<aDto> list = new ArrayList<>();
		
		String sql = "select * from  information";
		
		try {
			pr = con.prepareStatement(sql);
			rs= pr.executeQuery();
			
			while(rs.next()) {
				aDto adto = new aDto(
				rs.getString(1), rs.getString(2), rs.getFloat(3), 
				rs.getInt(4), rs.getString(5), rs.getString(6), 
				rs.getBoolean(7), rs.getString(8), rs.getString(9) 
				);
				
				list.add(adto);
			}
		}
		catch (Exception e) {System.out.println(e);}
		
		
		return list;
	}
	
}
