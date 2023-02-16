package 과제.과제8.model;

import 과제.과제8.model.지역.광주;
import 과제.과제8.model.지역.대구;
import 과제.과제8.model.지역.대전;
import 과제.과제8.model.지역.부산;

public class Car {
	//필드
	public int distance;
	public int price;
	public int km;
	public int time;
	public String[] locations = {null,"대전","대구","부산","광주"};
	public String location;
	
	//생성자
	public Car() {}

	public Car( int ch2) {
		km=0;
		
		location = locations[ch2];
		if(ch2 == 1){distance = 대전.getInstance().getDistance(); }
		else if(ch2 == 2){distance = 대구.getInstance().getDistance();}
		else if(ch2 == 3){distance = 부산.getInstance().getDistance();}
		else if(ch2 == 4){distance = 광주.getInstance().getDistance();}
		
		time = distance/km;
	}

	
	//get set
	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String[] getLocations() {
		return locations;
	}


	public void setLocations(String[] locations) {
		this.locations = locations;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getKm() {
		return km;
	}


	public void setKm(int km) {
		this.km = km;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	
	
	
	
}
