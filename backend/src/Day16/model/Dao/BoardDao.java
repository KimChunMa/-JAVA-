package Day16.model.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Day16.model.Dto.BoardDto;
import Day16.model.Dto.CategoryDto;

public class BoardDao extends Dao{
	private BoardDao () {};
	private static BoardDao Bdao = new BoardDao();
	public static BoardDao getInstance() {return Bdao;}
	
	//1. 카테고리 추가
public boolean categoryAdd (String cname ) {
		String sql = "insert into category(cname) values (?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cname);
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {e.printStackTrace();}
		
		return false;
	}
	
	
	//2. 모든 카테고리 호출
public ArrayList<CategoryDto> categoryPrint() {
	String sql = "select * from category;";
	
	ArrayList<CategoryDto> clist = new ArrayList<>();
	
	try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			CategoryDto dto = new CategoryDto(rs.getInt(1), rs.getString(2));
			clist.add(dto);
		}
		return clist;
	} catch (SQLException e) {e.printStackTrace();}
	
	return null;
} // categoryPrint() e

// 3. 게시물 등록 
public boolean boardAdd( String btitle , String bcontent , int mno  , int cno ) {
	String sql = "insert into board( btitle , bcontent , mno_fk , cno_fk  ) values(  ? , ? , ?, ? )";
	try {
		ps = con.prepareStatement(sql);
		ps.setString( 1 , btitle );		ps.setString( 2 , bcontent );
		ps.setInt( 3 , mno);			ps.setInt( 4 , cno);
		ps.executeUpdate();				return true; 
	}catch (Exception e) {System.out.println(e);}
	return false;
}

//최신 게시물 3개 출력
public ArrayList<BoardDto> boardPrintRecent(){
	ArrayList<BoardDto> blist = new ArrayList<>();
	String sql = " select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname "
			+ " from board b , member m , category c "
			+ " where b.mno_fk = m.mno and b.cno_fk = c.cno "
			+ " order by b.bdate desc limit 3 ";
	try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while( rs.next() ) {
			BoardDto dto = new BoardDto( rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			blist.add(dto);
		}
	}catch (Exception e) {System.out.println(e);}
	return blist;
}

//해당 카테고리 게시물 출력
public ArrayList<BoardDto> boardPrint(int cno){
	ArrayList<BoardDto> blist = new ArrayList<>();
	String sql = " select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname "
			+ "	from board b , member m , category c "
			+ "	where b.mno_fk = m.mno and b.cno_fk = c.cno and b.cno_fk = ?";
	try {
		ps = con.prepareStatement(sql);
		ps.setInt( 1 , cno );
		rs = ps.executeQuery();
		while( rs.next() ) {
			BoardDto dto = new BoardDto( rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			blist.add(dto);
		}
	}catch (Exception e) {System.out.println(e);}
	return blist;
}



}
