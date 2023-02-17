package Day11.Ex3;
//다중 인터페이스 : implements 인터페이스명1, 인터페이스명2
public class SmartTelevision implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("티비를 킵니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("티비를 끕니다");
	}

	@Override
	public void search(String url) {
		System.out.println(url+"채널을 검색합니다");
	}

	
}
