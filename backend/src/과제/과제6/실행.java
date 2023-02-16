package 과제.과제6;

public class 실행 {
	public static void main(String[] args) {
			
			Car car = new Car(); 
			for( int i = 1 ; i<=10 ;i++ ) { //Car의 run 메소드를 10번 실행시켜라.
				
				//result는 타이어 수명이 끝날때 알리기위해 필요함.
				int result =  car.run();
				
				//Tire <= Han  
										//펑크가 나면 객체 대입
				if( result == 1 ) car.frontLeftTire = new HankookTire( 15 , "앞왼쪽" ); 
				if( result == 2 ) car.frontRightTire = new HankookTire( 13 , "앞오른쪽" );
				
				//Tire <= Kum
				
				//타이어 필드의 타이어객체에 금호타이어 대입 (총 14번 , 앞왼쪽 )
				if( result == 3 ) car.backLeftTire = new KumhoTire( 14 , "뒤왼쪽" );
				if( result == 4 ) car.backRightTire = new KumhoTire( 17 , "뒤오른쪽" );
			} // for 
			
		}
}
