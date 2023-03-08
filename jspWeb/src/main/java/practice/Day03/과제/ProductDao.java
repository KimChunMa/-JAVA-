package practice.Day03.과제;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/products",
					"root",
					"1234"
					);
		}catch (Exception e) {System.err.println(e);}
	}
	private static ProductDao PDao = new ProductDao();
	public static ProductDao getInstance() {return PDao;}
	
	
	//1.입력
	public boolean register(ProductDto PDto) {
		String sql = "insert into product(pname,pprice) values(?,?)";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, PDto.getPname());
			ps.setInt(2, PDto.getPprice());
			ps.executeUpdate();
		} catch (SQLException e) {System.out.println(e);}
		return true;
	}
	
	//2.출력
	public ArrayList<ProductDto> product_print(){
		String sql = "select * from product";
		ArrayList<ProductDto> plist = new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ProductDto pdto = new ProductDto(
				rs.getInt(1), rs.getString(2) , rs.getInt(3)
				);
				plist.add(pdto);
			}
			
		} catch (SQLException e) {System.out.println(e);}
		
		return plist;
	}
	
	//3.삭제
	public boolean product_delete(int pno) {
		String sql ="delete from product where pno="+pno ;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {System.out.println(e);}
		return true;
	}
	
	//4.수정
	public boolean product_edit(int pno, int newPrice) {
		String sql ="update product set pprice = "+newPrice+" where pno="+pno;
		
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {System.out.println(e);}
		
		return true;
		
	}
}
