package Day07.ex_2;

public class 실행 {
	public static void main(String[] args) {
		//클래스 객체 생성
		
		Car myCar = new Car(); //32번지
		
		//.접근연산자
		System.out.println("모델명 " + myCar.model);
		System.out.println("시동여부 " + myCar.start);
		System.out.println("현재 속도 " + myCar.speed);
		
		Car yourCar= new Car(); //33번지
		yourCar.model = "현대자동차";
		System.out.println("모델명: "+ yourCar.model);
	}
}
