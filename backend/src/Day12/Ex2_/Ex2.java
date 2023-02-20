package Day12.Ex2_;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		//1
		try {
			Class.forName("java.lang.String");
			System.out.println("java.lang.String 존재");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("java.lang.String 미존재");
		} 
		
		//--------------------------------------
		try {
			Class.forName("java.lang.String2");
			System.out.println("java.lang.String2 존재");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("java.lang.String2 미존재");
		} 
		
		
		//2
		String[] array = {"100","loo"};
		
		for(int i = 0 ; i<=array.length ; i++) {
			try {
				int value = Integer.parseInt(array[i]);
				System.out.println("array["+i+"] = " + value);
			} 
			
			//에러
			/* catch(Exception e) { 
				System.out.println("예외 발생 : ", e);
			} */
			
			catch(NumberFormatException e ) {
				System.out.println("숫자로 반환할 수 없음 : " + e);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스 초과: "+ e);
			}
			//최상위 클래스는 가장아래에
			catch(Exception e) { 
				System.out.println("예외 발생 : "+ e);
			}
		}//for e
		
		
		//3
		while(true) {
			try {
			Scanner sc = new Scanner(System.in);
			System.out.println("입력해주세요");
			int cn = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		
		
	}//main e
}
