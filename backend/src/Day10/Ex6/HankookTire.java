package Day10.Ex6;

public class HankookTire extends Tire{
	
	@Override
	public void roll() {
		System.out.println("한국 타이어");
	}
	
	@Override
	public void stop() {
		System.out.println("한국 스탑");
	}
}
