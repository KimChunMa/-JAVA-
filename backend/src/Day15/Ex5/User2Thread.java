package Day15.Ex5;

public class User2Thread extends Thread{
	private Calculator calculator; //필드

	public User2Thread() {
		setName("User2Thread"); //생성자
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
	
}
