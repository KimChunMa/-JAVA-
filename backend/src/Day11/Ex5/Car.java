package Day11.Ex5;

public class Car {
	Tire tire1 = new HankookTire();
	Tire tire2 = new KumhoTire();
	
	void run() {
		tire1.roll();
		tire2.roll();
	}
}
