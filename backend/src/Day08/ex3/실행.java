//클래스 실행 목적: main함수 가진 클래스
package Day08.ex3;

public class 실행 {
	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println(car1.toString());
		
		Car car2 = new Car("자가용");
		System.out.println(car2.toString());
		
		Car car3 = new Car("자가용","빨강");
		System.out.println(car3.toString());
		
		Car car4 = new Car("택시","검정",250);
		System.out.println(car4.toString());
	}
}
