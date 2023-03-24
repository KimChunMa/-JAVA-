package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.ProductDto;



public class ProductDao extends Dao{
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {return dao;}
	
	//1. 제품 등록
	public boolean write (ProductDto dto) {
		String sql = "insert into product(pname, pcomment, pprice , plat , plng) " +
					" values(?,?,?,?,?) ";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());	ps.setString(2, dto.getPcomment());
			ps.setInt(3, dto.getPprice());		ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());		ps.executeUpdate();
			return true;
		} catch (SQLException e) {System.err.println(e);}
		
		
		return false; 
	}
	
	//2.제품 호출
	public ArrayList<ProductDto> getProductList( String 동, String 서 , String 남 , String 북){
		String sql = "SELECT * FROM product where "+동+" >= plng and "+서+" <= plng "
				+ " and "+남+" <= plat and "+북+" >= plat";
		
		ArrayList<ProductDto> list = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				ProductDto dto = new ProductDto(
				//번호, 이름, 설명, 가격, 상태, 위도, 경도 , 조회수, 날짜
				rs.getInt(1), rs.getString(2), 	rs.getString(3),
				rs.getInt(4), rs.getInt(5), rs.getString(6),
				rs.getString(7), rs.getInt(8), rs.getString(9)   
				);
				list.add(dto);
			}
			
			return list;
		} catch (SQLException e) {System.err.println(e);}
		
		return null;
	}
	
	// 3. 찜하기 등록 / 취소
	public boolean setplike(int pno , int mno) {
		//1. 등록할지 취소할지 검색 먼저
		String sql = "select * from plike "
				+ " where pno = "+pno+" and mno = "+mno;
		
		try {
			ps=con.prepareStatement(sql); rs=ps.executeQuery();
			if(rs.next()) { // 해당 회원이 이미 찜하기를 한 제품 => 취소하기
				
				sql = "delete from plike where pno = "+pno+" and mno = "+mno;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return false; // 삭제시 e
			}else { // 해당 회원이 찜하기를 하지 않은 제품 --> 등록하기
				sql = "insert into plike(pno, mno) values ("+pno+", "+mno+")";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true; // 찜하기시 t
			}
		} catch (SQLException e) {System.err.println(e);}
		return false;
	}
	
	//4. 현재 회원이 해당 제품의 찜하기 상태 확인
	public boolean getplikc(int pno, int mno) {
		//1. 등록할지 취소할지 검색 먼저
		String sql = "select * from plike "
				   + " where pno = "+pno+" and mno = "+mno;
				
		try {
			ps=con.prepareStatement(sql); rs=ps.executeQuery();
				if(rs.next()) { 
					return false; //찜목록에 있으면 false 
				}
			} catch (SQLException e) {System.err.println(e);}
				return true; // 찜목록에 없으면 true 
	}
}
