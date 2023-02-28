package Day16.model.Dto;

public class MemberDto {
	private int mno;
	private String mid;
	private String mpw;
	private String name;
	private String mphone;
	
	
	public MemberDto() {
		super();
	}


	public MemberDto(int mno, String mid, String mpw, String name, String mphone) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.name = name;
		this.mphone = mphone;
	}

	public String getMpw() {
		return mpw;
	}




	public void setMpw(String mpw) {
		this.mpw = mpw;
	}




	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", name=" + name + ", mphone=" + mphone + "]";
	}


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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	
	
}
