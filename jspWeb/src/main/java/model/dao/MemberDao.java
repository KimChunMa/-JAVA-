package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	
	private static MemberDao dao = new MemberDao();
	private MemberDao() {};
	public static MemberDao getInstance() {return dao;}
	
	//회원가입
	public boolean signup(MemberDto dto) {
		String sql = "insert into member(mid,mpwd,memail,mimg) values(?,?,?,?)";
		
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
	
	//멤버 명단 출력
	public ArrayList<MemberDto> memberPrint() {
		String sql = "select * from member;";
		ArrayList<MemberDto> mlist = new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto(
				rs.getInt(1), rs.getString(2), rs.getString(3),
				rs.getString(4), rs.getString(5));
				mlist.add(dto);
			}
			return mlist;
		} catch (SQLException e) {System.err.println(e);}
		
		return null;
	}
	
	//아이디 중복검사
	public boolean idCheck(String mid) {
		String sql = "select * from member where mid = '" + mid+"'";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) { return true;}
		} catch (SQLException e) {System.out.println(e);}
		
		return false;
	}
}
