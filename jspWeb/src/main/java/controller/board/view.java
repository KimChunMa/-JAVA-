package controller.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;


@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public view() {super(); }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type")); System.out.println("type : " + type);
		int bno = Integer.parseInt(request.getParameter("bno"));	System.out.println(" controller bno : " + bno);
		
		/*
			-하루에 한번씩 조회수 또는 좋아요수 또는 싫어요수 증가 가능
			-세션
			-회원별 or pc마다
			
		*/
		//1. pc 네트워크 식별자 [ ip ]
			// 1. java에서 현재 요청한 클라이언트의 ip 확인
		String ip =  request.getRemoteAddr();
			System.out.println("ip "+ip);
			
			// 4. 기존세션없으면 증가가능, 있으면 불가능
			Object o = request.getSession().getAttribute(type+ip+bno);
			if(o==null) {//세션[bno+type+ip]이 생성된 적 없다.
				
			// 2. 세션 생성 [bno+type+ip]
			request.getSession().setAttribute(type+ip+bno, 1);
			//3. 세션 생명주기 [생명주기가 지나면 자동으로 메모리 삭제/ 초단위]
				//세션 초기화 기준 1. 서버 끄면 2. 서버다시 킬떄 3. MaxinactiveInterval 설정시간
			
			request.getSession().setMaxInactiveInterval(60*60*24);//하루
			
			//Dao처리
			BoardDao.getInstance().bIncrease(type,bno);
			}
			
			
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	//삭제하기
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터베이스 삭제
		int bno = Integer.parseInt(request.getParameter("bno"));	System.out.println("bno : " + bno);
		
		//삭제전 첨부파일명 구하기
		String bfile = BoardDao.getInstance().getBoard(bno).getBfile();
		
		
		boolean result= BoardDao.getInstance().bdelete(bno);
		
		
		//첨부파일 있을경우 같이 삭제
		if(result) { // db에서 삭제시 
			String path = request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
			File file = new File(path); // 객체화
			if(file.exists()){//만약 파일이 존재하면
				file.delete();//파일삭제
			}
		}
		
		response.getWriter().print(result);
		
	}
	
	

}
