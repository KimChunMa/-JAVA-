package Day04;

import java.util.Scanner;

public class Ex2_예금 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//누적액					계좌번호						패스워드
		int balance = 0;	String account = "123-1234"; short pw = 1234;
		
		while(true) { // 무한루프
			System.out.println("-----------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("-----------------");
			System.out.println(">> 선택 : ");
			int ch = sc.nextInt();
			
			if(ch == 1) { //예금
				System.out.println("예금할 계좌번호:");
				String inaccount = sc.next();
				
				if(account.equals(inaccount)) { // 계좌번호 일치시
					System.out.println("예금 금액:");
					balance += sc.nextInt();
					System.out.printf("예금후 금액: %d \n",balance);
				}else {
					System.out.println("없는 계좌번호입니다.");
				}
				
				
				
			}else if(ch == 2) {
				
				System.out.println("출금할 계좌번호:");
				String inaccount = sc.next();
				
				if(account.equals(inaccount)) { // 계좌번호 일치시
					
					System.out.println("비밀번호를 입력해주세요.");
					short inpw = sc.nextShort();
					
					if(inpw == pw) { // 비번 일치시
						System.out.println("출금 금액:");
						
						int pay = sc.nextInt();
						
						if(pay<=balance) {
							balance -= sc.nextInt();
							System.out.printf("출금후 금액: %d \n",balance);
						}else {
							System.out.println("금액이 부족합니다");
						}
						
						
					}else {
						System.out.println("비밀번호가 틀렸습니다.");
					}
					
				}else {	
					System.out.println("없는 계좌번호입니다.");
				}
				
				
			}else if(ch == 3) {	
				
				System.out.println("확인할 계좌번호:");
				String inaccount = sc.next();
				
				if(account.equals(inaccount)) {	// 계좌번호 일치시
					System.out.printf("총 금액: %d \n",balance);
				}else {
					System.out.println("없는 계좌번호입니다.");
				}
				
				
			}else if(ch == 4) {
				System.out.println("종료합니다");
				break;
			
			}else {
				System.out.println("오류");
			}
		}
	}
}
