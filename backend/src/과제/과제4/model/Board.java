package 과제.과제4.model;

public class Board { //로그인 게시판 클래스
	public int view = 0;
	public String writer;
	public String title;
	public String content;
	
	public Board( String title, String content,String writer) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	
}
