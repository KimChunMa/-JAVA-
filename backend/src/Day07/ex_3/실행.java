package Day07.ex_3;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//배열
		System.out.println("아이디: "); String id = sc.next();
		System.out.println("패스워드: "); String pw = sc.next();
		
		String[] 배열 = new String[3];
		배열[0] = id+","+pw; // , 로 구분
		System.out.println(배열[0].split(",")[0]);
		
		
		//클래스 객체
		Member m1 = new Member();
		m1.id = id;
		m1.pw = pw;
		
		//클래스 배열
		Member[] 배열2 = new Member[3];
		배열2[0] = m1;
		System.out.println(배열2[0].id);
	}
}
