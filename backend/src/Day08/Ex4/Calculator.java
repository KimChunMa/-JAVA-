package Day08.Ex4;

public class Calculator {
	//필드
	
	
	//생성자
	
	
	
	//메소드
	void poweron() { // 반환x 인수 x
		System.out.println("전원을 킵니다.");
	}
	
	void powerOff() { // 반환x 인수 x
		System.out.println("전원을 끕니다.");
	}
	
	void multiplay(int x , int y) { //반환x 인수o
		System.out.println (x*y);
	}
	
	String info() { // 반환o 인수x
		return"이젠계산기";
	}
	
	int puls(int x , int y) {//반환o 인수o
		int result = x+y;
		return result;
	}
	
	double divide(int x , int y) { //반환o 인수o
		double result = ((double) x/ (double) y);
		return result;
	}
	
	void 함수호출() {
		poweron();
	}
	
}
