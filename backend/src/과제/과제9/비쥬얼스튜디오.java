package 과제.과제9;

public class 비쥬얼스튜디오  extends sw필드 implements 소프트웨어{
	
	public 비쥬얼스튜디오(String name, String icon) {
		super(name,icon);
	}
	
	@Override
	public void consol() {
		System.out.println("비쥬얼 설치");
		
	}

	@Override
	public void shortcut() {
		System.out.println("비쥬얼 바로가기");
		
	}
	
}
