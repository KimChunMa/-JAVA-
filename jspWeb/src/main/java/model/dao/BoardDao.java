package model.dao;

import java.sql.SQLException;

import model.dto.BoardDto;

public class BoardDao extends Dao{
	private static BoardDao dao = new BoardDao();
	private BoardDao() {};
	public static BoardDao getInstance() {return dao;}
	
	// 글쓰기
	public boolean bwrite(BoardDto dto) {
		String sql ="insert into board(btitle, bcontent, bfile, mno_fk, cno_fk) "
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
}
