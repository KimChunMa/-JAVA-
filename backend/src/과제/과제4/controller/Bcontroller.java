package 과제.과제4.controller;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제4.model.Board;
import 과제.과제4.model.Member;


public class Bcontroller {//로그인시 함수 클래스
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Board> boardDB = new ArrayList<>();
	
	public int board_print(int result, Mcontroller mc) { // 로그인 시작시 첫페이지
		while(true) {
			System.out.println("━━━━━━━━━━━━━━⊱༻ 이젠 커뮤니티 ༺⊰━━━━━━━━━━━━━━");
			System.out.println("번호\t조회수\t작성자\t제목");
			int idx= 0 ;
			for(Board bo: boardDB ) {
				System.out.printf("%d\t%d\t%s\t%s\n",idx,bo.view,bo.writer,bo.title);
				idx++;
			}
			
			
			System.out.println("1.글쓰기 2.글보기 3.로그아웃");
			int ch = sc.nextInt();
			
			
			if(ch==3) {return 3;} //로그아웃
			
			else if(ch==1) { //글 쓰기
				System.out.println("제목을 입력해주세요"); String title = sc.next();
				System.out.println("내용을 입력해주세요"); String content = sc.next();
				
				//작성자 = 현재 로그인한 사람이름
				String writer = mc.memberDB.get(result).name;
				Board board = new Board(title, content, writer);
				boardDB.add(board);
				System.out.println("글이 등록되었습니다.");
			}//if ch 1 e	
			
			else if(ch==2) {//글 보기
				int idx2 = 0; // 인덱스확인용
				System.out.println("번호\t조회수\t작성자\t제목");
				
				for(Board bo: boardDB ) {
					System.out.printf("%d\t%d\t%s\t%s\n",idx,bo.view,bo.writer,bo.title);
					idx2++;
				}
				System.out.println("게시글 끝");
			}//if ch 2 e
			
		}
	}
}
