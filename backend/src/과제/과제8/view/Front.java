package 과제.과제8.view;

import java.util.Scanner;

import 과제.과제8.model.소형;
import 과제.과제8.model.중형;
import 과제.과제8.model.대형;

public class Front {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 소형 2. 중형 3. 대형");
		System.out.println("차량을 선택해주세요"); int ch = sc.nextInt();
		
		System.out.println("1. 대전 2. 대구 3. 부산 4.광주");
		System.out.println("목적지를 선택해주세요"); int ch2 = sc.nextInt();
		
		if(ch==1) {  //목적지 선택시 model에서 거리 뺴오기
			소형 car = new 소형(ch2); System.out.println("거리 : "+car.getDistance()+"  요금 :"+car.getPrice()+ " 시간 : "+car.getTime() +" 분");
		}
		
		else if(ch==2) { 
			중형 car = new 중형(ch2); System.out.println("거리 : "+car.getDistance()+"  요금 :"+car.getPrice() + " 시간 : "+car.getTime() +" 분");
		}
		
		else if(ch==3) { 
			대형 car = new 대형(ch2); System.out.println("거리 : "+car.getDistance()+"  요금 :"+car.getPrice() + " 시간 : "+car.getTime() +" 분");
		}
		
	}
}
