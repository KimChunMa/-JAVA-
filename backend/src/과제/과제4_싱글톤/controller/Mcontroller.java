package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4_싱글톤.model.Member;

public class Mcontroller {
	//싱글톤 : 다른곳에서 해당 객체를 공유하는 메모리 [멤버 = 필드, 메소드]
	
	private static Mcontroller mc = new Mcontroller();
	private Mcontroller() {};
	public static Mcontroller getInstance() {
		return mc;
	}
	//외부에서 getInstance를 사용할려면 객체가 필요한데 외부에선 못만드니 정적멤버
	
	
	//DB
	private ArrayList<Member> memberDB = new ArrayList<>();
	
	//필드 (로그인)
	private Member logSession = null;
	
	public Member getLogSession() {
		return logSession;
	}
	
	//회원가입
	public int signup( String id  , String pw, String confirmpw, 
					   String name, String phone) {
		//일치하지 않을 시
		if(!pw.equals(confirmpw)) { return 1;}
		
		//id,pw,name,phone 스택영역에서 저장된 힙 주소 전달 
		// ArrayList<>() 힙영역에서 생성된 힙주소 전달
		Member m = new Member(id,pw,name,phone, new ArrayList<>());
		memberDB.add(m);
		return 0 ;
	}
	
	//로그인 처리
	public int login (String id, String pw) {
		
		for(int i=0 ; i < memberDB.size(); i++) {
			if(memberDB.get(i).getId().equals(id)) {
				if(memberDB.get(i).getPw().equals(pw)) {
					System.out.println("로그인 성공");
					logSession = memberDB.get(i);
					return i ;
				}else {
					return -1;
				}//pw e
			}//id e
		}//for e
		return -2;
	}//login e
	
	
	//아이디 찾기
	public String findId(String name, String phone) { 
		for(Member m : memberDB) {
			if(m.getName().equals(name)) {
				if(m.getPhone().equals(phone) ) {
					return m.getId();
				}
			}
		}
		return null;
	}
	
	//비밀번호 찾기
	public String findPw(String id, String phone) {
		for(Member m : memberDB) {
			if(m.getId().equals(id)) {
				if(m.getPhone().equals(phone) ) {
					return m.getPw();
				}
			}
		}
		return null;
	}
	
	//로그아웃
	public boolean logOut() {
		logSession = null; // 로그인 성공한 회원 객체 지우기
		return true;
	}
	
	
}
