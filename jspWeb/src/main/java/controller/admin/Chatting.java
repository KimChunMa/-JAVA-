package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import javax.websocket.OnClose;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MessageDto;

@ServerEndpoint("/chatting/{mid}")  //해당 클래스를 서버소켓[종착점]으로 만들기
				//URL : /경로/{매개변수1}/{매개변수2} --> @PathParam("경로상의 매개변수명") 타입 변수명
					/*		
					 		회원아이디 qweqwe일때 
					 		/jspWeb/chatting/qweqwe
					 		/jspWeb/chatting/{mid}
					 		@PathParam("mid") String 매개변수;
					 		매개변수 = qweqwe 
					 */
				//URL : /경로?매개변수명 = 데이터 --> request.getParameter("매개변수명")
public class Chatting {
	
	// *-* 접속한 클라이언트명단[목록], (클라이언트소켓 여러개 저장)
	public static ArrayList<ClientDto> 접속명단 = new ArrayList<>();
	
	//클라이언트 소켓이 접속했을떄의 실행되는 메소드/함수
	@javax.websocket.OnOpen //session[접속한 클라이언소켓 객체] 
	public void OnOpen(Session session, @PathParam("mid") String mid) {// 서버엔드포인트의 URL 매개변수 가져오기
		System.out.println("소켓 : "+session);
		접속명단.add(new ClientDto(session,mid));
		System.out.println(접속명단);
	}
	
	
	@OnClose //클라이언트소켓이 나갔을때
	public void onClose(Session session) {
		System.out.println("나감");
		//접속이 끊긴 세션의 Dto를 찾아서 제외
		for(ClientDto dto : 접속명단) {
			if(dto.getSession() == session) {
				System.out.println("삭제");
				접속명단.remove(dto); // 명단제외
			}//if e
		}//for e
	}// onClost e
	
	
	@javax.websocket.OnMessage
	public void OnMessage(Session session, String msg) throws IOException {
		
		//메세지 형식 구성
		MessageDto messageDto = new MessageDto(session, msg);
			System.out.println(messageDto.toString());
		
			//메세지 받는 프로그램[JS] : JSON 형변환 // Session은 형변환안됨
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(messageDto);
		System.out.println(json);
		
		//서버가 클라이언트 소켓에게 메세지 보내기
		//현재 서버소켓과 연결된 클라이언트소켓 모두에게 서버가 받은 내용물 전달
		for(ClientDto dto : 접속명단) {
								//json형식 타입은 문자	
									// String a = "10"; 숫자형식[모양]의 타입은 문자열
									
			dto.getSession().getBasicRemote().sendText(json);
		}//for e	
	}//onMessage e	
	
	
}
