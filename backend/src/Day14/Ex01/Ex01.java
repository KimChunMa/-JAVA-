package Day14.Ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		//math 클래스 : 수학 계산
		
		//올림
		double v1 =Math.ceil(5.3);	System.out.println(v1);
		
		//내림
		double v2 = Math.floor(5.3);	System.out.println(v2);
		
		long v3 = Math.max(3, 7);	System.out.println(v3);
		
		long v4 = Math.min(3, 7);	System.out.println(v4);
		
		double value = Math.round( 5.4);	System.out.println(value);
		
		 value = Math.round( 5.5);	System.out.println(value);
		
		double temp = 12.3456;
		double temp1 = temp * 100; // 1234.56
		long temp2 = Math.round(temp1); // 1235
		double v5 = temp2 /100.0; //12.35
		System.out.println(v5);
		
		System.out.println( String.format("%.2f", 3.14159)  ); // 3.14
		
		
		int[] selectNumber = new int[6]; // 원시타입만 
		ArrayList<Integer> selectNumber2 = new ArrayList<>(); // 객체만, 기본길이 10
		
		Random random = new Random(3); // 0~3
		System.out.print("선택 번호 ");
		for(int i= 0 ; i < 6 ; i++) {
			selectNumber[i] = random.nextInt(45)+1;//1~45
			System.out.print(selectNumber[i]+ " ");
		}
		System.out.println();
		
		int[] winningNumber = new int[6];
		random = new Random(3);
		System.out.print("당첨 번호 ");
		for(int i= 0 ; i < 6 ; i++) {
			winningNumber[i] = random.nextInt(45)+1;//1~45
			System.out.print(winningNumber[i]+" " );
		}
		System.out.println();
		
		Arrays.sort(selectNumber);
		Arrays.sort( winningNumber);
		
		boolean result =Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨여부 : ");
		if(result) {System.out.println(" 1등! ");}
		else {System.out.println("ㄲㅂ");}
		
		int[] a = {5,3,4,2,6,1};
		
		Arrays.sort(a);
		for(int b : a) {
			System.out.print(b+", ");
		}
		System.out.println();
		
		Random random2 = new Random(10);
		int a1 = random2.nextInt(10)+1; // 1~10;
		
		 random2 = new Random(10);
		int b1 = random2.nextInt(10)+1; // 1~10;
		System.out.println("a = "+a1);
		System.out.println("b = "+b1);
	}
}
