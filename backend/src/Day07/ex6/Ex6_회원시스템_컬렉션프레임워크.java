package Day07.ex6;

import java.util.ArrayList;
import java.util.Scanner;


public class Ex6_회원시스템_컬렉션프레임워크 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ArrayList<Member> memberList = new ArrayList<>();
		//ArrayList: 리스트 선언 사용되는 클래스
		//<클래스명>: 리스트 안에 들어갈 항목의 클래스
		
		while(true) {
			
			/*
			 * memberList.forEach((o) -> { System.out.println(o.name +'\t'+o.tel); });
			 */
			System.out.println("번호\t회원명\t전화번호");
			for(int i = 0 ; i<memberList.size(); i++) {
				System.out.println(i+"\t"+memberList.get(0).name + 
									 "\t"+memberList.get(0).tel );
			}

			System.out.print("1. 회원등록 2. 회원삭제 : ");
			
			int ch = sc.nextInt(); // 입력값
			
			if(ch == 1) { // 등록시
				Member member = new Member();
				System.out.print("회원 명 : "); member.name =sc.next();
				System.out.print("전화번호 : "); member.tel = sc.next();
				
				memberList.add(member); // 리스트에 객체 추가
				
				
			} // if e
			
			else if (ch == 2) { // 삭제 시 
				System.out.println("삭제할 번호/인덱스 : "); int no = sc.nextInt();
				
				memberList.remove(no);
				
				
			}//else if e
			
			
			else { // 오류
				System.out.println("잘못된 입력입니다.");
			}
		}
		
	}
}
