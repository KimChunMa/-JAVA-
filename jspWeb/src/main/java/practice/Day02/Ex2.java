package practice.Day02;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		ArrayList<Object> list = Dao.getinstance().getData();
		
		//응답시 변환
		response.setCharacterEncoding("UTF-8");
		
		//js로 이동
		response.getWriter().print(list);
		*/
		
		ArrayList<Dto> list = Dao.getinstance().getData2();
		
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsonArray = objMapper.writeValueAsString(list);

		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); // 전달[전송]타입을 json 명시 
		response.getWriter().print(jsonArray ); // 변환된 json형식의 문자열 전달
		
		
		/*
		 * response.setCharacterEncoding("UTF-8"); response.getWriter().print(list);
		 */
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String data1 =  request.getParameter("data1");
		String data2 = request.getParameter("data2");
		double data3 = Double.parseDouble( request.getParameter("data3") );
		int data4 = Integer.parseInt(request.getParameter("data4"));
		String data5 = request.getParameter("data5");
		String data6 = request.getParameter("data6");
		String data7 = request.getParameter("data7");
		boolean data8 = Boolean.parseBoolean("data8");
		String data9 = request.getParameter("data9");
		String data10 = request.getParameter("data10");
		
		Dto result = new Dto(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		
		//dao
		 /* boolean result = 
		Dao.getinstance().setData(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		*/
		
		//응답시 인코딩
		response.setCharacterEncoding("UTF-8");
		
		//DAO에게 전달받은 result 를 js에게
		response.getWriter().print(result);
	}

}