package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4_싱글톤.model.Board;

public class Bcontroller {
	//싱글톤
	private static Bcontroller bc = new Bcontroller();
	private Bcontroller() {};
	public static Bcontroller getInstance() {
		return bc;
	}
	
	private ArrayList<Board> boardDB = new ArrayList<>();
	
	//글쓰기
	public boolean write(String title, String content) {
		//로그인 실패시
		if(Mcontroller.getInstance().getLogSession() == null) {
			return false;
		}
		//로그인 성공시			제목 , 내용,  조회수, 로그인한 member 객체
		Board board = new Board(title,content,0,Mcontroller.getInstance().getLogSession());
		
		boardDB.add(board);
		// mc객체의 로그인된 member객체의 boardDB 추가 
		//Mcontroller.getInstance().getLogSession().getBoardlist().add(board);
		
		return true;
	}
	
	//글 출력
	public ArrayList<Board> getList(){
		return boardDB;
	}
	
	//글 상세
	public Board getBoard(int bno) {
		boardDB.get(bno).setView( 
				boardDB.get(bno).getView()+1 );
		return boardDB.get(bno);
	}
	
	//글 삭제
	public boolean delete(int bno) {
		 boardDB.remove(bno);
		 return true;
	}
	
	//글 수정
	public boolean update(int bno, String title, String content) {
		boardDB.get(bno).setTitle(title);
		boardDB.get(bno).setTitle(content);
		
		return true;
	}
	
	
}
