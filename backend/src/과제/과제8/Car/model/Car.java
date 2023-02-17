package 과제.과제8.Car.model;


import 과제.과제8.Car.model.지역.대구;
import 과제.과제8.Car.model.지역.대전;
import 과제.과제8.Car.model.지역.부산;

public class Car {

	public String model;
	public int km;
	public int price;
	public int 지역;
	
	public String[] locations = {null,"대전","대구","부산","광주"};
	public String location;
	public int time;
	public int distance;
	
	
	public Car( int ch2) {
		km=0;
		if(ch2 == 1){distance = 대전.getInstance().getDistance(); }
		else if(ch2 == 2){distance = 대구.getInstance().getDistance();}
		else if(ch2 == 3){distance = 부산.getInstance().getDistance();}
		
	}	
	
	
	public Car() {
		super();
		
	}
	
	// 추가
	public Car(String model , int 지역) {
		this.지역 = 지역;
		this.model = model;
	}
	

	public Car(String string, int km, int price , int 지역) {
		this.model = string;
		this.km = km;
		this.price = price;
		this.지역 = 지역;
		
	}
	
	public int price() {
		System.out.println("차가 목적지에 도착했습니다.");
		System.out.println("요금은"+price+"입니다.");
		return 0;
	}
	
	public int run() {
		System.out.println("달립니다.");
		지역 = 지역-km;
		if(0 < 지역) {
			
			System.out.println("목적지까지"+지역+"만큼 남았습니다.");
			return 1;
		}
		else {return 0;}
	
	}
	
	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}
}