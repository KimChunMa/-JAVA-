package 과제.과제2;

import java.util.Scanner;

public class 키오스크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//가격            재고           장바구니 갯수
		int a = 300; int a_num = 10; int a_sum = 0;//콜라 
		int b = 400; int b_num = 8;  int b_sum = 0;//사이다
		int c = 500; int c_num = 15; int c_sum = 0;//환타 
		int sum = 0;  // 총가격
		
		while(true) {
			System.out.println("1.콜라 2.사이다 3.환타 4.결제");
			
			int order = sc.nextInt();
			
			if(order == 1 ){ //콜라
				if(a_num>0) {
					sum += a;	a_num--; a_sum++;
					System.out.println("콜라를 담았습니다.");
				}else {System.out.println("재고가 없습니다.");}
				
				
			}else if(order == 2 ){ //사이다
				if(b_num>0) {
					sum += b;	b_num--; b_sum++;
					System.out.println("사이다를 담았습니다.");
				}else {System.out.println("재고가 없습니다.");}
				
				
			}else if(order == 3 ){ //환타
				if(c_num>0) {
					sum += c;	c_num--; c_sum++;
					System.out.println("환타를 담았습니다.");
				}else {System.out.println("재고가 없습니다.");}
				
				
			}else if(order == 4) { //주문시
				System.out.println("----------------------");
				System.out.println("제품명    수량       가격 ");
				System.out.printf ("콜라      %d        %d \n",a_sum, (a_sum*a) );
				System.out.printf ("사이다    %d        %d \n",b_sum, (b_sum*b) );
				System.out.printf ("환타      %d        %d \n",c_sum, (c_sum*c) );
				System.out.printf ("총가격   %d \n",sum );
			
				System.out.println("1. 결제 2.취소");
				int order2 = sc.nextInt();
				
				if(order2 == 1) { //결제시
					System.out.println("넣을 돈을 입력해주세요");
					
					int pay = sc.nextInt();
					
					if(pay>sum) {
						pay -= sum;
						System.out.printf("거스름돈은 %d원 입니다\n",pay);
						sum = 0; a_sum = 0 ;  b_sum = 0 ;  c_sum = 0 ;  //장바구니 초기화
					}else {
						System.out.println("금액이 부족합니다.");
						a_num += a_sum; b_num += b_sum;  c_num += c_sum; // 재고 차감수만큼 되돌리기 
						sum = 0; a_sum = 0 ;  b_sum = 0 ;  c_sum = 0 ;  //장바구니 초기화
					}
				}else if(order ==2) { //취소시
					System.out.println("취소합니다.");
					a_num += a_sum; b_num += b_sum;  c_num += c_sum; // 재고 차감수만큼 되돌리기 
					sum = 0; a_sum = 0 ;  b_sum = 0 ;  c_sum = 0 ;  //장바구니 초기화
				}
			} //order ==4 e
			
			else {
				System.out.println("잘못된 입력입니다.");
			}
		}//while e
	}//main e
}//class e
