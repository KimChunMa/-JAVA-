package 과제.과제9;

public class 실행 {
	public static void main(String[] args) {
		개발툴 a = new 개발툴();
		a.E.consol();
		a.E.shortcut();
		
		a.E = new 인텔리제이("인텔리제이","In");
		a.E.consol();
		a.E.shortcut();
		
		
		sw필드 sw = new sw필드("sw필드","sw");
		System.out.println( a.E instanceof sw필드);
	}
}
