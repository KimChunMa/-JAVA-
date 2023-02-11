// 처리/제어
package 과제.과제4.controller;
import java.util.ArrayList;
import 과제.과제4.model.Member;

public class Mcontroller {
	
	ArrayList<Member> memberDB = new ArrayList<>();
	
	//1. 회원가입 로직
	public int signup(String id, String pw, String confirmpw, String name, String tel) {
		if(!(pw.equals(confirmpw))) {return 1;} //회원가입 실패
		
		Member member = new Member(id,pw,name,tel);
		memberDB.add(member);
		return 0; //회원가입 성공
	}
	
	//2. 로그인 로직
	public int login (String id, String pw) {
		
		//모든 멤버중 동일한 아이디 / 비밀번호 찾기
		for(int i = 0 ; i < memberDB.size(); i++) {
			
			if(memberDB.get(i).id.equals(id)) { //아이디 일치
				if(memberDB.get(i).pw.equals(pw)) { // 비밀번호 일치
					return i ;}//현재위치반환 
				else { return -1;} // 비밀번호가 틀림
			}//id e
		}// for e
		return -2; // 아이디가 없음
	}//login e
	
	
	//3. 아이디 찾기 로직
	public String findId(String name, String phone) {
		//입력받은 이름과 전화번호와 일치한 회원찾기
		for(Member m : memberDB) {
			if(m.name.equals(name) && m.phone.equals(phone)) {
					return m.id;
			}
		}
		return null; //아이디 못찾으면 null
	}
	
	//4. 비밀번호 찾기 로직
	public String findPw(String id, String tel) {
		//입력받은 이름과 전화번호와 일치한 회원찾기
		for(Member m : memberDB) {
			if(m.id.equals(id) && m.phone.equals(tel)) {
					return m.pw;
			}
		}
		return null; //비밀번호 못찾으면 null
	}
	
}
