package Day09.Ex8.package1;

public class A {
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	//public 
	public A (boolean b) {}
	
	//default 패키지
	A(int b){};
	
	//private 내부
	private A (String s) {} 
	
	public int field1;
	
	int field2;
	
	private int field3;
}

