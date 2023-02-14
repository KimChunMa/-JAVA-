package 과제.과제4_싱글톤.controller;

public class Mcontroller {
	
	//회원가입
	public int signup( String id  , String pw, String confirmpw, 
					   String name, String phone) {
		
		return 0 ;
	}
	
	//로그인 처리
	public int login (String id, String pw) {
		return -2;
	}
	
	//아이디 찾기
	public String findId(String name, String phone) { 
		
		return null;
	}
	
	//비밀번호 찾기
	public String findPw(String id, String phone) {
		
		return null;
	}
	
	//로그아웃
	public boolean logOut() {
		return true;
	}
	
	
}
