package 과제.과제8.Car.model.지역;

public class 대구 {
	//싱글톤
	private 대구() {};
	private static 대구 Daegu = new 대구();
	public static 대구 getInstance() {return Daegu;}
	
	private int distance = 30;
	
	

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
