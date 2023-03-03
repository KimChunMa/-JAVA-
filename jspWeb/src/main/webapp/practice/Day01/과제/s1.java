package Day01.과제;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Ex1
 */
@WebServlet("/s1")
public class s1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8"); //응답
	
		ArrayList<String> result = Dao.getInstance().getData();
	
		System.out.println("확인 : "+result);
	
		response.getWriter().print( result );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //요청
		response.setCharacterEncoding("UTF-8"); //응답
		
		String data = request.getParameter("data"); //요청
		
		boolean result = Dao.getInstance().setData(data);
		
		response.getWriter().print(" POST 메소드 방식으로 잘받았습니다." + result );
		
	}

}
