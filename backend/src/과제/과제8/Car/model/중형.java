package 과제.과제8.Car.model;


import 과제.과제8.Car.model.지역.대구;
import 과제.과제8.Car.model.지역.대전;
import 과제.과제8.Car.model.지역.부산;


public class 중형 extends Car{

	public int km = 8;
	public int price = 20000;
	
	
	
	public 중형(String string, int 지역) {
		super(string , 지역);
	}

	@Override
	public int price() {
		System.out.println("중형차가 목적지에 도착했습니다.");
		System.out.println("중형차 기본요금은 "+price+"원 입니다.");
		return price;
	}

	@Override
	public int run() {
		System.out.println("중형차가 달립니다.");
		지역 = 지역-km;
		if(0 < 지역) {
			
			System.out.println("목적지까지"+지역+"만큼 남았습니다.");
			return 1;
		}
		else { return 0;
		}
	}
	
	public 중형(int ch2) {
		super();
		km=8;
		
		location = locations[ch2];
		if(ch2 == 1){distance = 대전.getInstance().getDistance(); }
		else if(ch2 == 2){distance = 대구.getInstance().getDistance();}
		else if(ch2 == 3){distance = 부산.getInstance().getDistance();}
		
		
		
	}
	
}
