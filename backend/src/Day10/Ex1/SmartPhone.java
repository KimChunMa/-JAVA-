package Day10.Ex1;

public class SmartPhone extends Phone{
	//부모는 자식에게 주되, 자식은 부모에게 주지않는다.
	
	public boolean wifi;
	public SmartPhone() {super();}
	
	
	
	public SmartPhone(String model, String color) {
		super(model,color); // 선택 1
		
		//super()			   선택 2
		this.model = model; // 선택 2
		this.color = color;// 선택 2
	}
	
	public void setWifi(boolean Wifi) {
		this.wifi = Wifi;
		System.out.println("와이파이 상태변경");
	}

	
	public void internet() {
		System.out.println("인터넷에 연결합니다");
	}

	@Override
	public String toString() {
		return "SmartPhone [model=" + model + ", color=" + color + "]";
	}
	
}
