package Day02;

public class Ex3_연산자 {
	public static void main(String[] args) {
		int x = 10;
		int y = -10;
		//부호
		System.out.println(x); //10
		System.out.println(y); //-10
		
		System.out.println(x++); //10 
		System.out.println(x);	//11
		System.out.println(++x); // 12
		
		System.out.println(y--); //-10
		System.out.println(y); //-11
		System.out.println(--y); //-12
		
		//산술
		System.out.println(x+y); // 12+ -12
		System.out.println(x-y); //12 - -12
		System.out.println(x*y); // 12 * - 12
		System.out.println(5/3); // 1
		System.out.println(5%3); // 2
		
		//비교
		System.out.println("x==y" + (x==y));
		System.out.println("x!=y" + (x!=y));
		System.out.println("x>y" +  (x>y));
		System.out.println("x>=y" + (x>=y));
		System.out.println("x<y" + (x<y));
		System.out.println("x<=y" + (x<=y));
		
		System.out.println("str.equalse(str2): " + ("유재석").equals("유재석"));
		System.out.println("!str.equalse(str2): " + (!("유재석").equals("유재석")));
		
		//논리
		System.out.println("5<x<20: " + (x>5 && x<20));
		System.out.println("5<x<10: " + (x>5 && x<10));
		System.out.println("0<=x x>20: " + (0<=x || x>10));
		System.out.println("!(x==y)" + (!(x==y)));
		
		//대입
		int z = 30;
		z += x; //z = 30 + 12
		
		//삼황
		String 결과 = (x>=20) ? "합": "불"; System.out.println(결과);
		
		//연결
		String 연결문자1 = "유재석" + "10"; System.out.println(연결문자1);
		String 연결문자2 = "유재석" + 10; System.out.println(연결문자2);
		String 연결문자3 = "유재석" + 10+20; System.out.println(연결문자3);
		String 연결문자4 = "유재석" + (10+20); System.out.println(연결문자4);
	}
}
