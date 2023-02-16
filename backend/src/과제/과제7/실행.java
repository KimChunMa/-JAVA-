package 과제.과제7;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		ArrayList<은행> bankDB = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("------------- 계좌 관리 ---------------");
			System.out.println("은행명\t\t계좌번호\t\t\t예금액");
			for(int i =0; i < bankDB.size(); i++) {
				
				String bankCode = bankDB.get(i).code;
				
				String bankName = "";
				
				if(bankCode.equals("03")) {
					bankName = "신한";
				}else if(bankCode.equals("04")) {
					bankName = "국민";
				}else if(bankCode.equals("05")) {
					bankName = "우리";
				}
				
				System.out.printf("%s\t\t%s\t\t%d\n", 
						bankName,
						bankDB.get(i).account,
						bankDB.get(i).amount);
			}
			System.out.print("메뉴 > 1.계좌생성 2.예금 : ");
			int choice = scanner.nextInt();
			if(choice == 1) { //1.계좌생성
				System.out.println("------------- 계좌 생성 ---------------");
				
				System.out.println("1. 신한은행 2.국민은행 3.우리은행 : ");
				int bankChoice = scanner.nextInt();
				
				if(bankChoice == 1) { //1. 신한 은행
					신한 계좌 = new 신한();
					은행 계좌1 = 계좌.make_Account();
					bankDB.add(계좌1);
					
				}else if(bankChoice == 2) { //2. 국민 은행
					국민 계좌 = new 국민();
					은행 계좌1 = 계좌.make_Account();
					bankDB.add(계좌1);
					
				}else if(bankChoice == 3) { //3. 우리 은행 
					신한 계좌 = new 신한();
					은행 계좌1 = 계좌.make_Account();
					bankDB.add(계좌1);
				}
				
			}else if(choice == 2) {//2. 예금
				System.out.print("계좌번호 : "); String code = scanner.next();
				
				int i =0;
				for(은행 user : bankDB) {
					if(user.account.equals(code)) {
						System.out.print("예금액 : ");  int money = scanner.nextInt();
						bankDB.get(i).amount += money; System.out.println("예금되었습니다");
					}
					i++;
				}//for e
					
			}//choice ==2 e
		}
	}

}
