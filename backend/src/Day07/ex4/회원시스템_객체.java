package Day07.ex4;

import java.util.Scanner;

public class 회원시스템_객체 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Member[] memberList = new Member[3]; // 총 회원
		
		while(true) {
			
			for(int i = 0 ; i < memberList.length ; i++) { 
				if(memberList[i] == null) {	
					break; }
				
				System.out.println( memberList[i].name +"\t" + memberList[i].tel);
			}
			
			
			System.out.print("1. 회원등록 2. 회원삭제 : ");
			
			int ch = sc.nextInt(); // 입력값
			
			if(ch == 1) { // 등록시
				
				for(int i = 0 ; i < memberList.length ; i++) { 
					if(memberList[i] == null) {	//null 이면
						Member member = new Member();
						System.out.println("회원명: "); member.name = sc.next();
						System.out.println("전화번호: ");  member.tel = sc.next();
						memberList[i] = member;
						break; //null값있어도 한번만
					}
				}
				
				
			} // if e
			
			else if (ch == 2) { // 삭제 시 
				
			}//else if e
			
			
			else { // 오류
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
