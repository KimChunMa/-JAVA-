package Day15.Ex5;

public class 실행 {
	public static void main(String[] args) {
		Calculator cal = new Calculator(); //cal 32번지
		
		User1Thread user1 = new User1Thread(cal); // cal 32번지
		user1.start(); //User1Thread:100 동기화(잠금)안하면 50
		
		User2Thread user2 = new User2Thread(); //cal 32번지
		user2.setCalculator(cal);
		user2.start(); //User2Thread:50 
		
	}
}
