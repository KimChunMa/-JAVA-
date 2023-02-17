package Day11.Ex2;

public interface RemoteControl {
	//상수 필드 [인터페이스는 변수x]
		//new 연산자[생성자 x] => 객체 x => 인스턴스 멤버(필드+메소드)x => static멤버만 가능 
	public static final int MAX_VOLUME = 100;
	int Min_volume = 0; 
	// 인터페이스는 자동으로  public static final
	
	
	//추상메소드
	//		리턴타입, 메소드명 ,매개변수 만 선언
	// 		{} 선언 안한다.
	
	//1. public abstract 생략가능
	public abstract void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//디폴트 메소드	(구현안해도됨)
			//클래스에서 사용하는 메소드 동일
			//선언부 앞에 default 선언
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음");
			setVolume(Min_volume);
		}else {
			System.out.println("무음 해제");
		}
	}
	
	//정적 메소드 
			//객체없이 바로사용
	
	static void changeBattery() {
		System.out.println("배터리교체합니다.");
		System.out.println(MAX_VOLUME); //상수필드 사용가능-
	}
	
}
