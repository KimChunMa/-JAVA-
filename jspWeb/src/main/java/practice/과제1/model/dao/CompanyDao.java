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
	
	public boolean del(String wno) {
		
		String sql = "delete from workers where wno=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, wno);
			
			int count = ps.executeUpdate();
			if(count == 1 ) {
				return true;
			}
		} catch (Exception e) {System.out.println(e);}
		
		
		return false;
	}
	
	//3-1. 수정전 현재 데이터 출력
		public CompanyDto Eprint(int wno) {
		String sql1 = "select * from  workers where wno ="+wno;
			
			try {
				ps=con.prepareStatement(sql1);
				rs = ps.executeQuery();
				 
				while(rs.next()) {
				CompanyDto dto = new CompanyDto(
				rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
				rs.getString(9));
				return dto;
				}
			} catch (SQLException e) {System.err.println(e);}
			return null;
		}
		
		//3. 인사 수정 이경석
		public boolean edit(CompanyDto dto) {
			
			//이름, 직급, 고용형태, 부서 , 입사일, 사진, 퇴사일, 퇴사사유, 회원번호 순
			String sql = "update workers set name = ? , grade=? , worker = ?,  "
					+ "department = ? , joinDate=?, picture=?,retire=?,reason=? "
					+ "where wno = ?;";
			
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, dto.getName());
				ps.setString(2, dto.getGrade());
				ps.setString(3, dto.getWorker());
				ps.setString(4, dto.getDepartment());
				ps.setString(5, dto.getJoinDate());
				ps.setString(6, dto.getPicture());
				ps.setString(7, dto.getRetire());
				ps.setString(8, dto.getReason());
				ps.setInt(9, dto.getWno());
				ps.executeUpdate();
				return true;
				
			} catch (SQLException e) {System.err.println(e);}
			
			
			return false;
		}
}























