package controller.board;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/filedownLoad")
public class filedownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public filedownLoad() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//다운로드할 파일
		request.setCharacterEncoding("UTF-8");
		String bfile = request.getParameter("bfile");
		System.out.println("bfile : "+ bfile);
		
		//다운로드할 파일경로
		/*String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		System.out.println("path: " + path);*/
		
		//다운로드할 폴더의 파일 경로 찾기
		String path = request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);

		System.out.println("path: " + path);
		
		//파일클래스
		File file = new File(path); // 해당경로의 파일을 객체화
		
		//HTTP 다운로드 형식 [프론트엔드] = 각브라우저 제공
		response.setHeader( // HTTP Header메소드[ HTTP 옵션정보 설정 ]
				"Content-Disposition" , // 각 브라우저마다 다운로드형식 HTTP 옵션에 포함해서 보내기
				"attachment;filename="+URLEncoder.encode( bfile , "UTF-8" )
				// 다운로드시 파일명이 표시되는 옵션 [ 한글파일 인코딩 ]
				// URLEncoder.encode( 파일명 , "UTF-8" ) : URL(통신주소) 의 한글인코딩
			);
				
		
		//파일 스트림 [바이트단위] * 예외발생
			// 1. 파일 객체의 바이트를 모두 읽어온다.
		
		// 1. 해당 경로 스트림 객체 만들기
		BufferedInputStream fin = new BufferedInputStream( new FileInputStream(file) );
		// 2. 파일 입력 스트림객체에서 꺼내올 바이트들을 저장할 바이트 배열 준비
			//바이트배열 길이 = 파일 길이 = 바이트 개수
		byte[] bytes = new byte[ (int)file.length()];
		// 3. 바이트를 읽어오는 함수
		fin.read(bytes);
		// 4. 출력
			// 1. response.getOutputStream() : HTTP 스트림 단위 [바이트]전송
		
		BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
		//FileOutputStream fout = new FileOutputStream(response.getOutputStream());
			// 2. 파일입력스트림객체에서 읽어온 바이트들 [바이트배열]
			// 파일출력스트림객체 write() : 해당 배열내 바이트를 출력하는 함수
		fout.write(bytes);
			//3. 스트림 닫기 [ CG 대신 직접 스트림 닫기]
		
		fin.close(); // 파일 입력 스트림 객체 닫기  
		fout.flush(); // 파일 출력 스트림 메모리 초기화 
		fout.close(); // 파일 출력 스트림 객체 닫기 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
