package Day10.Ex2;

public class Computer extends Calculator{
	//오버라이딩
	@Override // 생략가능
	public double areaCircle(double r) {
		System.out.println("자식");
		return Math.PI * r *r;
	}
}
