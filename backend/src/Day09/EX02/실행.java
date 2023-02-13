package Day09.EX02;

public class 실행 {
	public static void main(String[] args) {
		
		
		//붕어빵 객체는 main의 지역변수
		//스택 영역
		붕어빵틀 붕어빵1 = new 붕어빵틀();
		System.out.println(붕어빵1.toString());
		
		붕어빵틀 붕어빵2 = new 붕어빵틀("반죽");
		System.out.println(붕어빵2.toString());
		붕어빵2.변경("반죽", "슈크림");
		System.out.println(붕어빵2.toString());
		
		
		붕어빵틀 붕어빵3 = new 붕어빵틀("반죽","팥");
		System.out.println(붕어빵3); // toString 안해도 만들어두면 알아서됨
		System.out.println("붕어빵3 판매가 : "+붕어빵3.판매가());
		
		System.out.println("붕어빵 4 판매 : " +붕어빵3.판매());
		붕어빵3.확인(붕어빵3);
		
		System.out.println(붕어빵3.여러개판매(5));
	}
}
