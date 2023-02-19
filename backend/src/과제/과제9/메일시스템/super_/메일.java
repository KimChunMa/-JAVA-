package 과제.과제9.메일시스템.super_;

import java.util.ArrayList;

public class 메일 {
	public String 발신지;
	public String 수신지;
	public String title;
	public String content;
	public String file;
	public String alarm;
	
	//메일함
	ArrayList<메일> Mail = new ArrayList<>();
	
	//회원
	ArrayList<메일> Member = new ArrayList<>();

	public 메일() {}

	public 메일(String 발신지) {
		this.발신지 = 발신지;
	}
	
	

	public 메일(String 발신지, String 수신지, String title, String content) {
		this.발신지 = 발신지;
		this.수신지 = 수신지;
		this.title = title;
		this.content = content;
	}

	public ArrayList<메일> getMail() {
		return Mail;
	}

	public void pushMail(메일 멤버) {
		Mail.add(멤버);
	}

	public ArrayList<메일> getMember() {
		return Member;
	}

	public void pushMember(메일 멤버) {
		Member.add(멤버);
	}

	public String get발신지() {
		return 발신지;
	}

	public void set발신지(String 발신지) {
		this.발신지 = 발신지;
	}

	
	
	
	
	
	
	
}
