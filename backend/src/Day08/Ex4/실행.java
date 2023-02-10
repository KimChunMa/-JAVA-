package Day08.Ex4;

public class 실행 {
	public static void main(String[] args) {
		Calculator math = new Calculator();
		
		math.poweron();
		
		int result = math.puls(3, 5);
		System.out.println(result);
		
		double result2 = math.divide(3, 5);
		System.out.println(result2);
		
		math.함수호출();
		
		int x = 10;
		int y = 4;
		double result3 = math.divide(x, y);
		System.out.println(result3);
		
		math.powerOff();
		
		System.out.println(math.info());
	}
}
