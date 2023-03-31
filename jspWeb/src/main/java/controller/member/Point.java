package controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.ProductDao;


@WebServlet("/point")
public class Point extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Point() { super(); }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Integer> result =  ProductDao.getInstance().getSum();
		System.out.println("map result : "+result.toString());
		
		ObjectMapper objMapper = new ObjectMapper(); 
	
		String jsonArray = objMapper.writeValueAsString(result); 
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); // 전달[전송]타입을 json 명시
		
		System.out.println("map result 후 : "+jsonArray.toString());
		
		response.getWriter().print(jsonArray ); // 변환된 json형식의 문자열 전달
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mpcomment = request.getParameter("mpcomment"); System.out.println(mpcomment);
		
		int mpamount  = Integer.parseInt( request.getParameter("mpamount"));
		
		int mno  = Integer.parseInt( request.getParameter("mno"));
		
		boolean result = MemberDao.getInstance().setPoint(mpcomment, mpamount, mno);
		
		response.getWriter().print(result);
	}
}
