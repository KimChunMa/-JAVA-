package 과제.과제7;

public class 신한 extends 은행{
	public final static String code = "03";
	
	public 신한() {};
	
	public 신한(String name, String pw) {
		super(code, pw, name, 0);
		System.out.println("신한은행 계좌 만들어주셔서 감사합니다." );
	}

	@Override
	public 은행 make_Account() {
		super.make_Account();
		신한 계좌 = new 신한(name,pw);
		return 계좌;
	}
	
	
	
	
}
