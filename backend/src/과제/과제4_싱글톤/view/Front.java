package 과제.과제4_싱글톤.view;

import java.util.Scanner;

import 과제.과제4_싱글톤.controller.Bcontroller;
import 과제.과제4_싱글톤.controller.Mcontroller;
import 과제.과제4_싱글톤.model.Board;

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
		else {board_page();
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
	public void board_page() { 
		while(true) {
		System.out.println("-------커뮤니티---------");
		System.out.println("번호\t조회수\t작성자\t제목");
		
		
		
		int i = 0;			//현재 게시물에 등록된 ArrayList<Board> boarlist 출력
		for( Board b : Bcontroller.getInstance().getList() ) { // 컨트롤 누른상태 -> 함수 클릭 
			System.out.println( i+"\t"+b.getView()+"\t"+b.getMember().getId()+"\t"+b.getTitle());
			i++;
		}
		
		System.out.println("1.쓰기 2.글보기 3.로그아웃");
		int ch2 =sc.nextInt();
		if(ch2 ==1) {write_page();}
		else if(ch2 ==2) {view_page();}
		else if(ch2 ==3) {Mcontroller.getInstance().logOut(); break;}
		}//while e
	}//board_page() e
	
	
	//게시물 쓰기
	public void write_page() {
		System.out.println("--------------- 글쓰기 페이지 ----------------");
		System.out.print("제목 : "); String title = sc.next();
		System.out.print("내용 : "); String content = sc.next();
		boolean result = Bcontroller.getInstance().write(title, content);
		
		if(result) {System.out.println("등록되었습니다.");}
		else {System.out.println("등록이 실패했습니다.");}
	}
	
	-
	//게시물 상세 페이지
	public void view_page() {
		System.out.println("이동할 게시물 번호[인덱스]:"); 
		int bno = sc.nextInt();
		Board result = Bcontroller.getInstance().getBoard(bno);
		System.out.println("---------- 글 상세페이지 ---------");
		System.out.println("제목 : "+  result.getTitle());
		System.out.println("작성자 : "+  result.getMember().getId() + " 조회수 : " + result.getView());
		System.out.println("내용 : " + result.getContent());
		
		System.out.println("1. 삭제 2.수정 3. 뒤로가기");
		int ch3 = sc.nextInt();
		if( ch3 == 1 ) { delete_page( bno ); }
		else if( ch3 == 2 ) { update_page( bno );}
		else if( ch3 == 3 ) { return; }
	}
	
	//게시물 삭제
	public void delete_page(int bno){
		if(Bcontroller.getInstance().getBoard(bno).getMember().equals(
				Mcontroller.getInstance().getLogSession() ) ) {
			Bcontroller.getInstance().delete(bno);
			System.out.println("삭제 되었습니다.");
			return;
		}else {
			System.out.println("삭제 권한이 없습니다.");
		}
			
	}
	
	//게시물 수정
	public void update_page( int bno ) {
		if( Bcontroller.getInstance().getBoard(bno).getMember().equals(
				Mcontroller.getInstance().getLogSession() )
				) {
			System.out.print(" 새로운 제목 : ");	String title = sc.next();
			System.out.print(" 새로운 내용 : ");	String content = sc.next();
			Bcontroller.getInstance().update(bno, title, content);
			System.out.println(" [알림] 수정이 되었습니다. ");
			return;
		}
		System.out.println(" [알림] 수정 권한이 없습니다. ");
	}
	
}
