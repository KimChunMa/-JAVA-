package model.dto;

public class MpointDto {
	int mpno ; //포인트 내역 신청
    String mpcomment ; //포인트 내역 내용
    int mpamount ; // 포인트 수량
    String mpdate ; // 포인트 받은 날짜
    int mno;		//포인트 주인
    
	public MpointDto(int mpno, String mpcomment, int mpamount, String mpdate, int mno) {
		super();
		this.mpno = mpno;
		this.mpcomment = mpcomment;
		this.mpamount = mpamount;
		this.mpdate = mpdate;
		this.mno = mno;
	}

	public MpointDto() {
		super();
	}

	public int getMpno() {
		return mpno;
	}

	public void setMpno(int mpno) {
		this.mpno = mpno;
	}

	public String getMpcomment() {
		return mpcomment;
	}

	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}

	public int getMpamount() {
		return mpamount;
	}

	public void setMpamount(int mpamount) {
		this.mpamount = mpamount;
	}

	public String getMpdate() {
		return mpdate;
	}

	public void setMpdate(String mpdate) {
		this.mpdate = mpdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}
	
	
	
    
    
}
