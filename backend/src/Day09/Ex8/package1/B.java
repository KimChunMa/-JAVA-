package Day09.Ex8.package1;

public class B {
	A a; // public 같은패키지라서 import 없이 가능
	A a1 = new A(true); // public
	A a3 = new A(1); // default
	//A a4 = new A("문자열"); private불가능
	
	public static void main(String[] args) {
		A a4 = new A(true);
		a4.field1 = 10; // public 공용
		a4.field2 = 10; // default 같은패키지
		//a4.field3 = 10; private 사용불가능
	}
}
