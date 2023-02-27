package Day15.Ex5;

public class User1Thread extends Thread {
	private Calculator calculator; // 필드

	public User1Thread(Calculator calculator) {
		setName("User1Thread"); // 생성자
		this.calculator = calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(100);
	}
	
	
	
}
