package Day09.Ex07;

public class 실행 {
	public static void main(String[] args) {
		Korean kor = new Korean("123456-1234567","김자바");
		
		System.out.println(kor.name);
		System.out.println(kor.nation);
		System.out.println(kor.ssn);
		
		//kor.nation = "미국";
		//kor.ssn ="123455";
		kor.name="논파이널";
		
		
		System.out.println(Korean.EARTH_RADTUS );
		System.out.println(Korean.스태틱파이널 );
	}
}
