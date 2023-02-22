package Day13.Ex10_MVC;

import java.util.ArrayList;

public class Controller {
	//싱글톤
	private Controller() {};
	private static Controller ctr = new Controller();
	public static Controller getInstance () {return ctr;}
	
	//등록
	public boolean  signup(String mid , String mpw) {
		//객체생성 (여러변수가 이동시 로직이 길어짐)
		MemberDto dto = new MemberDto(0,mid,mpw);
		//해당 객체를 db저장
		boolean result = 
		MemberDao.getInstance().signup(dto);
		return result;}
	
	//출력
	public ArrayList<MemberDto> list() {
		ArrayList<MemberDto> result =  MemberDao.getInstance().list();
		return result;
	}//list e
	
	//수정
	public boolean update(int mno, String mpw) {
		return MemberDao.getInstance().update(mno, mpw);}
	
	//삭제
	public boolean delete(int mno) {
		return MemberDao.getInstance().delete(mno);
	}
}
