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
		String sql = "insert into member(mid,mpwd,mimg,memail) values(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMimg());
			ps.setString(4, dto.getMemail());
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
	
	//로그인
	public boolean login(String mid, String mpwd) {
		//아이디+비번
		String sql ="select * from member  where mid =? and mpwd=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
			
		}catch(Exception e) {System.out.println(e);}
		
		return false;
	}
	
	public MemberDto getMember(String mid) {
		String sql = "select * from member where mid=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				MemberDto dto = new MemberDto(
				rs.getInt(1), rs.getString(2), null, 
				rs.getString(4) , rs.getString(5)
				);
				return dto;
			}
			
			
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	//아이디 찾기
	public String findid(String memail) {
		String sql = "select mid from member where memail = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getString(1);}
		} catch (SQLException e) {e.printStackTrace();}
		return "false";
	}
	
	//비밀번호 찾기
	public String findpwd(String mid, String memail, String updatePwd) {
		String sql = "select mid from member where mid=? and memail = ?";
		
		try {
			ps =con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs=ps.executeQuery();
			if(rs.next()) {
				sql = "update member set mpwd =? where mid =?";
				ps = con.prepareStatement(sql);
				ps.setString(1,updatePwd);
				ps.setString(2, mid);
				int result = ps.executeUpdate(); //레코드 개수 반환
				if(result == 1) {//업데이트 레코드 1개면
					// -- 이메일전송 테스트 되는경우 만 -- //
					//new MemberDto().sendEmail( memail, updatePwd ); // 임시비밀번호를 이메일로 보내기 
					//return "true";
					// -- 이메일전송 테스트 안되는 경우 -- //
					
					return updatePwd;
				}
			}
		} catch (SQLException e) {e.printStackTrace();}
		return "false";
	}
}
