package controller.board;

import java.io.File;
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
import model.dto.PageDto;


@WebServlet("/board/info")
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Boardinfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt( request.getParameter("type") );
		
		if(type==1) { //전체 출력
			// 카테고리 별 출력
			int cno = Integer.parseInt( request.getParameter("cno"));
			
			// --------------- 검색 처리 --------------
			//1. 검색에 필요한 매개변수 요청 [key, keyword] 2.
			String key = request.getParameter("key");			System.out.println(key);
			String keyword = request.getParameter("keyword");	System.out.println(keyword);
			
			// ------------- page 처리 ----------------
			// 1. 현재페이지 [요청] , 2.페이지당 표시할 게시물 수 ,2. 현재페이지 [게시물시작, 끝번호 ]
			int page = Integer.parseInt(request.getParameter("page")); 
			int listsize = Integer.parseInt(request.getParameter("listsize"));  //화면에 표시할 게시물 수
			int startrow = (page-1)*listsize;//해당 페이지에서의 게시물의 시작번호 
							//1-1 * 3 = 0 부터 게시물 시작
			
			// -------------------- page 버튼 ----------------------------
			//1. 전체 게시물개수 검색없을 떄
			//int totalsize = BoardDao.getInstance().gettotalsize();
			//
			int totalsize = BoardDao.getInstance().gettotalsize(key,keyword,cno);
			//페이징 버튼 개수
			int totalpage = totalsize % listsize == 0 ? // 전체 게시판 % 페이지 글 제한 == 0 이면 
							totalsize/listsize :  totalsize/listsize+1; // 몫이있으면 게시판 +1
			
			
			int btnsize = 5;// 최대 페이징 출력수
			int startbtn = ( (page-1)/btnsize) * btnsize +1;//시작 버튼
			/*
			1페이지 	: 1-1 / 5 	*5 +1			-> 	0*5+1	 	1 
  			2페이지	: 2-1 / 5	*5 +1			->	0*5+1		1
  			3페이지 	: 3-1 / 5	*5 +1			->  0*5+1		1
  			4페이지	: 4-1 / 5	*5 +1			->	0*5+1		1
  			5페이지	: 5-1 / 5	*5 +1			->  0*5+1		1
  			6페이지	: 6-1 / 5 	*5 +1			->  1*5+1 		6
  			7페이지	: 7-1 / 5	*5 +1			->	1*5+1		6
			 */			
			
			int endbtn = startbtn + (btnsize-1);  // 끝버튼
			if(endbtn > totalpage) {endbtn = totalpage;}
			
			//ArrayList<BoardDto> result =  BoardDao.getInstance().getBoardList(startrow,listsize );
			ArrayList<BoardDto> result =  BoardDao.getInstance().getBoardList(startrow,listsize,key,keyword, cno );
			
			PageDto pageDto = new PageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
			
			ObjectMapper objMapper = new ObjectMapper(); 
			//[json 객체] json 형식 변환(문자열로 변환)
			// jackson 라이브러리에서 제공하는 클래스
			//DAO로 부터 받은 리스트를 json형식의 문자열로 변환 
			String jsonArray = objMapper.writeValueAsString(pageDto); 
		
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json"); // 전달[전송]타입을 json 명시 
			response.getWriter().print(jsonArray ); // 변환된 json형식의 문자열 전달
		}	
		else if (type==2) { //개별 출력
			int bno = Integer.parseInt(request.getParameter("bno"));
			System.out.println("bno : "+bno);
			
			//Dao
			BoardDto bto = BoardDao.getInstance().getBoard(bno);
			//형변환
			ObjectMapper objMapper = new ObjectMapper(); 
			String jsonArray = objMapper.writeValueAsString(bto); 
			
			//응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json"); // 전달[전송]타입을 json 명시 
			response.getWriter().print(jsonArray ); // 변환된 json형식의 문자열 전달
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
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		
		//업로드
		MultipartRequest multi = new MultipartRequest(
				request ,  path ,  1024*1024*10 , "UTF-8" ,
				new DefaultFileRenamePolicy() );
			
		//정보
		int bno = Integer.parseInt( multi.getParameter("bno"));
		int cno = Integer.parseInt( multi.getParameter("cno") );
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		System.out.println("bfile : "+bfile);
		//수정후 파일 처리
		String oldfile = BoardDao.getInstance().getBoard(bno).getBfile();
		String filepath = request.getSession().getServletContext().getRealPath("/board/bfile/"+oldfile);
		
		System.out.println("filepath : "+filepath);
		
		if(bfile == null) {
		
		}else {//새로운 첨부파일이 있다면
			File file = new File(path); if(file.exists()) {file.delete();}
		}
		
		//dto
		BoardDto dto = new BoardDto(bno,btitle, bcontent, bfile,cno);
		boolean result = BoardDao.getInstance().bupdate(dto);
		response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int type = Integer.parseInt(request.getParameter("type"));
		
		//파일명
		String bfile = BoardDao.getInstance().getBoard(bno).getBfile();
		//삭제 결과값
		boolean result = true;
		
		if(type == 1) { // db삭제 + 파일 삭제
			//데이터베이스 삭제
			result= BoardDao.getInstance().bdelete(bno);
			//삭제전 첨부파일명 구하기
		}else if (type==2) { // 파일만 삭제
			result = BoardDao.getInstance().bfiledelete(bno);
		}
		
		
		
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
