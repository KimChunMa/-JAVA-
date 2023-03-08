package model.dto;

public class FriendDto {
	int fno ; //식별 번호
    int ffrom ; // 친구 신청한 사람
    int fto ; //친구 신청 받은 사람
    
	public FriendDto(int fno, int ffrom, int fto) {
		super();
		this.fno = fno;
		this.ffrom = ffrom;
		this.fto = fto;
	}

	public FriendDto() {
		super();
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getFfrom() {
		return ffrom;
	}

	public void setFfrom(int ffrom) {
		this.ffrom = ffrom;
	}

	public int getFto() {
		return fto;
	}

	public void setFto(int fto) {
		this.fto = fto;
	}
    
	
    
}
