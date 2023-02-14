package 과제.과제4_싱글톤.view;

import java.util.Scanner;

import 과제.과제4_싱글톤.controller.Mcontroller;

public class Front {
	//싱글톤
	private static Front front = new Front();
	private Front() {}
	public	static Front getInstance() {return front;}
	
	Scanner sc = new Scanner(System.in);
	
	//메인페이지
	public void index() {
		while(true){
			System.out.println("-------- 이젠 커뮤니티 ---------");
			System.out.print("1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기 :");
			
			int ch = sc.nextInt();
			if(ch == 1 ) {signup_page();}
			else if(ch == 2 ){login_page();}
			else if(ch==3) {findId_page();}
			else if(ch==4 ) {findPw_page();}
		}
	}
	
	// 회원가입
	public void signup_page() {
		System.out.println("아이디"); 		String id = sc.next();
		System.out.println("비밀번호");		String pw = sc.next();
		System.out.println("비밀번호 확인");	String confirmpw = sc.next();
		System.out.println("이름");			String name = sc.next();
		System.out.println("전화번호");		String phone = sc.next();
		
		int result =Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		if(result == 1) {System.out.println("[알림]회원가입 실패. 비밀번호가 다릅니다.");}
		else if(result == 0 ) {System.out.println("[알림]회원가입 성공. 감사합니다.");}
	}
	
	//로그인
	public void login_page() {
		System.out.println("아이디"); 		String id = sc.next();
		System.out.println("비밀번호");		String pw = sc.next();
		int result = Mcontroller.getInstance().login(id, pw);
		if(result == -1) {System.out.println("[알림]로그인 실패. 비밀번호가 다릅니다.");}
		else if(result == -2 ) {System.out.println("[알림]없는 회원 입니다.");}
		else {System.out.println("로그인 성공! ");}
		
			//계속 켜둬야함
			while(true) {
				board_page();
			}
	}
	
	//아이디 찾기
	public void findId_page() {
		System.out.println("이름"); 		String name = sc.next();
		System.out.println("전화번호");	String phone = sc.next();
		String result = Mcontroller.getInstance().findId(name, phone);
		if(result==null) { System.out.println("없는 회원입니다.");}
		else {System.out.println("회원님의 ID는 "+result +" 입니다.");}
	}
	
	//비밀번호 찾기
	public void findPw_page() {
		System.out.println("ID"); 		String id = sc.next();
		System.out.println("전화번호");	String phone = sc.next();
		String result = Mcontroller.getInstance().findPw(id, phone);
		if(result==null) { System.out.println("없는 회원입니다.");}
		else {System.out.println("회원님의 Pw는 "+result +" 입니다.");}
	}
	
	//로그인 성공
	public void board_page() {}
	//게시물 쓰기
	public void write_page() {}
	//게시물 상세 페이지
	public void view_page() {}
}
