package Day08.ex3;

public class Car {
	//필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	//2.생성자
		//오버로딩: 매개변수 타입, 개수, 순서가 다르게 여러개 생성자 선언
		//오른쪽클릭 -> source -> Generate Constructor using Fields -> 필드선택
	
	
	public Car() {
		super();
	}
	
	public Car(String model) {
		super();
		this.model = model;
	}
	

	public Car(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}
	

	public Car(String model, String color, int maxSpeed) {
		super();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public Car(String company, String model, String color, int maxSpeed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}

	
	
	
	
	
	 

	}

