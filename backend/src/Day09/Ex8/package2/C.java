package Day09.Ex8.package2;

import Day09.Ex8.package1.A;
import Day09.Ex8.package1.B;

public class C {
	A a; // public import 함
	
	A a1 = new A(true);
	//A a2 = new A(1); default 다른 패키지
	//A a3 = new A(abc); private 내부가아님
	
	public static void main(String[] args) {
		A a4 = new A(true);
		a4.field1 = 10;
		//a4.field2 = 10; default
		//a4.field3 = 10; private
	}
	
	
}
