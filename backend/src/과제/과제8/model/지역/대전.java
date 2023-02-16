package 과제.과제8.model.지역;


public class 대전 {
	//싱글톤
	private 대전() {};
	private static 대전 Daejeon = new 대전();
	public static 대전 getInstance() {return Daejeon;}
	
	private int distance = 6;
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
