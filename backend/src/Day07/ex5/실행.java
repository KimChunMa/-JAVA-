package Day07.ex5;

import java.util.ArrayList;


public class 실행 {
	public static void main(String[] args) {

		Member m1 = new Member();
		m1.id = "qwe" ; m1.pw ="qwe";
		
		Member m2 = new Member();
		m1.id = "qwe" ; m1.pw ="qwe";
		
		Member m3 = new Member();
		m1.id = "qwe" ; m1.pw ="qwe";
		
		
		
		//배열 [언어문법]
		Member[] memberList1 = new Member[3];
		memberList1[0] = m1;
		memberList1[1] = m2;
		memberList1[2] = m3;
		
		memberList1[1] = null;
		System.out.println(memberList1[1]);
		
		//컬랙션 (프레임워크 {미리만들어짐})
		ArrayList<Member> memberList2 = new ArrayList<>();
		memberList2.add(m1);
		memberList2.add(m2);
		memberList2.add(m3);
		
		memberList2.remove(1); 
		System.out.println(memberList2);
	}
}
