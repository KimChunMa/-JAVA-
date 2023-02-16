package 과제.과제8.model.지역;

public class 광주 {
	//싱글톤
	private 광주() {};
	private static 광주 Gwangju = new 광주();
	public static 광주 getInstance() {return Gwangju;}
	
	private int distance = 12;
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
