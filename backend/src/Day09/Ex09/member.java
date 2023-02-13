package Day09.Ex09;

/*
	싱글톤: 프로그램내 하나의 객체를 가지는 패턴
		클래스 내부에 객체 만들기, 생성자 private
		내부 객체 반환해주는 함수 : getInstance
		
		함수호출시 객체를 호출해야하는데, 외부에서 객체 금지 -> static
*/

public class member {
	  //정적필드 초기화
	private static member m = new member();
	
	  //생성자 생성 막기
	private member() {};  
	
	//static은 인스턴스 객체를 못쓰기에 객체생성도 static으로 변환
	public static member getInstance() {
		return m;
	}
	
	
}
