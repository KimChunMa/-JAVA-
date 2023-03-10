package controller.admin;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.MemberDto;

/**
 * Servlet implementation class Email
 */
@WebServlet("/email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Email() { super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memail = request.getParameter("memail"); 
		
	String auth = ""; // 인증코드
	
	for(int i = 0 ; i < 6 ; i++) {
		Random random = new Random();
		auth += random.nextInt(10); // 0~9 사이의 정수 생성
	}
	System.out.println(auth);
	
	//인증코드와 받는사람의 이메일
	boolean result =  new MemberDto().sendEmail(memail, auth);
	
	if(result) {
		response.getWriter().print(auth); // 인증번호
	}else {
		response.getWriter().print(result); //메일 전송 실패여부
	}
	
	
		
		/*
		 	smtp(간이 메일 전송 프로토콜 ) : Simple mail Transfer protocol
		 	메일서버(네이버,구글,다음
		 	qwe@naver.com
		 	java-mail + java- activation 다운
		 */
		
	}

}
