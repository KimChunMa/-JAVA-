package Day13.Ex5;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

public class time {
	public static void main(String[] args) throws UnsupportedEncodingException {
		long time1 = System.nanoTime();
		
		System.out.println(time1);
		
		int sum = 0 ;
		
		for(int i = 1 ; i <= 1000000 ; i++) {
			sum+=i;
		}
		long time2 = System.nanoTime();
		System.out.println( (time2 - time1) + " 나노초 소요");
		
		/*
			밀리초	=>	마이크로초			=>
			1/1000		1/1,000,000		
		*/
		
		
		System.out.println("-----------------");
		System.out.println("Key\t\t:\t\t\t\tvalue");
		
		Properties props = System.getProperties(); // 모든 속성 호출
		
		for(Object obj : props.keySet()) { // 시스템 속성들의 키를 반복문
			System.out.println( (String)obj // 키를 문자열로 
					+ "\t\t\t\t" +  System.getProperty( (String)obj   )); // 시스템속성정보출력
		}
			
	
		System.out.println("-------------");
		
		//2/
		String data = "자바"; // 문자열 저장 하고 조작 하는 클래스 
		
		// 문자열 -> 바이트열 로 변환  getBytes()			인코딩타입 : UTF-8	[한글3바이트]
		byte[] arr1 = data.getBytes();
		// 배열의 주소값 출력 
		System.out.println( arr1 );
		// 배열내 데이터 출력 Arrays.toString( 배열명 ) 
		System.out.println( Arrays.toString( arr1 ) );
		
		// 문자열 -> 바이트열 로 변환 getBytes("EUC-KR")	인코딩타입 : EUC-KR	[ 한글2바이트 ]
		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println( Arrays.toString( arr2 ));
		
		// 바이트열 -> 문자열  new String( 배열명 );
		String str1 = new String( arr1 );
		System.out.println( str1 );
		
		String str2 = new String( arr2 , "EUC-KR");
		System.out.println( str2 );
		
	
	}//main e
}
