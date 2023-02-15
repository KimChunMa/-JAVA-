package 과제.과제7;

public class 우리 extends 은행{
public final static String code = "03";
	
	public 우리(String name, String pw) {
		super(code, pw, name, 0);
		System.out.println("우리은행 계좌 만들어주셔서 감사합니다." );
	}
}
