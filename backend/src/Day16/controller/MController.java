package Day16.controller;


import Day16.model.Dao.MemberDao;
import Day16.model.Dto.MemberDto;

public class MController {
	private MController () {};
	private static MController Mcontroller = new MController();
	public static MController getInstance() {return Mcontroller;}
	
	private int loginSession = 0;
	public int getLoginSession() { return loginSession; }

	public void setLoginSession(int loginSession) {
		this.loginSession = loginSession;
	}



	//1.회원가입처리
	public int singup(String mid, String mpw , 
					   String mname, String mphone){
		//아이디 중복처리
		if(MemberDao.getInstance().idCheck(mid) ) {
			return 2; // 중복된 아이디
		}
		//객체화
		MemberDto mdto = new MemberDto(0,mid,mpw,mname,mphone);
		return MemberDao.getInstance().signup(mdto);
	}
	
	//2. 로그인 처리
	public boolean login(String mid, String  mpw) {
		// 1. 유효성검사 
				// 2. 
				int result = 
				MemberDao.getInstance().login(mid, mpw);
				
				// 3. 로그인 성공 증거 [ 로그인 정보 저장소 = 세션 ]
				if( result == 0 ) { return false; }
				else {
					loginSession = result; // * 반환된 회원번호를 세션에 저장 
					return true;
				}
	}
	
}
