package controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api1")
public class Api1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Api1() {super();  }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공공데이터 가져오기
			//url 클래스 ("Request URL")
			//1. .openStream(): 해당 객체의 연결된 url 스트림 제공 함수 [반환 : InputStream]
		URL url = new URL("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=HqoBwy3a3VRhBsc0fT%2BkjaNrwQ9HPYpeU9wCigtIbh3OumQK7O0%2BXzFZPkEDrrBHJClqrCfv0x8oDUorou%2F9jg%3D%3D");
		
		//2. 해당 url의 데이터 [ 스트림(바이트)] 읽어오기 위한 스트림 객체 생성
		//InputStream inputStream = url.openStream();
		//InputStreamReader reader = new InputStreamReader(url.openStream(),"UTF-8");
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream() , "UTF-8")  );
		
		
		//char[] array =new char[100000];
		//byte[] array1 = new byte[100000];
		
		
		//3. 스트림으로 바이트 읽어오기
		//inputStream.read(array1); // 바이트배열로 읽어오기
		//reader.read(array); // 문자배열로 읽어오기
		String result = bf.readLine(); 		//모든 바이트를 읽은후 문자열로 변환
		
		System.out.println(  result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	

}
