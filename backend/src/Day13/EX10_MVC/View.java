package Day13.EX10_MVC;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	//싱글톤
	private View() {};
	private static View v = new View();
	public static View getInstance () {return v;}
	
	Scanner sc = new Scanner(System.in);
	
	public void index() {
		
		while(true) {
			System.out.println("1.등록[C] 2.출력[R] 3.수정[U] 4.삭제[D]:"); int ch = sc.nextInt();
			
			if(ch==1) {signup();}
			else if(ch==2) {}
			else if(ch==3) {}
			else if(ch==4) {}
		}
	}
	
	public void signup() {
		System.out.println("---------등록 [C]---------");
		sc.nextLine();
		System.out.println("아이디: "); String mid = sc.nextLine(); 
		System.out.println("비밀번호: "); String mpw = sc.nextLine();
		boolean result = Controller.getInstance().signup(mid,mpw);
		
		if(result ) {System.out.println("회원가입 성공");}
		else {System.out.println("회원가입 실패!");}
	}
	
	public ArrayList<MemberDto> list() {return null;}
}
