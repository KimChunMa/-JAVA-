package Day10.Ex3;

//final 추가시 상속할 수 없다.
public class Car {
	public int speed;
	
	public void speedUp() {
		speed +=1;
	}
	
	
	public final void stop() {
		System.out.println("멈춤");
		speed = 0;
	}
}
