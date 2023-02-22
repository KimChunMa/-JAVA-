package Day13.Ex11_MVC;

public class ProductDto {
	//필드
	private int pno;
	private String pname;
	private int pprice;
	private int inventory;
	
	//생성자
	public ProductDto(int pno, String pname, int pprice, int inventory) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.inventory = inventory;
	}

	
	public ProductDto() {
		super();
	}




	//메소드
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
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	
}
