package Day09.Ex06;

public class 실행 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		System.out.println("cal 값 : "+cal.no);
		System.out.println("cal 값 : "+cal.getNo());
		
		
		//정적 멤버 호출
		double result1 = 10 * 10 * Calculator.pi;
		System.out.println(result1);
		
		System.out.println( Calculator.plus(5, 10) );
		System.out.println( Calculator.minus(5, 10));
		
		System.out.println(Calculator.info);
	}
}
