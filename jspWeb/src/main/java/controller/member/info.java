package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/member")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public info() {super();}

    //로그인
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
