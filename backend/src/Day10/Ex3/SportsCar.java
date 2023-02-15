package Day10.Ex3;

public class SportsCar extends Car{
	
	//final 할시  
	public void Up() {
		speed+=10;
	}
	
	/* final이여서 오버라이딩 불가능. 사용은 가능
	 * public void stop() { System.out.println("오류"); }
	 */
}
