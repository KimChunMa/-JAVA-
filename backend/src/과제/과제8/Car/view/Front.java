package 과제.과제8.Car.view;

import java.util.Scanner;

import 과제.과제8.Car.controller.run;
import 과제.과제8.Car.model.대형;
import 과제.과제8.Car.model.소형;
import 과제.과제8.Car.model.중형;



public class Front {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		run run = new run();
		
		// 목적지 입력
		System.out.println("목적지를 입력하세요.");
		System.out.println("1. 대전 2. 대구 3. 부산");
		int ch2 = sc.nextInt();
		
		int ch1 = 0;
		// 목적지 입력시 지역값 대입
		if(ch2 == 1) ch1 = 20;
		if(ch2 == 2) ch1 = 30;
		if(ch2 == 3) ch1 = 36;
		
		// stopper
		int x= 0;
		int y= 0;
		int z= 0;
		
		
	no : for(int i = 1 ; i <=20 ; i++) {
			
		//첫 시작에 지역값 포함해서 소중대형에 값 대입
			if(i == 1) {
				run.대형 = new 대형("대형" , ch1);
				run.중형 = new 중형("중형" ,  ch1);
				run.소형 = new 소형("소형" ,  ch1);
			}
			
			// 턴[TIME] 출력
			System.out.println(i+"Time");
			
			// 자동차 run
			int result = run.run2();
		
			
			// 요금 출력
			if(result == 5 && x == 0) { // run반환값이 5(대형)이고 x가 0이면
				x++;					// x++
				대형 car = new 대형(ch2); 	
				System.out.println("-----"+"요금정산중-------");
				int p2 = run.price2(result); // 일반요금
				System.out.println("총요금 : " + (p2+
						(int)(car.getDistance())*360)+"원 입니다."); // 거리+요금	
				
				System.out.println("------------------");
				break no;				// 대형차가 가장 느리기때문에 들어오면 반복문 break;
			}
			else if( result == 6 && y == 0) {// run반환값이 5(대형)이고 y가 0이면
				y++;						// y++
				중형 car = new 중형(ch2); 	
				System.out.println("-----요금정산중-------");
				int p2 =  run.price2(result); // 일반요금
					
				System.out.println("총요금 : " + (p2 +(
						(int)(car.getDistance())*240))+"원 입니다."); // 거리+요금 
				System.out.println("------------------");
				
			}
			else if(result == 7 && z == 0) {// run반환값이 5(대형)이고 z가 0이면
				z++;						// z++
				소형 car = new 소형(ch2); 	
				System.out.println("-----요금정산중-------");
				int p2 =  run.price2(result); // 일반요금
					
				System.out.println("총요금 : " + (p2 +(
						(int)(car.getDistance())*120))+"원 입니다."); // 거리+요금
				System.out.println("------------------");
			}
			}
		}
		
	}
