package Day13.Ex10_MVC;

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
			else if(ch==2) {list();}
			else if(ch==3) {update();}
			else if(ch==4) {delete();}
		}
	}
	
	//등록
	public void signup() {
		System.out.println("---------등록 [C]---------");
		sc.nextLine();
		System.out.println("아이디: "); String mid = sc.nextLine(); 
		System.out.println("비밀번호: "); String mpw = sc.nextLine();
		boolean result = Controller.getInstance().signup(mid,mpw);
		
		if(result ) {System.out.println("회원가입 성공");}
		else {System.out.println("회원가입 실패!");}
	}
	
	//출력
	public  void list() {
		System.out.println("-----------------------");
		System.out.printf("%2s \t %10s \t %10s \n","no","mid","mpw");
		ArrayList<MemberDto> result =  Controller.getInstance().list();
		for(int i = 0 ; i < result.size(); i++) {
			System.out.printf("%2d \t %10s \t %10s \n",result.get(i).getMno() , result.get(i).getMid() , result.get(i).getMpw()  );
		}
	}//list e
	
	//pw수정
	public void update() {
			System.out.println("------------------");
			System.out.println("회원번호 :"); int mno =sc.nextInt();
			System.out.println("새로운 비밀번호 :"); String mpw = sc.next();
			
			boolean result = Controller.getInstance().update(mno, mpw);
			if(result) {System.out.println("[알림] 비밀번호 수정 완료");}
			else if (result==false){System.out.println("[알림] 비밀번호 수정 실패");}
		}
	
	//회원삭제
	public void delete() {
		System.out.println("삭제할 회원번호 :"); int mno = sc.nextInt();
		 boolean result = Controller.getInstance().delete(mno);
		 if(result) {System.out.println("회원탈퇴 성공");}
		 else {System.out.println("회원탈퇴 실패");}
	}
	
}
