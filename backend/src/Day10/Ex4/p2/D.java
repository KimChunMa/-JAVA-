package Day10.Ex4.p2;

import Day10.Ex4.p1.A;

public class D extends A{
	public D() {
		super();
	};
	
	public void method1() {
		this.field = "value";
		this.method();
	}
	
	/*직접 객체 생성은 불가능
	 * public void method2() { 
	 * A a = new A(); 
	 * a.field = "value"; 
	 * a.method(); }
	 */
	
}
