package Day13.Ex1;

public class 실행 {
	public static void main(String[] args) {
		member m = new member("blue");
			System.out.println( m );
		member m2 = new member("blue");
			System.out.println(m2 );
		member m3 = new member("red");
			System.out.println( m3);
		
		System.out.println( m.equals(m2)   );
		System.out.println( m.equals(m3)   );
		System.out.println( m2.equals(m3)  );
	
	
	
	
	}
}
