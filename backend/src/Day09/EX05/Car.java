package Day09.EX05;


/*
 	this.필드명
 	this.함수명()
 	this() <-생성자
 
 */

public class Car {
	String model;
	int speed;
	
	Car(String model){
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	void run() {
		this.setSpeed(100);
		System.out.println(this.speed +"가 달립니다. (시속"+this.speed + "km/h");
	}
	
}
