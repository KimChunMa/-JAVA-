package Day02;

import java.util.Scanner;

public class Ex2_입력 {
	public static void main(String[] args) {
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.println("문자열 입력해주세여 "); String st1 = sc.next();
		 * System.out.println("문자열1:"+st1 );// 문자열 입력받음 sc.nextLine(); // next() 와
		 * nextLine()이 같이있으면 nextLine() 스킵되므로 한번더 써줘야함 String st2 = sc.nextLine();
		 * System.out.println("문자열2:"+st2);// 문자열 입력받음(스페이스바가능)
		 * 
		 * boolean b = sc.nextBoolean() ; System.out.println("논리:"+b);
		 * 
		 * char c = sc.next().charAt(0); System.out.println("문자:"+c); //하나만 받으니 charAt
		 */
		
		/*
		 * sc.nextByte(); sc.nextShort(); sc.nextInt(); sc.nextLong(); sc.nextFloat();
		 * sc.nextDouble();
		 */
		int 비번 = 123;
		System.out.println(비번==123); //true
		
		String 아이디 ="qwe";
		System.out.println(아이디 == "qwe"); //false가 나와야하는데..
		
		System.out.println(아이디.equals("qwe")); //true
				
	}

}
