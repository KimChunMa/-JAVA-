package Day09.Ex07;

/*
 final 필드 : 수정 불가능 , 초기화 필수(필드 or 생성자) , 공유 x

 static final 필드 : 상수 //수정 x, 공유 메모리
 
 */

public class Korean {
	final String nation = "대한민국";
	final String ssn; //무조건 초기화 있어야됨
	
	String name;
	
	public Korean(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	
	static final double EARTH_RADTUS = 6400;
	static final double 스태틱파이널;
	static {
		스태틱파이널 = 4*Math.PI * EARTH_RADTUS;
	}
}
