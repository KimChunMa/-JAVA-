package model.dto;

public class ReplyDto {
	private int rno ;
	private String rcontent ;
	private String rdate ;
	private int rindex ;
	private int mno;
	private int bno ;
	
	//추가
	private String mid;
	private String ming;
	
	//등록용
	public ReplyDto(String rcontent, int mno, int bno) {
		super();
		this.rcontent = rcontent;
		this.mno = mno;
		this.bno = bno;
	}
	
	

	public ReplyDto(String rcontent, int rindex, int mno, int bno) {
		super();
		this.rcontent = rcontent;
		this.rindex = rindex;
		this.mno = mno;
		this.bno = bno;
	}



	public ReplyDto() {
		super();
	}

	public ReplyDto(int rno, String rcontent, String rdate, int rindex, int mno, int bno, String mid, String ming) {
		super();
		this.rno = rno;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rindex = rindex;
		this.mno = mno;
		this.bno = bno;
		this.mid = mid;
		this.ming = ming;
	}
	
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String mcontent) {
		this.rcontent = mcontent;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String radte) {
		this.rdate = radte;
	}
	public int getRindex() {
		return rindex;
	}
	public void setRindex(int rindex) {
		this.rindex = rindex;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMing() {
		return ming;
	}
	public void setMing(String ming) {
		this.ming = ming;
	}
	
	
}
