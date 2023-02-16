package Day10.Ex7;

import java.util.ArrayList;

import Day10.Ex6.HankookTire;
import Day10.Ex6.KumhoTire;
import Day10.Ex6.Tire;

public class 실행2 {
	public static void main(String[] args) {
		Tire tire = new Tire();
		KumhoTire kum = new KumhoTire();
		HankookTire han = new HankookTire();
		
		//참조타입 자동타입 변환
		Tire temp = tire;
			Tire temp2 = kum;
			Tire temp3 = han;
				Object temp4 = temp3;
				
		//2. 강제타입 변환
						// (자식) 부모
		KumhoTire kum2 = (KumhoTire) tire; 
		HankookTire kum3 = (HankookTire) tire;
		
		Tire tire2 = (Tire)temp4;
		
		//3. 매개변수, 리턴타입
		Tire result = 함수1(kum2);
		KumhoTire result2 = (KumhoTire)함수2( (KumhoTire)tire);
		
		//4 배열
		ArrayList<KumhoTire> kumList = new ArrayList<>();
		kumList.add(kum);
		//kumList.add(han);
		//kumList.add(tire);
		
		ArrayList<Tire> TireList = new ArrayList<>();
		TireList.add(kum);
		TireList.add(han);
		TireList.add(tire);
	}
	public static Tire 함수1(Tire tire) {return tire;}
	public static Tire 함수2(KumhoTire kum) {return new Tire();}
}
