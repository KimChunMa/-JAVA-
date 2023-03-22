package controller.admin;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting")  //해당 클래스를 서버소켓[종착점]으로 만들기
public class Chatting {
	
	//클라이언트 소켓이 접속했을떄의 실행되는 메소드/함수
	@javax.websocket.OnOpen
	public void OnOpen(Session session) {
		System.out.println("소켓 : "+session);
	}
}
