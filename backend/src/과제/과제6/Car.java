package 과제.과제6;

public class Car {
	// 1. 필드 
	//타이어 객체 4개 생성			//최대 6번
	Tire frontLeftTire = new Tire( 6 , "앞왼쪽");
	Tire frontRightTire = new Tire(2 , "앞오른쪽");
	Tire backLeftTire =  new Tire(3 , "뒤왼쪽");
	Tire backRightTire =  new Tire(4 , "뒤오른쪽");
	
	// 3. 메소드 
	int run() {
		System.out.println("[자동차가 달립니다.]");
		
		/*
		if문들이 roll함수를 작동하고 있다.
			(누적로케이션이 최대로케이션보다 같거나 클경우 false), 멈추고 1반환
				누적 로케이션은 초기 필드
		 */
		if( frontLeftTire.roll() == false ) { stop(); 	return 1; }
		if( frontRightTire.roll() == false ){ stop(); 	return 2; }
		if( backLeftTire.roll() == false ) 	{ stop(); 	return 3; }
		if( backRightTire.roll() == false ) { stop(); 	return 4; }
		return 0; //문제없으면 0 반환
	}
	
	void stop() {System.out.println("[자동차가 멈춥니다.]");}
}
