package Day13.Ex11_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductDao {
	//싱글톤
	private static ProductDao dao = new ProductDao();
	public static ProductDao getInstand() {return dao;}
	
	//생성자
	private ProductDao () {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/products","root","1234");
		} catch (SQLException e) {
			System.out.println("오류! "+e.getMessage());
		}
	};
	
	//필드
	private Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs; 			// sql 결과
	private ArrayList<ProductDto> basket = new ArrayList<>();
	
	
	//제품등록
	public boolean pSubmit(String pname, int pprice, int inventory) {
		String sql = "insert into product (pname, pprice, inventory) values(?,?,?)";
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, pprice);
			ps.setInt(3, inventory);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			System.out.println("오류! "+e.getMessage());
		}
		
		return false;
	}//pSubmit
	
	//제품 출력
	public ArrayList<ProductDto> list() {
		ArrayList<ProductDto> List = new ArrayList<>();
		String sql = "select * from product";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductDto dto = new ProductDto(
				rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				List.add(dto);
				
			}
			return List;
		} catch (SQLException e) {
			System.out.println("오류! "+e.getMessage());
		}
		return null;
	}//list() e
	
	//제품 수정 이름,가격
	public boolean pEdit(int pno,String pname , int pprice) {
		String sql ="update product set pname=?, pprice=? where pno =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, pprice);
			ps.setInt(3, pno);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			System.out.println("오류! "+e.getMessage());
		}
		
				
		return false;
	}
	
	//제품 재고 변경
	public boolean iEdit(int pno , int inventory) {
		String sql ="update product set inventory=? where pno =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inventory);
			ps.setInt(2, pno);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("오류! "+e.getMessage());
		}
		return false;
	}
	
	//제품 삭제
	public boolean delete(int pno) {
		String sql="delete from product where pno=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("오류! "+e.getMessage());
		}
		return false;
	}
	
	//------------사용자-----------------
	
	//제품번호 받기
	public boolean pclick(int pno) {
		String sql="select * from product where pno=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pno);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				if(rs.getInt(4)<=0) { //재고가 없으면 null;
					return false;}
				
				ProductDto dto = new ProductDto(
				rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				basket.add(dto);	
			}
			return true;
			
		} catch (SQLException e) {
			System.out.println("오류! "+e.getMessage());
		}
		return false;
	}
	
	//장바구니 출력
	public ArrayList<ProductDto> blist() {
		return basket;}
	
	//재고 차감
	public boolean min() {
		int pno=0; //제품번호
		int inventory=0; //재고
		
		for(ProductDto dto  :basket ) { 
			pno= dto.getPno(); 
			String sql1 = "select * from product where pno=?"; 
			
			try {
				ps=conn.prepareStatement(sql1);
				ps.setInt(1, pno);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					inventory=rs.getInt(4);
					inventory--; //현재 데이터에서 -1 차감
				}
				
				String sql2 = "update product set inventory=? where pno=?";
				
				ps=conn.prepareStatement(sql2);
				ps.setInt(1, inventory);
				ps.setInt(2, pno);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("오류! "+e.getMessage());
				return false;
			}
		}
		return true;
	}
	
}
