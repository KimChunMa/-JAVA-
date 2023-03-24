package model.dto;

public class ProductDto {
	private int pno; 		// #제품번호
	private String pname ;	//# 제품명  
	private String pcommnet; 	//#제품설명
	private int pprice; 	//#제품가격
	private int psatus; 	// #상태 [1:판매중 2:거래중 3:판매완료]
	private String plat; 	// #위도
	private String plng; 	// #경도
	private int pview; 		// #조회수
	private String pdate; 	// #등록일
	
	public ProductDto(int pno, String pname, String  pcommnet, int pprice, int psatus, String plat, String plng, int pview,
			String pdate) {
		super();
		this.pno = pno;
		this.pname = pname;
		this. pcommnet =  pcommnet;
		this.pprice = pprice;
		this.psatus = psatus;
		this.plat = plat;
		this.plng = plng;
		this.pview = pview;
		this.pdate = pdate;
	}
	
	
	//1. 상품등록
	public ProductDto(String pname, String pcommnet, int pprice, String plat, String plng) {
		super();
		this.pname = pname;
		this.pcommnet = pcommnet;
		this.pprice = pprice;
		this.plat = plat;
		this.plng = plng;
	}



	public ProductDto() {
		super();
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	

	public String getPcommnet() {
		return pcommnet;
	}



	public void setPcommnet(String pcommnet) {
		this.pcommnet = pcommnet;
	}



	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPsatus() {
		return psatus;
	}

	public void setPsatus(int psatus) {
		this.psatus = psatus;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getPlng() {
		return plng;
	}

	public void setPlng(String plng) {
		this.plng = plng;
	}

	public int getPview() {
		return pview;
	}

	public void setPview(int pview) {
		this.pview = pview;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ",  pcommnet=" +  pcommnet + ", pprice=" + pprice + ", psatus="
				+ psatus + ", plat=" + plat + ", plng=" + plng + ", pview=" + pview + ", pdate=" + pdate + "]";
	}

	
	
	
	
	
}
