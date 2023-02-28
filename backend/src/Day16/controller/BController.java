package Day16.controller;

import java.util.ArrayList;

import Day16.model.Dao.BoardDao;
import Day16.model.Dto.BoardDto;
import Day16.model.Dto.CategoryDto;

public class BController {
	private static BController bController = new BController();
	private BController () {}
	public static BController getInstance() {return bController;}
	
	//카테고리 추가 처리
	public boolean categoryAdd (String cname) {
		
		return BoardDao.getInstance().categoryAdd(cname);
	}
	
	//카테고리 호출
		public ArrayList<CategoryDto> categoryPrint() {
			
			return BoardDao.getInstance().categoryPrint();
		}
		
		// 3. 
		public boolean boardAdd( String btitle , String bcontent , int cno ) {
			return BoardDao.getInstance().boardAdd(
					btitle, bcontent, 
					MController.getInstance().getLoginSession()
					, cno );
		}
		
		// 4. 
		public ArrayList<BoardDto> boardPrintRecent(){
			return BoardDao.getInstance().boardPrintRecent();
		}
		
		// 5. 
		public ArrayList<BoardDto> boardPrint( int cno ){ 
			return BoardDao.getInstance().boardPrint(cno);
		}
		
}
