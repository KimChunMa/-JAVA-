package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Book> bookList = new ArrayList<>();
		
		Book b1 = new Book(); b1.대여여부 = "가능"; b1.도서장르 = "소설"; b1.도서명 = "행복한편의점";
		bookList.add(b1);
		
		Book b2 = new Book(); b2.대여여부 = "불가능"; b2.도서장르 = "에세이"; b2.도서명 = "이것이여행이다";
		bookList.add(b2);
		
		Book b3 = new Book(); b3.대여여부 = "가능"; b3.도서장르 = "전문도서"; b3.도서명 = "이것이자바다";
		bookList.add(b3);
		
		
		ArrayList<Member> memberList = new ArrayList<>();
		
		
		
		while(true) {
				System.out.println("--------------- 이젠 도서관 ---------------");
				System.out.println("번호\t대여여부\t도서장르\t도서명");
				
			int index=0;
				
			for(Book book: bookList) {
				System.out.println(index+"\t"+book.대여여부 +"\t"+book.도서장르+"\t"+book.도서명 );
				index++;
			}
			
			
			System.out.println("메뉴 > 1.도서대여 2.도서반납 3.도서등록[관리자] 4. 회원제");
			
			int ch = sc.nextInt();
			
			if(ch==1) {//도서 대여시
				System.out.println("무엇을 대여하시겠습니까?");
				int no = sc.nextInt();
				
				if(bookList.get(no).대여여부.equals("불가능")) {
					System.out.println("대여할 수 없습니다.");
				}else {
					bookList.get(no).대여여부 = "불가능";
					System.out.println("대여하셨습니다.");
				}
				
				
			}//ch==1 e
			
			else if(ch==2){ // 도서반납시 
				System.out.println("무엇을 반납하시겠습니까?");
				int no = sc.nextInt();
				
				if(bookList.get(no).대여여부.equals("불가능")) {
					bookList.get(no).대여여부 ="가능";
					System.out.println("반납되었습니다.");
				}else {
					System.out.println("대여하지 않은 책 입니다.");
				}
			}//ch==2 e
			
			else if(ch==3) { // 등록시
				Book book = new Book();
				System.out.println("등록할 도서명을 입력해주세요"); book.도서명 = sc.next();
				System.out.println("등록할 도서장르 입력해주세요"); book.도서장르 = sc.next();
				book.대여여부 = "가능"; bookList.add(book);
				System.out.println("등록되었습니다");
			}
			
			else if(ch==4) { // 회원제
				System.out.println("1.로그인 2.회원가입");
				int no = sc.nextInt();
				
				if(no==1) { // 로그인시 
					Member m1 = new Member();
					System.out.println("아이디를 입력해주세요"); m1.id = sc.next();
					System.out.println("비밀번호를 입력해주세요"); m1.pw = sc.next();
					System.out.println("이름를 입력해주세요"); m1.name = sc.next();
					System.out.println("전화번호를 입력해주세요"); m1.tel = sc.next();
					
					
					
					
					
				}
				
				
				
				
				if(no==2) {//회원가입시
					Member m1 = new Member();
					System.out.println("아이디를 입력해주세요"); m1.id = sc.next();
					System.out.println("비밀번호를 입력해주세요"); m1.pw = sc.next();
					System.out.println("이름를 입력해주세요"); m1.name = sc.next();
					System.out.println("전화번호를 입력해주세요"); m1.tel = sc.next();
					
					memberList.add(m1);
					System.out.println("회원가입되셨습니다.");
					
				}
				
				
				
			}
			
			
			else {
				System.out.println("잘못된 입력 입니다.");
			}
			
		}
	}
}
