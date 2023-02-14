package 과제.과제5.model;

import java.util.ArrayList;

public class Member {
	//필드
	private String Id;
	private String Pw;
	
	/*
	private ArrayList<Memo> getMemo = new ArrayList<>();
	private ArrayList<Memo> SetMemo = new ArrayList<>();
	private ArrayList<Product> SpList = new ArrayList<>();
	*/
	
	
	//메소드
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	
	
	//생성자
	public Member() {
		super();
	}
	public Member(String id, String pw) {
		super();
		Id = id;
		Pw = pw;
	}
	

	
	
}
