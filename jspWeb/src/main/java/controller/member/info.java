package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/member")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public info() {super();}

    //회원출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberDto> mlist = MemberDao.getInstance().memberPrint();
		ObjectMapper objMapper = new ObjectMapper(); 
	    	
	    //DAO로 부터 받은 리스트를 json형식의 문자열로 변환 
		String jsonArray = objMapper.writeValueAsString(mlist); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); // 전달[전송]타입을 json 명시 
		response.getWriter().print(jsonArray ); // 변환된 json형식의 문자열 전달
	}

	//회원가입 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		String memail = request.getParameter("memail");
		String mimg = request.getParameter("mimg");
		MemberDto dto = new MemberDto(0,mid,mpwd,mimg,memail);
		boolean result = MemberDao.getInstance().signup(dto);
		response.getWriter().print(result);
	}

	//회원 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	//회원 탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
