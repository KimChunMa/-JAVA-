package Day09.Ex10_게시판.model;

import java.util.Date;

/*
 	모든 필드는 [private]
 	생성자 [빈거, 전체]
 	메소드 [toString, get , set]
 
 */


public class Board {
	
	private String title;
	private String content;
	private String writer;
	private String pw;
	private Date date;
	private int view;
	
	
	public Board() {
		super();
	}

	
	public Board(String title, String content, String writer, String pw,Date date, int view) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.view = view;
		this.pw = pw;
	}


	@Override
	public String toString() {
		return title +"\t"+writer+"\t"+view+"\t"+date;
	}

	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getView() {
		return view;
	}


	public void setView(int view) {
		this.view = view;
	}
	
	
	
	
}
