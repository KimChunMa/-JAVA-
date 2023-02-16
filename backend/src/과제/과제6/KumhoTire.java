package 과제.과제6;

public class KumhoTire extends Tire {
	//자식 생성자
	public KumhoTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	//재정의한 메소드
	@Override
	public boolean roll() { // roll할수록 누적로케이션 증가
		++accumulatedRotation;
		if( accumulatedRotation < maxRotation ) {  // 제조사만 다름
			System.out.println( location + " KumhoTire 수명 : " 
				+ (maxRotation-accumulatedRotation) + "회");
			return true; 
		}else {
			System.out.println("*** " + location +" KumhoTire 펑크 ***");
			return false; 
		}
	}
}