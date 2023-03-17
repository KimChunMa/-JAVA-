package model.dao;

import java.sql.SQLException;
import java.sql.Statement;
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
			/*
			insert 이후 자동으로 생성된 auto key => pk값 찾기
		*/
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMimg());
			ps.setString(4, dto.getMemail());
			ps.executeUpdate(); 
			/*방금 회원가입한사람에게 포인트 지급*/
			rs=ps.getGeneratedKeys(); // pk값을 ps로 받기
			if(rs.next()) {
				int pk = rs.getInt(1);
				setPoint("회원가입축하",100,pk);
			}
			
			
			return true;
		} catch (SQLException e) {System.err.println(e);}
		return false;
	}
	
	//멤버 명단 출력
	public ArrayList<MemberDto> memberPrint(int startrow, int listsize) {
		String sql = "select * from member limit "+startrow+" , "+listsize;
		ArrayList<MemberDto> mlist = new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto(
				rs.getInt(1), rs.getString(2), rs.getString(3),
				rs.getString(5), rs.getString(4),0);
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
	
	//특정회원 1명 알기
	public MemberDto getMember(String mid) {
		String sql = "select m.mno , m.mid , m.mimg , m.memail , sum(p.mpamount) as mpoint "
				+ " from member m , mpoint p "
				+ " where m.mno = p.mno and m.mid = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				MemberDto dto = new MemberDto(
				rs.getInt(1), rs.getString(2), null, 
				rs.getString(4) , rs.getString(3),rs.getInt(5)
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
	
	//포인트 설정
	public boolean setPoint(String content , int point , int mno) {
		String sql = "insert into mpoint (mpcomment , mpamount ,mno) values (?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, point);
			ps.setInt(3, mno);
			ps.executeUpdate();
			return true;
		}
		catch(Exception e ) {System.out.println(e);}
		return false;
	}
	
	//9. 회원탈퇴 [인수 : mid /반환 : 성공실패 ]
	public boolean setDelete(String mid , String mpwd) {
		String sql = "delete from member where mid = ? and mpwd=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid); ps.setString(2, mpwd);
			int count = ps.executeUpdate(); // 삭제된 레코드 수 반환
			if(count==1) {return true;} // 1개삭제시 성공 
		}
		catch(Exception e) {}
		return false;
	} 
	
	//10. 회원수정 [인수 : mpwd, memail 반환: 성공 실패]
	public boolean update(String mid , String mpwd , String newmpwd , String memail , String newmimg) {
		System.out.println("dao newmimg : "+ newmimg);
		String sql ="update member set mpwd = ? , memail = ?  , mimg = ? where mid =? and mpwd =?" ;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newmpwd);
			ps.setString(2, memail	);
			ps.setString(3, newmimg);
			ps.setString(4, mid);
			ps.setString(5, mpwd);
			int count = ps.executeUpdate(); // 수정된 레코드 수 반환
			if(count==1) {return true;} // 1개수정시 성공 	
		}
		catch(Exception e) {}
		return false;
	} 
	
	//11 회원 아이디 -> mno 반환
	public int getMno(String mid) {
		String sql = "select * from member where mid = ?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (SQLException e) {System.err.println(e);}
		return 0;
	}
	
	
	//12 총 회원 구하기
	public int getMemberCount() {
		String sql = "select count(*) from member";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (SQLException e) {System.err.println(e);}
		
		return 0;
	}
	
}
