package practice.Day03.과제;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Ex3/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Product() {super();}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductDto> plist = ProductDao.getInstance().product_print();
		
    	//[json 객체] json 형식 변환(문자열로 변환)
    	// jackson 라이브러리에서 제공하는 클래스
    	ObjectMapper objMapper = new ObjectMapper(); 
    	
    	//DAO로 부터 받은 리스트를 json형식의 문자열로 변환 
		String jsonArray = objMapper.writeValueAsString(plist); 
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); // 전달[전송]타입을 json 명시 
		response.getWriter().print(jsonArray ); // 변환된 json형식의 문자열 전달
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pname = request.getParameter("pname");
		int pprice = Integer.parseInt( request.getParameter("pprice"));
		
		ProductDto PDto = new ProductDto(0,pname,pprice);
		
		boolean result = ProductDao.getInstance().register(PDto);
		
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	int pno = Integer.parseInt(request.getParameter("pno"));
	
	int newPrice = Integer.parseInt(request.getParameter("newPrice"));
	System.out.println(pno);
	System.out.println(newPrice);
	boolean result = ProductDao.getInstance().product_edit(pno, newPrice);
	response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	int pno = Integer.parseInt(request.getParameter("pno"));
	System.out.println(pno);
	boolean result = ProductDao.getInstance().product_delete(pno);
	
	response.getWriter().print(result);
	}

}
