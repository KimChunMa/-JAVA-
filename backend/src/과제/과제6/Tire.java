package 과제.과제6;

//부모
public class Tire {
	
	//1. 필드
	public int maxRotation; //타이어 최대 로테이션
	public int accumulatedRotation; //초기화안해서 자동 0 /만약 final,static이면 초기화해야됨
	public String location; //타이어 위치
	
	//2. 생성자		최대로테이션, 생산지역
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	//3. 메소드
	public boolean roll() {
		++accumulatedRotation; //누적 로테이션 증가
		
			//누적로케이션이 최대보다 적을경우 (남은횟수 = 최대-누적)
		if( accumulatedRotation < maxRotation ) {
			System.out.println( location + " Tire 수명 : " 
				+ (maxRotation-accumulatedRotation) + "회");
			return true; 
			
		}else { // 누적로테이션이 클경우
			System.out.println("*** " + location +" Tire 펑크 ***");
			return false; 
		}
	}
}
