package Day16.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day16.controller.MController;
import Day16.model.Dto.BoardDto;
import 과제.과제4_싱글톤.controller.Bcontroller;

public class IndexView {
	private static IndexView indexView = new IndexView();
	private IndexView () {}
	public static IndexView getInstance() {return indexView;}
	
	private Scanner sc = new Scanner(System.in);
	
	public void index() {
		while(true) {
			System.out.println("---------- 이젠 갤러리 --------");
			System.out.println("메뉴 1. 로그인 2. 회원가입");
			
			try{
				int ch = sc.nextInt();
				if(ch == 1) { login();}
				else if (ch == 2) {singup();}
				
			}catch(Exception e) {
				System.err.println("잘못된 입력입니다."); 
				sc = new Scanner(System.in);
				}
		}
	} // index e

	//1. 로그인
	public void login() {
		System.out.println("======= 로그인 화면 =======");
		System.out.print("아이디를 입력해주세요 : "); 	String mid = sc.next();
		System.out.print("비밀번호를 입력해주세요 : "); String mpw = sc.next();
		
		boolean result = 
				MController.getInstance().login( mid , mpw );
		if( result == true ) {
			System.out.println("[로그인성공]");
			// 게시물 초기메뉴로 이동 
			BoardView.getInstance().index();
		}
		else { System.out.println("[로그인실패]");}
	}
	
	
	
	// 2. 회원가입
	public void singup() throws Exception{ // 오류발생시 호출한곳으로 예외 이동
		System.out.println("============회원가입=========");
		System.out.print("아이디 : ");		String mid = sc.next();
		System.out.print("비밀번호 : ");		String mpw = sc.next();
		System.out.print("이름 : ");			String mname = sc.next();
		System.out.print("전화번호 : ");		String mphone = sc.next();
		
		int result = MController.getInstance().singup(mid, mpw, mname, mphone);
		if(result == 1 ) {System.out.println("회원가입 성공!");}
		else if(result == 2 ) {System.out.println("사용중인 아이디 입니다!");}
		else if(result == 3 ) {System.out.println("시스템오류 관리자에게 문의");}
	}
	
	
}
