package Day08.Ex1;

//클래스 선언
	//1. 숫자 시작X, 띄어쓰기 x 
	//2. 첫글자는 대문자 영문
	//3. 멤버 : 1. 필드 2. 생성자 3. 메소드

public class Car {
	//필드
	String model;
	String color;
	int maxSpeed;
	
	
	
	//생성자
	//생성자 이름 = 클래스명 , 다를시 메소드[함수]가됨
	//오버로딩: 이름이 동일할 경우 시그니처(매개변수 갯수, 타입)구분해서 식별가능
	//오버라이딩: 부모의 메소드를 재정의
	 Car() {} // 생성자 없을때 기본 생성자 자동생성
	 
	 Car(String model, String color){ // 생성자 2개
		 this.model = model;
		 //this.내부필드명
		 this.color = color;
	 } 
	 
	 Car(String model, String color, int maxSpeed){
		 this.model = model;
		 this.color = color;
		 this.maxSpeed = maxSpeed;
	 }

	@Override
	public String toString() {
		
		return "Car [model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}


	 
	 
	 
	 
	}

