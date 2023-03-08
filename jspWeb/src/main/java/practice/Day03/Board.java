package practice.Day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/Ex3/Board")	// 해당 클래스[자원] URL 정의
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Board() {super();}

    //post
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	// 1. 요청시 한글 인코딩 
  			request.setCharacterEncoding("UTF-8");
  			// 2. 매개변수 요청 [ AJAX data속성에서 보내준 매개변수 이름 
  			String content = request.getParameter("content");
  			String writer = request.getParameter("writer");
  			
  			BoardDto boardDto = new BoardDto(0,content,writer,null);
  			
  			boolean result = BoardDao.getInstance().onwriter(boardDto);
  			
  			//js에게 응답결과를 보내줌
  			response.getWriter().print(result);
  				
  	}
    
    //게시물 조회
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
    	
    	ArrayList<BoardDto> blist =  BoardDao.getInstance().onprint(); 
    	
    	
    	//[json 객체] json 형식 변환(문자열로 변환)
    	// jackson 라이브러리에서 제공하는 클래스
    	ObjectMapper objMapper = new ObjectMapper(); 
    	
    	//DAO로 부터 받은 리스트를 json형식의 문자열로 변환 
		String jsonArray = objMapper.writeValueAsString(blist); 
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); // 전달[전송]타입을 json 명시 
		response.getWriter().print(jsonArray ); // 변환된 json형식의 문자열 전달
		
    	
    }

	//put
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//js에서 받아올때
		request.setCharacterEncoding("UTF-8");
		
		String newContent =request.getParameter("newContent");
		System.out.println("수정"+newContent);
		
		int bno = Integer.parseInt(
				request.getParameter("bno")
				); 
		System.out.println("번호:"+bno);
		
		boolean result = BoardDao.getInstance().onEdit(newContent, bno);
		
		//js에게 줄때
		response.getWriter().print(result);
	}

	//delete
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(
				request.getParameter("bno")
				); 
		
		System.out.println("번호:"+bno);
		boolean result = BoardDao.getInstance().onDel(bno);
		
		response.getWriter().print(result);
	}

}

	/*
	   JSP 서블릿 에서 HTTP 메소드 put , delete 사용시 필수 설정
	  	* 기본값 : 매개변수 요청 차단
	  1. server 폴더 클릭후 server.xml -> source
	  2. 63째줄
	  	        <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE,GET" URIEncoding="URF-8"/>
	  	    
	  
	*/
