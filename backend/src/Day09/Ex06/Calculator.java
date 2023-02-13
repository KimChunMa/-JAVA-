package Day09.Ex06;

/*
 	정적 멤버:
 		1. static 키워드 (생성자x)
 		2. JVM 메소드 영역 저장
 		3. 객체 없이 사용 가능
  		
  		 사용방법
  		  클래스명.정적멤버
  		5. 프로그램 시작시 생성, 프로그램 종료시 초기화
  			- 효율성 생각: 모든 클래스에서 사용되는 메모리
  		
  		6. 정적 멤버는 인스턴스 멤버를 사용할 수 없다.
 */
public class Calculator {
	int no ;
	static double pi = 3.14159;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public static double getPi() {
		return pi;
	}
	public static void setPi(double pi) {
		Calculator.pi = pi;
	}
	
	static int plus(int x , int y) {
		
		// System.out.println(no); 인스턴스 필드 불가능 
		return  x + y ;
	}
	
	static int minus(int x , int y) {
		return x - y ;
	}
	
	static String info;
	
	static {
		info = pi + " 파이 입니다.";
	}
	
	static String info2 = pi + " 파이 입니다.";
}
