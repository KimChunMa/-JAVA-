package Day12.Ex1_예외;

public class Ex1 {
	//접근제어자 키워드 반환타입 함수명(매개변수1, ...){return 반환타입;}
		//키워드 : static[정적] , final[오버라이딩금지]
		//함수명 : 카멜표기법
	public static void printLength(String data) {
		try {
		int result = data.length();
		System.out.println("문자열 수: "+result);
		}catch(NullPointerException e) { //Exception e 
			System.out.println(e.getMessage()); // 에러검출메세지
		}finally{ //항상
			System.out.println("마무리");
		}
	}
	
	//main함수 선언: main스레드가 포함된 함수 -> 스레드: 코드를 읽어주는 흐름단위[단위스레드]
	public static void main(String[] args) {
		printLength("ddd");
		printLength(null); // NullPointerException: 데이터가 null이라 length()를 못씀
		
		
		System.out.println("종료");
	}
}

/*
 	에러: 하드웨어 고장, 응용프로그램 실행 오류
 	예외: 에러이외 예외라는 오류
 		* 잘못된 사용, 코딩
 			* 잘못된 사용: 사용자가 비정상적인 행동했을 때 ->경험
 				* 일반 예외: 컴파일전 발생할 수 있는 예외 [자바 외부 통신[스트림] ]
 				* 실행 예외: 컴파일후 발생하는 예외
	예외클래스
		Exception 클래스 : 모든 예외를 받을 수 있는 예외중에 최상위 클래스
		
		문법 
		try{
			1.예외발생할 것 같은 코드
		}catch(예외클래스 e){
			2. 에러발생시 실행될 코드
		}finally{
			3. 항상실행 (생략가능)
		}
		
 */
