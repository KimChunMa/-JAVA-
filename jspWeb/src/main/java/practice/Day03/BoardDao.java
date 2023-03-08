package practice.Day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static BoardDao BDao = new BoardDao();
	public static BoardDao getInstance() {return BDao;}
	
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspWap",
					"root",
					"1234"
					);
					
			
		}catch (Exception e) {System.err.println(e);}
	}
	
	//등록
	public boolean onwriter(BoardDto dto) {
		String sql = "insert into ex3(bcontent , bwriter) value(?,?)";
		
		try {
			ps=con.prepareCall(sql);
			ps.setString(1, dto.getBcontent());
			ps.setString(2, dto.getBwriter());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	//출력
	public ArrayList<BoardDto> onprint() {
		String sql = "select * from ex3";
		ArrayList<BoardDto> blist = new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto = new BoardDto(
				rs.getInt(1), rs.getString(2) , rs.getString(3), rs.getString(4)
				);
				blist.add(boardDto);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return blist;
	}
	
	//삭제
	public boolean onDel(int bno) {
		String sql = "delete from ex3 where bno=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return true;
	}
	
	//업데이트
	public boolean onEdit(String newContent ,int bno) {
		String sql = "update ex3 set bcontent=? where bno =?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newContent);
			ps.setInt(2, bno);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return true;
	}
	
	
}
