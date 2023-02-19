package 과제.과제9.영화리뷰;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import 과제.과제9.영화리뷰.imlpement1.공지사항;
import 과제.과제9.영화리뷰.imlpement1.영화리뷰;
import 과제.과제9.영화리뷰.imlpement1.커뮤니티;
import 과제.과제9.영화리뷰.super2.글을쓰기;

public class 실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		글을쓰기 DB = new 글을쓰기();
		
		while(true) {
			
			//1.전체글 출력
			System.out.println("-------------전체 글---------");
			System.out.println("글번호\t제목\t좋아요");
			
			int i = 0;//글번호
			for(글을쓰기 DB글: DB.get글DB()) {
					System.out.println(i+"\t"+DB글.getTitle()+"\t"+DB글.getLike());
				i++;
			}//for e
			
			//1-1.선택지
			System.out.println("1.글보기 2.글쓰기"); int ch0 = sc.nextInt();
			
			// 2.글보기
			if(ch0==1) {
				//글선택
				System.out.println("어떤 글을 보시겠습니까?"); int ch01=sc.nextInt();
				
				DB.get글DB().get(ch01);
				System.out.printf("글번호:%d  글제목:%s \n",ch01 , DB.get글DB().get(ch01).getTitle());
				System.out.printf("좋아요:%d  싫어요:%d \n",DB.get글DB().get(ch01).getLike() , DB.get글DB().get(ch01).getHate());
				System.out.printf("글 내용 :\n%s\n",DB.get글DB().get(ch01).getContents());
				
				//2-1.좋아요,싫어요
				System.out.print("1.좋아요 누르기 2.싫어요 누르기 3.뒤로가기"); 
				if(DB.get글DB().get(ch01) instanceof 커뮤니티) {System.out.print(" 4.코맨트");}
				else {System.out.println();}
				
				int ch02 = sc.nextInt();
				if(ch02 == 1) {
					//안에서 유효성 검사를함
					공지사항 객체1 = new 공지사항(); 객체1.좋아요(DB.get글DB(), ch01);
					영화리뷰 객체2 = new 영화리뷰(); 객체2.좋아요(DB.get글DB(), ch01);
					커뮤니티 객체3 = new 커뮤니티(); 객체3.좋아요(DB.get글DB(), ch01);
					}
				
				else if(ch02 == 2) {
					//혹은 이곳에서 검사
					if(DB.get글DB().get(ch01) instanceof 공지사항) {공지사항 객체1 = new 공지사항(); 객체1.싫어요(DB.get글DB(), ch01);}
					else if(DB.get글DB().get(ch01) instanceof 영화리뷰) {영화리뷰 객체2 = new 영화리뷰(); 객체2.싫어요(DB.get글DB(), ch01);}
					else if(DB.get글DB().get(ch01) instanceof 커뮤니티) {커뮤니티 객체3 = new 커뮤니티(); 객체3.싫어요(DB.get글DB(), ch01);}
					}
				
				else if(ch02 == 4 )
				if( DB.get글DB().get(ch01) instanceof 커뮤니티) {
					System.out.println( ((커뮤니티)(DB.get글DB().get(ch01)) ).getUser() + "를 코맨트합니다"    );
				}else {
					System.out.println("잘못누르셨습니다.");
				}
				
				else if(ch02 ==3) {}
			}
			
			
			//3.글쓰기
			else if(ch0==2) { 
			
			System.out.println("무슨글을 쓰시겠습니까?");
			System.out.println("1.공지사항 2.영화리뷰 3.커뮤니티"); int ch = sc.nextInt();
			
			System.out.println("글 제목을 입력해주세요"); String title = sc.next();
			System.out.println("글 내용을 입력해주세요"); String content = sc.next();
			
			
			//3-1.공지
				if(ch==1) {
					//3-1-1. 글쓰기
					글을쓰기 글 = new 공지사항(title,content); DB.set글DB(글); 
					
					//3-1-2. arrayList에서 공지만 앞에 떙기기
					공지사항.top(DB.get글DB(),글);
				}//ch1 e
				
			//3-2. 영화리뷰
				else if(ch==2) {//제목
					//3-2-1. 글쓰기
					System.out.println("별점을 몇점 남기시겠습니까? (1~5점)"); int star = sc.nextInt();
					
					영화리뷰 글 = new 영화리뷰(title,content,star); 
					
					DB.set글DB(글); 
				
				}//ch2 e
				
				else if(ch==3) {//내용
					//1. 글쓰기
					System.out.println("작성자를 입력해주세요"); String user = sc.next();
					글을쓰기 글 = new 커뮤니티(title,content,user); DB.set글DB(글); 
					
				}//ch3 e
			}//글쓰기 끝
			
		}//while e
		
		
	}//main e
}//실행 e
