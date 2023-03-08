package model.dao;

import java.sql.SQLException;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	
	private static MemberDao dao = new MemberDao();
	private MemberDao() {};
	public static MemberDao getInstance() {return dao;}
	
	//회원가입
	public boolean signup(MemberDto dto) {
		String sql = "insert into member(mid,mpwd,meamil,ming) values(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			ps.executeUpdate(); return true;
		} catch (SQLException e) {System.err.println(e);}
		return false;
	}
}
