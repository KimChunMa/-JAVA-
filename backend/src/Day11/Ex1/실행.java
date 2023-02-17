package Day11.Ex1;

public class 실행 {
	public static void main(String[] args) {
		
		//인터페이스는 타입이므로 변수처럼 사용
		RomoteControl rc = null;
		
		
		//new Televsion(); [힙영역에 객체 선언하고 주소를 반환]
		
		/* 'rc'스택영역의 변수 <= 반환된 주소(Televsion 주소)
		 ==    인터페이스 변수 <= 구현객체의 번지 대입 */
		RomoteControl rc2 = new Television();
		rc= new Television();
		rc.turnOn();
		
		//implemtents가 선언되지않아 불가능
		//RemoteControl rc2 = new Audio();
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ위와 동일 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		Television tv = new Television();
		tv.turnOn(); //tv를 킵니다
		new Television().turnOn(); // tv를 킵니다
		
		//교체
		rc = new Audio();
		rc.turnOn(); //오디오를 킵니다
		
		
	}
}
