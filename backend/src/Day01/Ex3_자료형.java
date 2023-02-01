package Day01;

public class Ex3_자료형 {
	public static void main(String[] args) {
		int var1 = 0b1011; System.out.println(var1);
		int var2 = 0206; System.out.println(var2);
		int var3 = 365; System.out.println(var3);
		int var4 = 0xB3; System.out.println(var4);
		
		byte b1 = -128; System.out.println(b1);
		byte b2 = 127;	System.out.println(b2);
		/* byte b2 = 128;  오류*/
		
		/* short s1 = 32768; 오류*/
		
		/* int i1 = 3000000000; 오류*/
		
		long l1= 100000000000L; /*int 초과 값은 뒤에 L붙여야됨*/
		
		char var = 'a';  //문자 '' 문자열 ""
		String VAR = "ab";
		
		float f1 = 0.123456789f; System.out.println(f1); //9까지만 출력됨
		double d1 = 0.12345678912345678;			System.out.println(d1); //1~9 돌고 8까지출력
		
		boolean bool1 = true; System.out.println(bool1);
		boolean bool2 = false; System.out.println(bool2);
	}
}
