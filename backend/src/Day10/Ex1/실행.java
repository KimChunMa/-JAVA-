package Day10.Ex1;

public class 실행 {
	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.color="red";
		System.out.println(phone.color);
		phone.bell();
		phone.sendVoice("메세지");
		System.out.println("\n");
		//phone.wifi 부모는 자식x
		
		SmartPhone sp = new SmartPhone("blue","갤럭시");
		sp.wifi=true;
		
		System.out.println(sp.toString());
		System.out.println(phone.toString());
		
		//부모메소드
		sp.bell(); 
		sp.sendVoice("보내기");
		sp.receiveVoice("받기");
		sp.hangUp();
		
		//자식
		sp.setWifi(true);
		sp.internet();
	}
}
