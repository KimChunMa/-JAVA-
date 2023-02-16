package 과제.과제6;

//자식
public class HankookTire extends Tire {
	
	//자식 생성자
	public HankookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	//재정의한 메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;	
		if( accumulatedRotation < maxRotation ) {
			System.out.println( location + " HankookTire 수명 : " 
				+ (maxRotation-accumulatedRotation) + "회");
			return true; 
		}else {
			System.out.println("*** " + location +" HankookTire 펑크 ***");
			return false; 
		}
	}
	
	
}
