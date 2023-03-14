package practice.과제1.model.dto;

public class CompanyDto {
	private int wno ;	//사원번호
	private String name ;			//사원 이름		
	private String grade ;			//	직급	
	private String worker ;			//고용 형태	
	private String department ;		//부서	
	private String joinDate	;		//입사일		
	private String picture	;		//사진	
	private String retire	;		//퇴사일		
	private String reason	;		//퇴사사유	
	
	
	//현 직무중 생성자
	public CompanyDto(int wno, String name, String grade, String worker, String department, String joinDate,
			String picture) {
		super();
		this.wno = wno;
		this.name = name;
		this.grade = grade;
		this.worker = worker;
		this.department = department;
		this.joinDate = joinDate;
		this.picture = picture;
	}


	//퇴사자 생성자
	public CompanyDto(int wno, String name, String grade, String worker, String department, String joinDate,
			String picture, String retire, String reason) {
		super();
		this.wno = wno;
		this.name = name;
		this.grade = grade;
		this.worker = worker;
		this.department = department;
		this.joinDate = joinDate;
		this.picture = picture;
		this.retire = retire;
		this.reason = reason;
	}
	
	
	
	public int getWno() {
		return wno;
	}
	public void setWno(int wno) {
		this.wno = wno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getRetire() {
		return retire;
	}
	public void setRetire(String retire) {
		this.retire = retire;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
	
}
