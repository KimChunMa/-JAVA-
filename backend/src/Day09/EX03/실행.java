package Day09.EX03;

public class 실행 {
	public static void main(String[] args) {
		//직접 접근 [필드]
		Car car = new Car();
		car.gas = 5;
		
		//간접 접근 [생성자]
		Car yourCar = new Car(5); // 사라지고 새로생김
		yourCar = new Car(5);
		
		//간접 접근 [메소드]
		Car myCar = new Car();
		myCar.setGas(5);
		
		if(myCar.isLetGas()) {
			System.out.println("출발합니다");
			myCar.run();
		}else {
			System.out.println("주입하세요");
		}
	}
}
