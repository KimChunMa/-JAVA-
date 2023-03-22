package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.Session;

import controller.admin.Chatting;
import model.dao.MemberDao;

public class MessageDto {
	//private Session session;		//메세지보낸 세션;
	private String frommid;		//메세지보낸 회원아이디;
	private String frommimg;	//메세지보낸 회원프로필 사진;
	private String msg;			//메세지 내용;
	private String time;		//메세지보낸시간;
	
	
	public MessageDto() {
		super();
	}
	
	//클라이언트에게 매세지 전송할때 사용하는 생성자
	public MessageDto(Session session,String msg) {
		super();
		//this.session = session;
		this.msg = msg;
		
		//메세지를 보낸 클라이언트세션을 통해 아이디 얻기
		for( ClientDto dto : Chatting.접속명단 ) {
			if(dto.getSession() == session ) {
				this.frommid = dto.getMid();
				this.frommimg = MemberDao.getInstance().getMember(this.frommid).getMimg();
				this.time = new SimpleDateFormat("hh:mm:ss").format(new Date());
			}
		}
	}
	
	
	
	/*
	 * @Override public String toString() { return "MessageDto [session=" + session
	 * + ", frommid=" + frommid + ", frommimg=" + frommimg + ", msg=" + msg +
	 * ", time=" + time + "]"; }
	 * 
	 * public Session getSession() { return session; }
	 * 
	 * public void setSession(Session session) { this.session = session; }
	 */

	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getFrommimg() {
		return frommimg;
	}

	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
}
