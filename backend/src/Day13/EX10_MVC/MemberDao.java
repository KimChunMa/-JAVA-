package Day13.EX10_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class MemberDao {
	//싱글톤 : 프로그램내 DB연동은 1번만
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {return dao;}
	
	//필드
	private Connection conn = null; // DB구현객체 인터페이스
	private PreparedStatement ps;	// sql 조작
	private Resultset rs; 			// sql 결과
	
	//생성자
	private MemberDao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15","root","1234");
		}catch(Exception e) {
			System.out.println("연동실패"+e.getMessage());
		}
	}
	
	//1.회원가입
	public boolean signup(MemberDto dto) {
		
		String sql ="insert into member (mid,mpw) values(?,?)";
		
		//ps는 매개변수 조작가능
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {System.out.println("오류!" + e.getMessage());}
		return false;
	}//signup e
	
	//2.모든회원출력
	public ArrayList<MemberDto> list() {
		String sql ="select * from member";
		
	try {
		ps = conn.prepareStatement(sql);
		 ps.execute();
	} catch (SQLException e) {
		System.out.println("오류! "+e.getMessage());
	}
		
		
		return null;
	}
		
	
		
	
}//class e
