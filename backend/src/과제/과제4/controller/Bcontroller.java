package 과제.과제4.controller;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제4.model.Board;
import 과제.과제4.model.Member;


public class Bcontroller {//로그인시 함수 클래스
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Board> boardDB = new ArrayList<>();
	
				//로그인된 memberDB의 배열 위치, 
	public int board_print(int mDB_num, Mcontroller mc) { // 로그인 시작시 첫페이지
		while(true) {
			
			//글 출력
			System.out.println("━━━━━━━━━━━━━━⊱༻ 이젠 커뮤니티 ༺⊰━━━━━━━━━━━━━━");
			System.out.println("번호\t조회수\t작성자\t제목");
			int idx= 0 ;
			for(Board bo: boardDB ) {
				System.out.printf("%d\t%d\t%s\t%s\n",idx,bo.view,bo.writer,bo.title);
				idx++;
			}
			
			System.out.println("1.글쓰기 2.글보기 3.로그아웃");
			int ch = sc.nextInt();
			
			
			if(ch==1) { //글 쓰기
				System.out.println("제목을 입력해주세요"); String title = sc.next();
				System.out.println("내용을 입력해주세요"); String content = sc.next();
				
				//작성자 = 현재 로그인한 사람이름
				String writer = mc.memberDB.get(mDB_num).name;
				Board board = new Board(title, content, writer);
				boardDB.add(board);
				System.out.println("글이 등록되었습니다.");
			}//if ch 1 e	
			
			else if(ch==2) {//글 보기
				System.out.println("몇번째 글을 보시겠습니까?"); int board_num= sc.nextInt();
				
				while(true) {
					boardDB.get(board_num).view++; // 보기전 조회수 1 증가
					System.out.println("----------- 글 상세 ---------------");
					System.out.println("제목 : " + boardDB.get(board_num).title);
					System.out.printf("작성자 : %s \t 조회수 : %s \n", boardDB.get(board_num).writer , boardDB.get(board_num).view);
					System.out.println("내용 : "+ boardDB.get(board_num).content);
					
					System.out.println("메뉴> 1.글삭제 2.글수정 3.뒤로가기 ");  int ch2= sc.nextInt();
					
						if(ch2==1) {//글 삭제
							//작성자와 아이디가 같을수 없어, 작성자와 현재로그인된 회원이름으로 바꿈
							if(boardDB.get(board_num).writer.equals(mc.memberDB.get(mDB_num).name) ) {
								System.out.println("삭제성공!"); boardDB.remove(board_num);
								break; // 글보기 while를 나와야됨
							}else {System.out.println("권한없음");}
						}//ch2 1 e
						
						else if(ch2 == 2 ) {//글 수정
							if(boardDB.get(board_num).writer.equals(mc.memberDB.get(mDB_num).name) ) {
								System.out.println("-------- 글 수정 -------------");
								System.out.println("새로운 내용 : "); 
								
								String b_content = sc.next();
								boardDB.get(board_num).content = b_content;
								
								System.out.println("수정되었습니다."); 
								break; // 글보기 while를 나와야됨
							}else {System.out.println("권한없음");}
						}
					
						else if(ch2 == 3 ) {break;} // 뒤로가기
				}//while e
				
			}//if ch 2 e
			
			else if(ch==3) {return 3;} //로그아웃
		}//while e
	}//board_print e 
}//class e
