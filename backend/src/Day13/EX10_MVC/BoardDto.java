package Day13.EX10_MVC;

public class BoardDto {
	//필드
	//= DB와 일치
	private int mno;
	private String mid;
	private String mpw;
	
	//생성자
	public BoardDto() {}
	
	public BoardDto(int mno, String mid, String mpw) {
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
	}
	
	//메소드

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	
	
	
	
	
}
