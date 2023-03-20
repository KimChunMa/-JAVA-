package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDto {
	private int bno ;
    private String btitle ;
    private String bcontent ;
    private String bfile;
    private String bdate ;
    private int bview ;
    private int likes;
    private int hates;
    private String bwriter ;
    private int cno_fk ;
    private int mno_fk ;
    
    //출력용
    private String mid; // 아이디
    
    private String mimg; // 이미지
    private int rcount; // 댓글수
    
 

	//빈 생성자
    public BoardDto() {}
    
    //업데이트용도
	public BoardDto(int bno, String btitle, String bcontent, String bfile, int cno_fk) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.cno_fk = cno_fk;
	}

    
    
    //풀 생성자
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int likes,
			int hates, String bwriter, int cno_fk, int mno_fk) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.likes = likes;
		this.hates = hates;
		this.bwriter = bwriter;
		this.cno_fk = cno_fk;
		this.mno_fk = mno_fk;
	}



	//제목,내용,파일,카테고리 번호, 멤버 번호
	public BoardDto(String btitle, String bcontent, String bfile, int cno_fk, int mno_fk) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.cno_fk = cno_fk;
		this.mno_fk = mno_fk;
	}
	
	//출력용
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int likes,
			int hates, String bwriter, int cno_fk, int mno_fk, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		
		//오늘 날짜와 일치시 시간표기 아니면 날짜 표기
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
		System.out.println(now);
		//[0] 날짜 , [1] 시간
		if( now.split(" ")[0].equals(bdate.split(" ")[0]) ) {
			this.bdate = bdate.split(" ")[1];
		}else {
			this.bdate = bdate.split(" ")[0];
		}
		
		this.bview = bview;
		this.likes = likes;
		this.hates = hates;
		this.bwriter = bwriter;
		this.cno_fk = cno_fk;
		this.mno_fk = mno_fk;
		this.mid = mid;
	}

	
	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getHates() {
		return hates;
	}

	public void setHates(int hates) {
		this.hates = hates;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public int getCno_fk() {
		return cno_fk;
	}

	public void setCno_fk(int cno_fk) {
		this.cno_fk = cno_fk;
	}

	public int getMno_fk() {
		return mno_fk;
	}

	public void setMno_fk(int mno_fk) {
		this.mno_fk = mno_fk;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
    
	
	
    
}
