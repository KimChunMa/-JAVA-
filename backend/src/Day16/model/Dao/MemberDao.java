package Day16.model.Dao;

import java.sql.SQLException;

import Day16.model.Dto.MemberDto;

public class MemberDao extends Dao{
	private MemberDao () {};
	private static MemberDao Mdao = new MemberDao();
	public static MemberDao getInstance() {return Mdao;}
	
	//1. 아이디 중복 체크
	public boolean idCheck(String mid) {
		String sql = "select * from member where mid = ?;";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			// 검색된 레코드있으면 [중복된 아이디]
			if(rs.next()) {return true;} 
			else {return false;}
			
		}catch(Exception e) {System.err.println(e);}
		
		return true;  // 그외
	}
	
	
	//2 회원가입
	public int signup(MemberDto dto) {
		String sql = "insert into Member (mid , mpw , mname , mphone ) values(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getMphone());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 3;
	}
	
	//로그인
	public int login(String mid, String  mpw) {
		String sql = "select * from member where mid = ? and mpw = ? ";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs =  ps.executeQuery();
			
			if(rs.next()) {return rs.getInt(1);}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return 0; //실패
	}
	
	
	
}
