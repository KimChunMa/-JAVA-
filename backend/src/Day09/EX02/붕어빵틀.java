package Day09.EX02;

import java.util.ArrayList;

/*
	생성자: 객체 초기화 담당 
	
					↓생성자 호출
	클래스 변수 = new 클래스()
	
	생성자가 없을 경우 기본생성자 자동 생성
	생성자의 이름은 클래스와 동일
	
	
	메소드:
		인수[매개변수]	:	함수 안으로 들어오는 데이터
		반환[리턴] : 함수 종료시 호출했던 곳으로 리턴되는 데이터
		
		리턴타입 함수명 (타입 매개변수, 타입 매개변수2){
			return 리턴타입허용범위내 데이터
		}
		
	호출
	내부	:	함수명 (데이터, 데이터)
	외부	:	객체명,함수명(데이터, 데이터)
*/



public class 붕어빵틀 {
	String 재료1;
	String 재료2;
	
	붕어빵틀(){} // 기본생성자
	
	붕어빵틀(String 재료1) {this.재료1 = 재료1;} //필드1개 생성자
	
	붕어빵틀(String 재료1, String 재료2) {
	this.재료1 = 재료1; this.재료2=재료2;} //필드1개 생성자

	@Override
	public String toString() {
		return "붕어빵틀 [재료1=" + 재료1 + ", 재료2=" + 재료2 + "]";
	}
	
	void 굽기() {
		System.out.println("붕어빵을 굽습니다.");
	}
	
	void 변경(String 재료1, String 재료2) {
		this.재료1 = 재료1; this.재료2=재료2;
		System.out.println("재료가 변경되었습니다");}
	
	int 판매가() {
		return 3000;
	}
	
	붕어빵틀 판매() {
		붕어빵틀 붕어빵 = new 붕어빵틀();
		return 붕어빵;
	}
	
	void 확인(붕어빵틀 붕어빵) {
		System.out.println(붕어빵);
	}
	
	ArrayList<붕어빵틀> 여러개판매(int 개수) {
		ArrayList<붕어빵틀> 붕어빵포장종이 = new ArrayList<>();
		for(int i = 1 ; i <= 개수 ; i++) {
			붕어빵포장종이.add(판매());
		}
		return 붕어빵포장종이;
	}
}
