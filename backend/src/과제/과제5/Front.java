package 과제.과제5;

import java.util.Scanner;

import 과제.과제5.controller.MController;



public class Front {
	//싱글톤
	private static Front front = new Front();
	private Front() {}
	public	static Front getInstance() {return front;}
	
	Scanner sc = new Scanner(System.in);
	
	//메인페이지
	public void index() {
		while(true){
			System.out.println("-------- 중고나라 ---------");
			System.out.print("1.회원가입 2.로그인 ");
			
			int ch = sc.nextInt();
			if(ch == 1 ) {signup_page();}
			else if(ch == 2 ){login();}

		}
	}
	
	// 회원가입
	public void signup_page() {
		System.out.println("아이디"); 		String id = sc.next();
		System.out.println("비밀번호");		String pw = sc.next();
		
		int result = MController.getInstance().signUp(id,pw);
		if(result == 0 ) {System.out.println("[알림]회원가입 성공. 감사합니다.");}
	}
	
	//로그인
	public void login() {
		System.out.println("아이디"); 		String id = sc.next();
		System.out.println("비밀번호");		String pw = sc.next();
		int result = MController.getInstance().login(id, pw);
		if(result == -1) {System.out.println("[알림]로그인 실패. ");}
		else { System.out.println("로그인 성공!"); board_page();}
	}
	

	
	//로그인 성공
	public void board_page() { 
		while(true) {
		System.out.println("-------중고나라---------");
		System.out.println("번호\t이름\t가격");
		
		for(Product p : PController.getInstance.ProductDB) {
			System.out.println(p.pname);
			System.out.println(p.price);
		}//for e
		
		
		}//while e
	}
	
}
