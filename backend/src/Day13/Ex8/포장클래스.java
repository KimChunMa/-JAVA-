package Day13.Ex8;

import java.util.ArrayList;

public class 포장클래스 {
	public static void main(String[] args) {
		
		//특정 api[컬렉션]은 객체만 지원
		//ArrayList<int> list = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		
		//다양한 메소드 지원
		int a = 10; System.out.println(a);
		Integer b =10;	System.out.println(b.toString());
		
		
		//박싱
		Integer obj = 100; //기본자료 -> 객체화
		System.out.println(obj.intValue());
		
		//언박싱
		int value = obj;	//객체 => 기본자료
		System.out.println(value);
		
		// 연산시 박싱 객체는 언박싱으로 변환후 연산처리
		int result = obj + 100 ; System.out.println(result);
		
		
	}
}
