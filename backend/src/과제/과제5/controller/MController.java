package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Member;

public class MController {
	//싱글톤
	private MController() {};
	private static MController mc = new MController();
	private static MController getInstance() {return mc;}
	
	//멤버DB
	private ArrayList<Member> memberDB = new ArrayList<>();
	
	//멤버 확인용
	private Member logSession = null;
	
	
	
	
	//회원가입
	public int signUp(String Id, String Pw) {
		Member m = new Member(Id,Pw);
		
		return 0;
	}
	
	//로그인
	public int login(String Id, String Pw){
		int i = 0;
		for(Member m : memberDB) {
			if(m.getId().equals(Id)) {
				if(m.getPw().equals(Pw)) {
					logSession = m;
					return i;
				}//if pw e
			}//if id e
	i++;}// for e
	return -1;} // 없는 회원
	
	
	
	
	}//class e
	

