package Day13.EX10_MVC;

public class MemberDto {
	//필드
	//= DB와 일치
	private int mno;
	private String mid;
	private String mpw;
	
	//생성자
	public MemberDto() {}
	
	public MemberDto(int mno, String mid, String mpw) {
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

	@Override
	public String toString() {
		
		return mno+mid+mpw;
	}
	
	
	
	
	
	
}
