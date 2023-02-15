package Day10.Ex6;

public class 실행 {
	public static void main(String[] args) {
		Car mycar = new Car();
		
		
		
		//car
		//Car객체의 Tire객체에 Tire대입 부모<=부모
		mycar.tire = new Tire();
		mycar.run();
		mycar.tire.roll();
		
		Tire tire = new Tire();
		Tire result2 = mycar.parking(tire);
		
		
		//한국
		//Car객체의 Tire객체에 HankookTire대입 부모<=자식
		mycar.tire = new HankookTire();
		mycar.run();
		mycar.tire.roll();
		
		//한국 타이어 객체
		HankookTire han = new HankookTire();
		
		//한국타이어	객체	   = (강제형변환)		부모타이어
		HankookTire result = ( HankookTire)mycar.parking(han);
		
		//					하위		instanceof	상위
		System.out.println( result instanceof Tire);
		
		//금호
		//Car객체의 Tire객체에 KumhoTire대입 부모<=자식
		mycar.tire = new KumhoTire();
		mycar.run();
		mycar.tire.roll();
		
		KumhoTire kum = new KumhoTire();
		mycar.parking(kum);
		
	}
}
