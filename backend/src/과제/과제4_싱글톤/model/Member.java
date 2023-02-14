package 과제.과제4_싱글톤.model;

import java.util.ArrayList;

// M : 데이터 저장할때 사용되는 데이터 모델링
// 필드 : private  => get , set
// 회원[객체]는 여러명을 하나의 배열에 

//생성자: 빈 , 풀

public class Member {
	//필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	private ArrayList<Board> boardDB = new ArrayList<>();
	
	//생성자
	public Member() {super();}

	public Member(String id, String pw, String name, String phone, ArrayList<Board> boardDB) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.boardDB = boardDB;
	}

	
	//메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<Board> getBoardDB() {
		return boardDB;
	}

	public void setBoardDB(ArrayList<Board> boardDB) {
		this.boardDB = boardDB;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", boardDB=" + boardDB + "]";
	}
	
	
	
	
}
