// 처리/제어
package 과제.과제4.controller;
import java.util.ArrayList;
import 과제.과제4.model.Member;

public class Mcontroller {
	
	ArrayList<Member> memberDB = new ArrayList<>();
	
	//회원가입 로직
	public int signup(String id, String pw, String confirmpw, String name, String tel) {
		if(pw.equals(confirmpw)) {return 1;}
		
		Member member = new Member(id,pw,name,tel);
		memberDB.add(member);
		return 0;
	}
	//로그인 로직
	
	//아이디 찾기 로직
	
	//비밀번호 찾기 로직
}
