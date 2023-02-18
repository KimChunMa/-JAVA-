package 과제.과제9.영화리뷰.super2;

import java.util.ArrayList;

public class 글을쓰기 {
	private String title;
	private String contents;
	private ArrayList<글을쓰기> 글DB = new ArrayList<>();
	private int like=0;
	private int hate=0;
	
	public 글을쓰기() {
		super();
	}


	public 글을쓰기(String title, String contents) {
		this.title = title;
		this.contents = contents;
		like=0; hate=0;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public ArrayList<글을쓰기> get글DB() {
		return 글DB;
	}


	public void set글DB(글을쓰기 글) {
		글DB.add(글) ;
	}


	public int getLike() {
		return like;
	}


	public void setLike() {
		like++;
	}


	public int getHate() {
		return hate;
	}


	public void setHate() {
		hate++;
	}
	
	
	
	
}
