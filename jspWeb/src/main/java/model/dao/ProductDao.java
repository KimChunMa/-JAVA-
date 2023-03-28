package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dto.ChatDto;
import model.dto.ProductDto;



public class ProductDao extends Dao{
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {return dao;}
	
	//1. 제품 등록
	public boolean write (ProductDto dto) {
		String sql = "insert into product(pname, pcomment, pprice , plat , plng, mno) " +
					" values(?,?,?,?,?,?) ";
		
		try {
			
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
			ps.setString(1, dto.getPname());	ps.setString(2, dto.getPcomment());
			ps.setInt(3, dto.getPprice());		ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());		ps.setInt(6, dto.getMno());		
			ps.executeUpdate();
			
			// insert 후 생성된 제품 pk번호 가져오기
			rs=ps.getGeneratedKeys();
			if(rs.next()) {
				for(String pimgname : dto.getPimglist()) {
					//dto내 첨부파일명 반복문 돌려서 하나씩 insert 하기
					sql = "insert into pimg(pimgname , pno) values(?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, pimgname); ps.setInt(2, rs.getInt(1));
					ps.executeUpdate();
				}
			}
			return true;
		} catch (SQLException e) {System.err.println(e);}
		return false; 
	}
	
	//2.제품 호출
	public ArrayList<ProductDto> getProductList( String 동, String 서 , String 남 , String 북){
		String sql = "SELECT  p.*, m.mid, m.mimg FROM product p natural join member m  "
				+ " where "+동+" >= plng and "+서+" <= plng "
				+ " and "+남+" <= plat and "+북+" >= plat";
		
		ArrayList<ProductDto> list = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				ArrayList<String> pimglist = new ArrayList<>();
				sql = "select * from pimg where pno = "+ rs.getInt(1);
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				
				while(rs2.next()) {
					pimglist.add(rs2.getString(2)); // 검색된 이미지이름을 리스트에 저장
				}
				
				ProductDto dto = new ProductDto(
				//번호, 이름, 설명, 가격, 상태, 위도, 경도 , 조회수, 날짜
				rs.getInt(1), rs.getString(2), 	rs.getString(3),
				rs.getInt(4), rs.getInt(5), rs.getString(6),
				rs.getString(7), rs.getInt(8), rs.getString(9) 
				,rs.getInt(10)  ,rs.getString(11)  , pimglist,
				rs.getString(12));
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
	
	//5. 채팅창 보내기
	public boolean setChat(ChatDto dto) {
		String sql = "insert into note(ncontent, pno, frommno, tomno) value(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getNcontent());
			ps.setInt(2, dto.getPno());
			ps.setInt(3, dto.getFrommno());
			ps.setInt(4, dto.getTomno());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {System.err.println(e);}
		
		return false;
	}
	
	//6. 제품에 등록 채팅 [제품번호 일치, 현재보고있는 회원[로그인된 회원], 받거나 보낸내용  ]
	public ArrayList<ChatDto> getChatList(int pno, int mno){
		String sql = "select * from note where pno = ? and (frommno = ? or tomno = ?)";
		ArrayList<ChatDto> list = new ArrayList<>();
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pno); ps.setInt(2, mno); ps.setInt(3, mno);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				list.add( new ChatDto ( 
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4),
						rs.getInt(5), rs.getInt(6)) 
						);
			}
		} catch (SQLException e) {System.err.println(e);}
		return list;
	}
}
