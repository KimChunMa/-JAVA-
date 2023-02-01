package Day01;

public class Ex4_자료형변환 {
	public static void main(String[] args) {
		//1. 자동 타입 변환
		byte b1 = 10; int i1 = b1;	// byte => int	
		char c1 = '가'; i1 = c1;		// char => int
		int i2=50; long l1 = i2;	// int =>long
		long l2 = 100l; float f1 = l2; // long => float
		float f2 = 100.5f; double d1 = f2; // double => float
		
		//2. 강제 타입 변환 [손실]
		int i3 = 128;	byte b2 = (byte)i3;	System.out.println(b2); //-128
		long l3 = 300;  int i4 = (int)l3; System.out.println(i4); //300
		int i5 = 65; char c2 = (char)i5 ; System.out.println(c2);
		double d2 =3.14 ; int i6 = (int)d2; System.out.println(d2);
		
		//3. 연산 자동 타입 변환
		/* 피연산자 중 큰 피연산자 따라감 (byte, short 제외)
		   byte + byte => int
		   short + int => int
		   
		   	int + long => long
		   	
		   	float + float => float
		   	float + double => double
		 */
		
		//4. 문자열 타입 변환
		String str = "10"; 
		byte 바이트 = Byte.parseByte(str); System.out.println(바이트);		//string => byte
		short 쇼트1 = Short.parseShort(str); System.out.println(쇼트1); //string => short
		int 정수1 = Integer.parseInt(str); System.out.println(정수1); //string => int
		long 롱 = Long.parseLong(str); System.out.println(롱);		//string => long
		double 더블 = Double.parseDouble(str); System.out.println(더블);	//string => double
		
		String str2 = "안녕";
		int 인트2 = Integer.parseInt(str2); System.out.println(str2);  //불가능 
		
		//int 인트3 = (Integer)str; //문자열 형변환 불가능
		
	}
}
