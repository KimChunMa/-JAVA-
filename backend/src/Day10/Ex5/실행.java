package Day10.Ex5;

public class 실행 {
	public static void main(String[] args) {
		
		Child c = new Child();
		
		c.method1();
		c.method2(); //오버라이딩
		c.method3();
		
		System.out.println("------");
		//자식객체 -> 부모객체 자동변환
		Parent p = c;
		
		p.method1();
		p.method2(); //오버라이딩
		//p.method3(); 자식메소드는 불가능 오버만 가능
		
		System.out.println(p.name);
		//System.out.println(p.jop); 불가능
		System.out.println("------");
		
		// 강제변환
		//부모객체 => 자식객체 (기존 자식객체와 똑같은거아닌가?)
		Child c2 = (Child)p;
		
		c2.method1();
		c2.method2();
		c2.method3();
		
		System.out.println(c2.name);
		System.out.println(c2.job);
	}
}
