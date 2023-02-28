package Day16.model.Dto;

import java.util.Date;

public class ReplyDto {

	private int rno ;
	private String rcontent;
	private String rdate;
	private  int rindex ;
	
	private String mid;
	private int bno;
	
	
	
	public ReplyDto() {
		super();
	}



	public ReplyDto(int rno, String rcontent, String rdate, int rindex, String mid, int bno) {
		super();
		this.rno = rno;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rindex = rindex;
		this.mid = mid;
		this.bno = bno;
	}
	
	
	
}
