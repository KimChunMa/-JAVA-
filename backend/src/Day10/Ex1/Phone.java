package Day10.Ex1;

public class Phone {
	//클래스 멤버
		//인스턴스 멤버 : 객체를 이용한 멤버
			//클래스 객체명 = new 생성자() => 객체명.멤버
		
		//정적 멤버 [static] : 객체없이 이용하는 멤버
			//클래스명.멤버
	
	public String model;
	public String color;
	
	Phone(){};
	
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
		System.out.println("Phone() 생성자 실행");
	}
	
	
	
	//메소드 : 지역변수
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("자기: " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}
	
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	
}
