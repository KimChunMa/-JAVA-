package Day07;

import java.util.Scanner;

public class Ex1_회원시스템_배열 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] memberList = new String[3]; 
		
		while(true) {
			
			System.out.println("번호\t회원명\t전화번호");
			for(int i = 0 ; i < memberList.length ; i++) {
				if(memberList[i] != null) { // 널이면 split 오류나옴
					
				String[] member = memberList[i].split(",");
				
				memberList[i].split(",");
				
				System.out.println(i+"\t"+member[0]+"\t"+member[1]);
				}
			}
			
			
			System.out.print("1. 회원등록 2. 회원삭제 : ");
			
			int ch = sc.nextInt(); // 입력값
			
			if(ch == 1) { // 등록시
				System.out.print("회원 명 : "); String name = sc.next();
				System.out.print("전화번호 : "); String tel = sc.next();
				
				for(int i = 0 ; i < memberList.length ; i++) {
					if(memberList[i] == null) {
						memberList[i] = name + "," + tel;
						System.out.println("등록 되었습니다. 정보: " + memberList[i]);
						break; // 빈곳이 3곳이라, 3곳다 저장되는것을 막음
					}//if2 e
				}//for e
			} // if e
			
			else if (ch == 2) { // 삭제 시 
				//splice 없음
				System.out.println("삭제할 번호/인덱스 : ");
				
				int no = sc.nextInt();
				
				memberList[no] = null;
				
				for(int i = no ; i < memberList.length ; i++) {
					if(i+1 == memberList.length) { //마지막 배열이라면 널
						memberList[i] = null;  break;}
					
					memberList[i] = memberList[i+1]; // 한칸씩 떙기기
					
					if(memberList[no+1] == null) { // 옆칸이 null이라면 
						break;
					}//if e
					
				}//for e
				
			}//else if e
			
			
			else { // 오류
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
