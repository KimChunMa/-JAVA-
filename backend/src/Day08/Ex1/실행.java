//클래스 실행 목적: main함수 가진 클래스
package Day08.Ex1;

public class 실행 {
	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println(car1.toString());
		
		Car car2 = new Car("그랜저","파랑");
		System.out.println(car2.toString());
		
		Car car = new Car("그랜저","검정",250);
		System.out.println(car.toString());
		
	}
}
