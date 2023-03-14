package practice.과제1.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<CompanyDto> list(){
		String sql = "select * from workers";
		ArrayList<CompanyDto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CompanyDto dto = new CompanyDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6),
						rs.getString(7), 
						rs.getString(8),
						rs.getString(9));
				list.add(dto);
			}
			
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	
	//3. 인사 수정
	public boolean edit(int wno) {
		
		String sql = "update workers set ";
		
		
		return false;
	}
	
}
