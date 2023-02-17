package Day11.Ex2;

public class 실행 {
	public static void main(String[] args) {
		//인터페이스 정적 상수 필드
		System.out.println("리모콘 최대 볼륨"+RemoteControl.MAX_VOLUME);
		System.out.println("리모콘 최소 볼륨"+RemoteControl.Min_volume);
		
		//인터페이스 변수 선언 <= 힙영역 주소전달
		RemoteControl rc = new TV();
		rc.turnOn();
		rc.setVolume(101);
		rc.setVolume(-1);
		rc.setVolume(5);
		rc.turnOff();
		
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(101);
		rc.setVolume(-1);
		
		rc.turnOff();
		
		rc.setVolume(5);
		rc.setMute(true);
		rc.setMute(false);
		
		//정적
		RemoteControl.changeBattery();
	}
}
