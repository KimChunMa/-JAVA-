package Day10.Ex6;

public class Car {
	//필드 다형성
	public Tire tire; 
	
	public void run() {
		tire.roll();
	}
	
	public Tire parking(Tire tire) {
		tire.stop();
		return tire;
	}
}
