package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Join() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int custno = Integer.parseInt( request.getParameter("custno"));
		System.out.println(custno);
		
		String custname = request.getParameter("custname");
		System.out.println( custname );
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		int city = Integer.parseInt( request.getParameter("city"));
		
		MemberDto dto = new MemberDto(custno, custname, phone, address, joindate, grade, city);
		Dao dao = new Dao(); dao.update(dto);
		response.sendRedirect("/hrd_exam1/view.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		int city = Integer.parseInt( request.getParameter("city"));
		
		MemberDto dto = new MemberDto(0, custname, phone, address, joindate, grade, city);
		
		Dao dao = new Dao();
		boolean result = dao.join(dto);
		
		
		if(result) {
			response.sendRedirect("/hrd_exam1/join.jsp");
		}
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
