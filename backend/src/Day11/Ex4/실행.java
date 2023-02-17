package Day11.Ex4;

public class 실행 {
	public static void main(String[] args) {
		interfacebro bro = new interfacebro();
		
		interfaceA ia = bro;
		ia.methodA();
		
		interfaceB iB = bro;
		iB.methodB();
		
		//인터페이스 자식은 부모메소드 사용가능
		interfaceC iC = bro;
		iC.methodA();
		iC.methodB();
		iC.methodC();
	}
}
