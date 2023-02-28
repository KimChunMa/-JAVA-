package Day16.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day16.controller.BController;
import Day16.controller.MController;
import Day16.model.Dto.BoardDto;
import Day16.model.Dto.CategoryDto;


public class BoardView {
	private static BoardView boardView = new BoardView();
	private BoardView () {}
	public static BoardView getInstance() {return boardView;}
	
	private Scanner sc = new Scanner(System.in);
	
	//index
	public void index() {
		while(true) {
			System.out.println("============ 로그인 ===========");
			boardPrintRecent(); categoryPrint();
			System.out.println("\n-1:로그아웃 / 0: 갤러리 추가 / 이동할 갤러리 번호 선택 : ");
			int ch = sc.nextInt();
			if(ch==-1) {
				MController.getInstance().setLoginSession(0);
				System.out.println("[로그아웃 완료]");
				break;
			}
			else if(ch==0){categoryAdd();}
			else if(ch > 0 ) {boardPrint(ch); }
			
		}
	} // index
	
	//카테고리 추가
	public void categoryAdd() {
		System.out.println("============ 갤러리 추가 ===========");
		System.out.print(" 추가할 갤러리 입력 : "); 
		sc.nextLine();
		String cname = sc.next();
		
		boolean result = BController.getInstance().categoryAdd(cname);
		if(result) {System.out.println("[등록성공] 갤러리 추가 되었습니다.");}
		else {System.out.println("[등록실패] 관리자에게 문의");}
	}
	
	//모든 카테고리 호출
	public void categoryPrint() {
		ArrayList<CategoryDto> clist = BController.getInstance().categoryPrint();
		
		int count = 0;
		for(CategoryDto dto : clist) {
			System.out.print(dto.getCno() + " - " + dto.getCname() + "\t");
			//4번씩
			count++;
			if(count % 4 == 0 )System.out.println();
		}
	}
	
	// 4. 게시물 쓰기 페이지 
		public void boardAdd(int cno) {
			System.out.println(" =============== 게시물 쓰기 ============== ");
			System.out.print(" 제목 : " ); 	String btitle = sc.next();
			System.out.print(" 내용 : " );	String bcontent = sc.next();
			
			boolean result = BController.getInstance().boardAdd( btitle, bcontent ,cno);
			if( result ) { System.out.println("[글등록성공]");}
			else { System.out.println("[글등록실패]");}
			
		}
	
	// 5. 최신 글 3개 출력 페이지
		public void boardPrintRecent() {
			System.out.println("---------------최신 갤러리---------");
			ArrayList< BoardDto > blist = BController.getInstance().boardPrintRecent();
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s \n" ,
								"번호" , "제목" , "작성자" , "조회수" , "갤러리","작성일");
			for( BoardDto dto : blist  ) {
				System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s \n" ,
						dto.getBno() , dto.getBtitle() , dto.getMid() ,
						dto.getBview() , dto.getCname(),dto.getBdate() );
			}
		}
	
		// 6. 선택한 갤러리의 모든 게시물 페이지 
		public void boardPrint( int cno ) {
			System.out.println(" =============== 선택한 갤러리 ============== ");
			ArrayList<BoardDto> blist = BController.getInstance().boardPrint(cno);
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s \n" ,
							"번호" , "제목" , "작성자" , "조회수" ,  "작성일" );
			for( BoardDto dto : blist  ) {
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s \n" ,
					dto.getBno() , dto.getBtitle() , dto.getMid() ,
					dto.getBview()  , dto.getBdate() );
			} // for end 
			while( true ) {
				System.out.print("갤러리 메뉴 : 1.뒤로가기 2.게시물쓰기 3.게시물보기 : ");
				int ch = sc.nextInt();
				if( ch == 1 ) { break; }
				else if( ch == 2 ) { boardAdd( cno ); }
				else if( ch == 3 ) {  
					// 미구현
				}
			}
		}
}
