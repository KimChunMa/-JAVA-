package 과제.과제7;

public class 국민 extends 은행{
	
	public final static String code = "04";
	
	public 국민(String name, String pw) {
		super(code, pw, name, 0);
		System.out.println("국민은행 계좌 만들어주셔서 감사합니다." );
	}
	
	
}
