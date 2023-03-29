package model.dto;

public class ChatDto {
	private long nno; 		 //노트 고유 번호
    private String ncontent; // 노트 내용
    private String ndate; 	 // 노트 날짜
    private int pno; 		 //제품 명
    private int frommno; 	 //받는사람
    private int tomno; 		 //주는사람
    
    //추가필드
    private String frommid;  // 보낸사람 아이디
    private String frommimg; // 보낸사람 프로필
    
    
	public ChatDto(long nno, String ncontent, String ndate, int pno, int frommno, int tomno) {
		super();
		this.nno = nno;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.pno = pno;
		this.frommno = frommno;
		this.tomno = tomno;
	}

	
	
	@Override
	public String toString() {
		return "ChatDto [nno=" + nno + ", ncontent=" + ncontent + ", ndate=" + ndate + ", pno=" + pno + ", frommno="
				+ frommno + ", tomno=" + tomno + "]";
	}



	public String getFrommid() {
		return frommid;
	}



	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}



	public String getFrommimg() {
		return frommimg;
	}



	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}



	public long getNno() {
		return nno;
	}

	public void setNno(long nno) {
		this.nno = nno;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNdate() {
		return ndate;
	}

	public void setNdate(String ndate) {
		this.ndate = ndate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getFrommno() {
		return frommno;
	}

	public void setFrommno(int frommno) {
		this.frommno = frommno;
	}

	public int getTomno() {
		return tomno;
	}

	public void setTomno(int tomno) {
		this.tomno = tomno;
	}
    
    
}