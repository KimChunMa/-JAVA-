package model.dto;

import javax.websocket.Session;

public class ClientDto {
	private Session session;
	private String mid;
	private int 채팅방번호pk;
	
	public ClientDto(Session session, String mid) {
		super();
		this.session = session;
		this.mid = mid;
	}

	public ClientDto() {
		super();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int get채팅방번호pk() {
		return 채팅방번호pk;
	}

	public void set채팅방번호pk(int 채팅방번호pk) {
		this.채팅방번호pk = 채팅방번호pk;
	}
	
	
	
}
