package Day09.EX01;

/*
 라이브러리 클래스 : 실행x,
  현업에서 사용되는 디자인 패턴:MVC
  
 실행 클래스: main() 메소드를 가진 클래스
 
 
 메소드	 	스택				힙
 			String name
 			String name  = 	new String("유재석") -- 인스턴스(객체) 
 			클래스			객체
 
 필드: 객체의 데이터 저장공간 [지역변수와 비슷하지만 목적이 다름]
 
 
 		지역변수		vs		필드
 선언	메소드{}선언			클래스{} 선언
 존재 	메소드 실행시 존재		객체 생성시 존재
 사용	메소드 {} 에서만 사용	객체 내,외부 사용
 초기화	직접					자동 (0 ,null, false)
 
 
 필드 사용
 객체 내부: 생성자, 메소드
 객체 외부: 객체명. 필드명

 
 
*/
public class Member {
	String name;	//null
	int num;		//0
	double num2 ;	//0.0
	boolean bool;	//false
	String[] array=new String[3]; // null null null
	
	
	void setName() {
		String inputName; // 로컬,지역 변수
		System.out.println(name);
		//System.out.println(inputName); 지역변수는 자동 초기화 안됨
	}
	
	void getName() {
		
	}
}
