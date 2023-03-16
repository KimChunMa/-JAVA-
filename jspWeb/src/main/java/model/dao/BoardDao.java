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
	
	//2-1 게시물 수 구하기
	public int gettotalsize(String key , String keyword , int cno) {
		
		if(key.equals("") && keyword.equals("")) { // 검색이 있다.
			
			String sql= "select count(*) from member m natural join board b where cno = "+cno;
			try {
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()) {return rs.getInt(1);}
			} catch (SQLException e) {System.err.println(e);}
			
		}else {//검색이 있다
			String sql= "select count(*) from member m natural join board b where "+key+" like '%"+keyword+"%'"
					+ " and  cno="+cno;
			try {
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()) {return rs.getInt(1);}
			} catch (SQLException e) {System.err.println(e);}
		}
		return 0;
	}
	
	
	//2. 모든 글 출력
	public ArrayList<BoardDto> getBoardList(int startrow, int listsize, String key , String keyword, int cno){
		
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql ="";
		
		if(key.equals("") && keyword.equals("")) { // 검색이 있다.
			sql = "select b.* , m.mid from member m natural join board b where b.cno = "+cno
					+ " order by b.bdate desc limit ?,?;";
			
		}else {//검색이 있다
			 sql = "select b.* , m.mid from member m natural join board b "
						+ " where "+key+" like '%"+keyword+"%' and b.cno = "+cno
						+ " order by b.bdate desc limit ? , ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			System.out.println(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto(
				rs.getInt(1) , rs.getString(2) , rs.getString(3), 
				rs.getString(4), rs.getString(5), rs.getInt(6),
				rs.getInt(7), rs.getInt(8), rs.getString(9), 
				rs.getInt(10), rs.getInt(11),rs.getString(12));
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {System.err.println(e);} 
		return null;
		
	}
	
	//3. 개별 게시물
	public BoardDto getBoard(int bno) {
		String sql ="select board.* , member.mid, member.mimg "
				+ " from board natural join member "
				+ "where board.bno = ?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto(
				rs.getInt(1) , rs.getString(2) , rs.getString(3), 
				rs.getString(4), rs.getString(5), rs.getInt(6),
				rs.getInt(7), rs.getInt(8), rs.getString(9), 
				rs.getInt(10), rs.getInt(11) , rs.getString(12));
				return dto;
			}
		} catch (SQLException e) {System.out.println(e);}
		return null;
	}
}
