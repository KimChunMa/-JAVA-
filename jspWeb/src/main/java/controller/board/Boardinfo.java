package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;


@WebServlet("/board/info")
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Boardinfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt( request.getParameter("type") );
		
		if(type==1) { //전체 출력
			ArrayList<BoardDto> result =  BoardDao.getInstance().getBoardList();
			
			System.out.println("게시물 : "+result);
			
			ObjectMapper objMapper = new ObjectMapper(); 
			//[json 객체] json 형식 변환(문자열로 변환)
			// jackson 라이브러리에서 제공하는 클래스
			//DAO로 부터 받은 리스트를 json형식의 문자열로 변환 
			String jsonArray = objMapper.writeValueAsString(result); 
		
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json"); // 전달[전송]타입을 json 명시 
			response.getWriter().print(jsonArray ); // 변환된 json형식의 문자열 전달
		}	
		else if (type==2) { //개별 출력
			int bno = Integer.parseInt(request.getParameter("bno"));
			System.out.println("bno"+bno);
			
			//Dao
			
			//형변환
			
			//응답
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// * 현재 서버의 배포된 프로젝트내 폴더 경로 찾기 
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/bfile");
		System.out.println( "path : "+uploadpath );
		
		// * 업로드 [ 유저파일 --> 서버폴더내 이동 ]
		MultipartRequest multi = new MultipartRequest(
				request,  						// 1. 요청방식 
				uploadpath , 					// 2. 첨부파일 가져와서 저장할 서버내 폴더 
				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
				"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
				);
		System.out.println("multi : "+multi);
		
	
		int cno =  Integer.parseInt( multi.getParameter("cno") ); System.out.println(cno);
		String btilte = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");	// 첨부파일된 파일명 호출[  .getFilesystemName ]
		System.out.println("bfile: "+bfile);
		
		//서버세션값 가져오기
		String mid = (String)request.getSession().getAttribute("login");
		
		//회원번호가 존재하지않으면 글쓰기 불가능
		int mno = MemberDao.getInstance().getMno(mid);
		
		if(mno==0) {response.getWriter().print("false");}
		
		//Dto
		BoardDto dto = new BoardDto(btilte, bcontent,bfile,cno,mno);
			System.out.println("dto : "+dto);
		
		//Dao
		boolean result = BoardDao.getInstance().bwrite(dto);
		
		//응답
		response.getWriter().print(result);
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
