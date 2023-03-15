package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao{
	private static BoardDao dao = new BoardDao();
	private BoardDao() {};
	public static BoardDao getInstance() {return dao;}
	
	// 1. 글쓰기
	public boolean bwrite(BoardDto dto) {
		String sql ="insert into board(btitle, bcontent, bfile, mno, cno) "
				+ " value(?,?,?,?,?)";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle()); ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile()); ps.setInt(4,dto.getMno_fk());
			ps.setInt(5, dto.getCno_fk()); ps.executeUpdate();
			return true;
		} catch (SQLException e) {System.err.println(e);}
		return false;
	}
	
	//2. 모든 글 출력
	public ArrayList<BoardDto> getBoardList(){
		
		ArrayList<BoardDto> list = new ArrayList<>();
		
		String sql = "select * from board b  join member m on m.mno = b.mno;";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto(
				rs.getInt(1) , rs.getString(2) , rs.getString(3), 
				rs.getString(4), rs.getString(5), rs.getInt(6),
				rs.getInt(7), rs.getInt(8), rs.getString(9), 
				rs.getInt(10), rs.getInt(11),rs.getString(13));
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {System.err.println();}
		return null;
	}
	
	
	
}
