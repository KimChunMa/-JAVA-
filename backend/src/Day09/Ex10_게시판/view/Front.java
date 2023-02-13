package Day09.Ex10_게시판.view;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Day09.Ex10_게시판.controller.Bcontroller;
import Day09.Ex10_게시판.model.Board;



public class Front {
	//싱글톤 
	private static Front fr = new Front();
	private Front() {};
	public static Front getInstance() {return fr;}
	
	//필드
	private Scanner sc = new Scanner(System.in);
	
	
	//index 함수
	public void index() {
		while(true) {
		print_page();
		System.out.println("[알림] 1. 쓰기 , 2. 게시물 보기"); int ch = sc.nextInt();
		if(ch == 1) {writer_page();}
		else if(ch == 2) {view_page();}
		
		
		}//while e
	}
	
	//쓰기 페이지 함수
	private void writer_page() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ글 쓰기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("제목을 입력해주세요"); String title = sc.next();
		System.out.println("내용을 입력해주세요"); String content = sc.next();
		System.out.println("작성자을 입력해주세요"); String writer = sc.next();
		System.out.println("비밀번호를 입력해주세요"); String pw = sc.next();
		Date date = new Date(); int view = 0 ; System.out.println("현재날짜 : "+date+"\n");
		
		boolean result = Bcontroller.getInstance().write(title, content, writer, pw, date, view);
		
		if(result) {System.out.println("글쓰기 성공");}
		else {System.out.println("글쓰기 실패");}
	}
	
	//출력 페이지 함수
	private void print_page() {
		ArrayList<Board> result = Bcontroller.getInstance().print();
		System.out.println("----------------비회원 게시판--------------------");
		System.out.println("번호\t제목\t작성자\t조회수\t작성일");
				
		for( int i = 0 ; i< result.size() ; i++ ) {
			System.out.println( i+"\t" + result.get(i).toString() );}
	}
	
	//상세 페이지
	private void view_page() {
		System.out.println("게시물 번호 : "); int bno = sc.nextInt();
		Board result = Bcontroller.getInstance().view(bno); // 조회수 증가
		System.out.println("제목 : "+ result.getTitle() + "조회수 : "+ result.getView() +"\n");
		System.out.println("작성자 : "+ result.getWriter() +"\t 작성일 : "+ result.getDate());
		System.out.println("내용 : "+ result.getContent());
		
		System.out.print(" >> 1. 뒤로가기 2.삭제 3.수정 : ");
		int ch2 = sc.nextInt();
		if( ch2 == 1 ) { return; }
	}
	
}// class e
