//클래스 실행 목적: main함수 가진 클래스
package Day08.Ex2;

public class 실행 {
	public static void main(String[] args) {
		Korean ko1 = new Korean();
		
		System.out.println(ko1.toString());
		System.out.println(ko1.name);
		System.out.println(ko1.nation);
		System.out.println(ko1.ssn);
		
		
		Korean ko2 = new Korean("유재석","0011225-1234567");
		System.out.println(ko2.toString());
		System.out.println(ko2.name);
		System.out.println(ko2.nation);
		System.out.println(ko2.ssn);

	}
}
