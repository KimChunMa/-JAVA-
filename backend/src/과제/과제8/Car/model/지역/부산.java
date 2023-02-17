package 과제.과제8.Car.model.지역;

public class 부산 {
	//싱글톤
	private 부산() {};
	private static 부산 Busan = new 부산();
	public static 부산 getInstance() {return Busan;}
	
	private int distance = 36;
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
