package 과제.과제4.view;

import java.util.Scanner;

import 과제.과제4.controller.Mcontroller;

// print, scanner

public class Front {
	Scanner sc =  new Scanner(System.in);
	//메인페이지
	public void index() {
		while(true) {
		System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기");
		int ch = sc.nextInt();
		
		if(ch == 1) {signup();}
		else if(ch==2) {login();}
		else if(ch==3) {findId();}
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
		Mcontroller mc = new Mcontroller();
		int result = mc.signup(id,pw,confirmpw,name,tel);
		
		if(result == 1) {System.out.println("회원가입실패");}
		else if(result == 0) {System.out.println("회원가입성공");}
	}
			
	//로그인 페이지
	void login() {}
	
	//아이디찾기 페이지
	void findId() {}		
	
	
	//비밀번호 찾기 페이지
	void findPw() {}
}
