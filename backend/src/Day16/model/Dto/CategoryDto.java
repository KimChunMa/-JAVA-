package Day16.model.Dto;

public class CategoryDto {
	private int cno ;
    private String cname;
    
	public CategoryDto(int cno, String cname) {
		super();
		this.cno = cno;
		this.cname = cname;
	}
	
	public CategoryDto() {
		super();
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
    
	
	
    
}
