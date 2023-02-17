package Day11.Ex1;


//	class = 클래스 선언
//		extends = 상속 
//	interface = 인터페이스 선언
//		implement = 구현	
public interface RomoteControl {
	
	 //동일한 목적에 서로다른 기능하기 위함 (오락실 같은버튼 다른기능수행)
	
	
	//1. 필드 (상수o 변수x)
	
	//2. 생성자 x [new 사용 불가능 => 객체 못만듬]
	
	//3.public메소드1 (추상,디폴트,정적 메소드 )
	//3.private 메소드2 (메소드, 정적메소드)
	
	//추상메소드 (선언부 존재){자식이 구현}
	public void turnOn();
	
}
