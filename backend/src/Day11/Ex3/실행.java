package Day11.Ex3;

public class 실행 {
	public static void main(String[] args) {
		RemoteControl rc = new SmartTelevision();
		rc.turnOn();
		rc.turnOff();
		//자식은 부모 사용가능
		rc.search(null);
		
		Searchable sc = new SmartTelevision();
		sc.search("ab");
		
		//부모는 자식 사용 불가능
		//sc.turnOn
			
	}
}
