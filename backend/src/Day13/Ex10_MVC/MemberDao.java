package Day13.Ex10_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private ResultSet rs; 			// sql 결과
	
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
		
		ArrayList<MemberDto> list = new ArrayList<>();
		
	try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery(); // 실행된 결과를 보여줌
		//레코드 -> 자바형태 -> 객체 DTO // 레코드 1개 -> DTO 1개 -> 회원1개
		
		while(rs.next()) { //(한줄씩 이동) 다음레코드로 이동 [없으면 false] // 마지막레코드까지
				//rs[null] => rs.next() -> rs[1행] -> rs[2행] -> ,,, -> false
			MemberDto dto = new MemberDto(
			//첫번째 필드,  두번쨰 필드 ,		 세번쨰 필드
			rs.getInt(1),rs.getString(2), rs.getString(3)		 );
			list.add(dto);
		}
		return list;
	} catch (SQLException e) {
		System.out.println("오류! "+e.getMessage());}
	return null;
	} // list e
		
	//3. 비밀번호 수정
	public boolean update(int mno, String mpw) {
		String sql = "update member set mpw = ? where mno = ?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString( 1 , mpw );
			ps.setInt( 2 , mno); 
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("오류! "+e.getMessage());
			return false;}
		return true;
		}
	
	//4. 회원 삭제
	public boolean delete(int mno) {
		String sql = "delete from member where mno=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("오류! "+e.getMessage());
			return false;
		}
		return true;
	}
	
		
}//class e
