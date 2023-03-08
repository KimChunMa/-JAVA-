package practice.Day02.과제;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AEx
 */
@WebServlet("/AEx")
public class AEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AEx() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<aDto> list = aDao.getInstance().getData();
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsonArray = objMapper.writeValueAsString(list);
		System.out.println(list);
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); // 전달[전송]타입을 json 명시 
		response.getWriter().print(jsonArray ); // 변환된 json형식의 문자열 전달
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		float data3 =  Float.parseFloat(request.getParameter("data3"));
		int data4 = Integer.parseInt(request.getParameter("data4"));
		String data5 = request.getParameter("data5");
		String data7 = request.getParameter("data7");
		boolean data8 = Boolean.parseBoolean(request.getParameter("data8"));
		String data9 = request.getParameter("data9");
		String data10 = request.getParameter("data10");
		System.out.println(data10);
		aDto adto = new aDto(data1, data2, data3, data4, data5, data7, data8, data9, data10);
		
		boolean result =  aDao.getInstance().setData(adto);
		
		request.setCharacterEncoding("UTF-8");
		
		response.getWriter().print(result);
	}
	
	

}
