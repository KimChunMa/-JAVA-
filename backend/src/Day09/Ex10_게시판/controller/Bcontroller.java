package Day09.Ex10_게시판.controller;
import java.util.ArrayList;
import java.util.Date;

import Day09.Ex10_게시판.model.Board;

public class Bcontroller {
	//싱글톤
	private static Bcontroller bc = new Bcontroller();
	
	private Bcontroller() {};
	
	public static Bcontroller getInstance() {
		return bc;
	}
	
	//필드
	private ArrayList<Board> boardDB = new ArrayList<>();

	
	//쓰기함수
	public boolean write(String title, String content,String writer,
			String pw, Date date, int view) {
			
		Board board = new Board(title, content, writer, pw, date, view);
		boardDB.add(board);
		return true;
	}
	
	//출력함수
	public ArrayList<Board> print() {
		// 유효성검사 [ 생략 ] 검색,페이징처리 
		return boardDB;
	}
	
	//조회수 늘리기
	public Board view(int bno) {
		boardDB.get(bno).setView( boardDB.get(bno).getView()+1   );
		return boardDB.get(bno);
	}//view e
	
	
	
}//class e
