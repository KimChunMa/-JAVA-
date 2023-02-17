package 과제.과제9;

public class 인텔리제이 extends sw필드 implements 소프트웨어{
	
	public 인텔리제이(String name, String icon) {
		super(name,icon);
	}
	
	@Override
	public void consol() {
		System.out.println("인텔리제이 설치");
		
	}

	@Override
	public void shortcut() {
		System.out.println("인텔리제이 바로가기");
		
	}
}
