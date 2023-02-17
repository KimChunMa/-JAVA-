package 과제.과제9;

public class 이클립스  extends sw필드 implements 소프트웨어{
	
	public 이클립스(String name, String icon) {
		super(name,icon);
	}
	
	@Override
	public void consol() {
		System.out.println("이클립스 설치");
		
	}

	@Override
	public void shortcut() {
		System.out.println("이클립스 바로가기");
		
	}
	
}
