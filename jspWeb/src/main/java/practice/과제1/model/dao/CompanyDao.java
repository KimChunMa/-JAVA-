package practice.과제1.model.dao;

import java.sql.SQLException;

import practice.과제1.model.dto.CompanyDto;

public class CompanyDao extends Dao{
	private static CompanyDao dao = new CompanyDao();
	private  CompanyDao() {};
	public static CompanyDao getInstance() {return dao;}
	
	//1. 사원 등록 이경석
	public boolean regist( CompanyDto dto){
		
		//이름, 직급, 고용형태, 부서 , 입사일, 사진, 퇴사일, 퇴사사유 순
		
		String sql = "insert into workers "
				+ " (name , grade, worker, department, joinDate,picture ,retire,reason ) "
				+ " values (?,?,?,?,?,?,?,?);";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getGrade());
			ps.setString(3, dto.getWorker());
			ps.setString(4, dto.getDepartment());
			ps.setString(5, dto.getJoinDate());
			ps.setString(6, dto.getPicture());
			ps.setString(7, dto.getRetire());
			ps.setString(8, dto.getReason());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {System.err.println(e);}
		
		
		return false;
	}
	
}
