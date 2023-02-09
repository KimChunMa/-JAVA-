package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Book> bookList = new ArrayList<>();
		
		Book b1 = new Book(); b1.대여여부 = true; b1.도서장르 = "소설"; b1.도서명 = "행복한편의점";
		bookList.add(b1);
		
		Book b2 = new Book(); b2.대여여부 = true; b2.도서장르 = "에세이"; b2.도서명 = "이것이여행이다";
		bookList.add(b2);
		
		Book b3 = new Book(); b3.대여여부 = true; b3.도서장르 = "전문도서"; b3.도서명 = "이것이자바다";
		bookList.add(b3);
		
		
		ArrayList<Member> memberList = new ArrayList<>();
		
		
		
		while(true) {
				System.out.println("메뉴 : 1.로그인 2.회원가입");
				
				int ch = sc.nextInt();
				
				//멤버 객체 배열 확인,      로그인 성공여부
				int check = -1; boolean check2 = false; 
				
				if(ch==1) { // 로그인시 
						Member m1 = new Member();
						System.out.println("아이디를 입력해주세요"); m1.id = sc.next();
						System.out.println("비밀번호를 입력해주세요"); m1.pw = sc.next();
						
						for(Member m2:memberList) {
							check++; //몇번째 Member 배열인지 확인
							
							if( (m2.id).equals(m1.id) ) {
								if( (m2.pw).equals(m1.pw) ) {
									System.out.println("로그인 성공!"); check2=true;
									break;
								}else {
									System.out.println("로그인 실패하셨습니다.");
								}
							}//if 1 e
						}//for e		
				}//로그인 종료
					
				
				if(ch==2) {//회원가입시
						Member m1 = new Member();
						System.out.println("아이디를 입력해주세요"); m1.id = sc.next();
						System.out.println("비밀번호를 입력해주세요"); m1.pw = sc.next();
						System.out.println("이름를 입력해주세요"); m1.name = sc.next();
						System.out.println("전화번호를 입력해주세요"); m1.tel = sc.next();
						
						memberList.add(m1);
						System.out.println("회원가입되셨습니다.");
				}//회원가입 종료
				
			if(check2 != true) {continue;}
			else {//로그인성공시
				int index=0;
					System.out.println("--------------- 이젠 도서관 ---------------");
					System.out.println("번호\t대여여부\t도서장르\t도서명\t\t대여한사람");
				for(Book book: bookList) { //현재 도서출력
					System.out.print(index+"\t"+book.대여여부 +"\t"+book.도서장르+"\t"+book.도서명+"\t\t" );
					if(book.member != null) {
						System.out.print(book.member.id);
					}
					System.out.println();
					index++;
				}//for e
				
				System.out.println("메뉴 > 1.도서대여 2.도서반납 3.도서등록[관리자] ");
				
				ch = sc.nextInt();
				
				if(ch==1) {//도서 대여시
					System.out.println("무엇을 대여하시겠습니까?");
					int no = sc.nextInt();
					
					if(bookList.get(no).대여여부 ==false) {
						System.out.println("대여할 수 없습니다.");
					}else {
						bookList.get(no).대여여부 = false;
						System.out.println("대여하셨습니다.");
						
						//대여한 책의 멤버를 대여한사람으로 등록
						bookList.get(no).member = memberList.get(check);
						
						//대여한 사람의 대여목록에 현재 책 등록
						 memberList.get(check).rentList.add( bookList.get(no)) ;
					}	
				}//ch==1 e
				
				else if(ch==2){ // 도서반납시 
					System.out.println("반납번호를 입력해주세요");
					int no = sc.nextInt();
					
					//대여여부확인 및 현재대여목록 확인
					if(bookList.get(no).대여여부 == false &&
							memberList.get(check).rentList.contains(bookList.get(no)) ) {
						bookList.get(no).대여여부 =true;
						bookList.get(no).member =null;
						
						//대여한사람의 대여목록을 지워야됨
						memberList.get(check).rentList.remove(bookList.get(no));
						
						System.out.println("반납되었습니다.");
						
					}else {
						System.out.println("대여하지 않은 책 입니다.");
					}
				}//ch==2 e
				
				else if(ch==3) { // 등록시
					Book book = new Book();
					System.out.println("등록할 도서명을 입력해주세요"); book.도서명 = sc.next();
					System.out.println("등록할 도서장르 입력해주세요"); book.도서장르 = sc.next();
					book.대여여부 = true; bookList.add(book);
					System.out.println("등록되었습니다");
				}
				else {
					System.out.println("잘못된 입력 입니다.");
				}	
				
				
			}//로그인 성공 e
			
			
		}//while e 		
	}//main e 
}//class e
				
				
				

