package 과제.과제4.view;

import java.util.Scanner;

import 과제.과제4.controller.Mcontroller;

// print, scanner

public class Front {
	Scanner sc =  new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	
	//메인페이지
	public void index() {
		while(true) {
		System.out.println("━━━━━━━━━━━━━━⊱༻ 이젠 커뮤니티 ༺⊰━━━━━━━━━━━━━━");
		System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기");
		int ch = sc.nextInt();
		
		//회원가입
		if(ch == 1) {signup();}
		//로그인
		else if(ch==2) {login();}
		//아이디찾기
		else if(ch==3) {findId();}
		//비밀번호 찾기
		else if(ch==4) {findPw();}
		else {System.out.println("잘못된 입력");}
		
		}
		
	}

	//회원가입 페이지
	void signup() {
		System.out.println("아이디 : ");			String id = sc.next();
		System.out.println("비밀번호 : ");		String pw = sc.next();
		System.out.println("비밀번호 확인 : ");	String confirmpw = sc.next();
		System.out.println("이름 : ");			String name = sc.next();
		System.out.println("전화번호 : ");		String tel = sc.next();
		
	
		int result = mc.signup(id,pw,confirmpw,name,tel);
		
		if(result == 1) {System.out.println("[회원가입 실패]");}
		else if(result == 0) {System.out.println("[회원가입 성공]");}
	}
			
	//로그인 페이지
	void login() {
		System.out.print("아이디: "); 	String id = sc.next();
		System.out.print("비밀번호: "); 	String pw = sc.next();
		
		
		int result = mc.login(id, pw);
		if(result>=0) {System.out.println("[알림] 로그인 성공 ");}
		else if(result == -1) {System.out.println("[알림]비밀번호가 틀렸습니다.");}
		else if(result == -2) {System.out.println("[알림]없는 회원 입니다.");}
		
	}
	
	//아이디찾기 페이지
	void findId() {
		System.out.println("이름 : ");		String name = sc.next();
		System.out.println("전화번호 : ");	String tel = sc.next();
		String result = mc.findId(name,tel);
		if(result == null) {
			System.out.println("[알림] 일치하는 회원정보가 없습니다. ");
		}else {
			System.out.println("[알림] 회원님의 아이디 : "+ result);
		}
		
	}			
	
	
	//비밀번호 찾기 페이지
	void findPw() {}
}
