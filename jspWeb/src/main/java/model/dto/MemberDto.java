package model.dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MemberDto {
	private int mno; //멤버 번호
	private String mid ; //멤버 아이디
	private String mpwd ; //멤버 비번
	private String memail ; //멤버 비번
	private String mimg  ; // 멤버 이미지
    private int mpoint; //멤버 포인트
    
    private int count;//총회원
    
 // 1. 이메일 전송 메소드 [ 받는사람이메일 , 받는내용 HTML ] 
	public boolean sendEmail( String toEmail , String contentHTML ) {
		// 1.보내는 사람의 정보 
		String fromEmail = "이메일@naver.com";
		String emailPwd	= "주소";
		// 2. 호스팅 설정 [ 네이버 기준 ]
		Properties properties = new Properties();
		properties.put( "mail.smtp.host", "smtp.naver.com");	// gmail일경우 : smtp.gmail.com	
		properties.put( "mail.smtp.port", 587 );				// 동일
		properties.put( "mail.smtp.auth", true);				// 동일 
		properties.put( "mail.smtp.ssl.protocols", "TLSv1.2");	// 동일 
		
		// 3. 인증처리 
			// [ Session : import javax.mail.Session; ]
			// Session.getDefaultInstance( '설정' , new Authenticator() {} );
			// [ Authenticator :  import javax.mail ]
			// [ PasswordAuthentication : import javax.mail ]
			//  new PasswordAuthentication( "인증할계정주소" , "비밀번호" );
		Session session = Session.getDefaultInstance( // 본인계정
				properties , new Authenticator() {
					// 패스워드인증 함수를 오버라이딩
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication( fromEmail, emailPwd);
					}
				});
		// 4. 메일 보내기 
		try {
			// Mime프로토콜 : smtp가 보낼수 있는 표준 형식[포멧]
			MimeMessage message = new MimeMessage( session );	// 인증된 세션 대입해서 포멧 객체 생성 
			message.setFrom( new InternetAddress( fromEmail ) );	// 보내는사람
			message.addRecipient( Message.RecipientType.TO , new InternetAddress( toEmail ) ); // 받는사람
			// 내용 구성 
			message.setSubject( "Ezen Community 회원가입 메일 인증코드 " );	// 메일 제목 
			message.setText( contentHTML );	// 메일 내용 
			// 전송 
			Transport.send(message);	// 표준형식[포멧]의 데이터를 SMTP 전송
			
			return true; // 메일 전송 성공
		}catch (Exception e) { System.out.println(e); }
		return false;	// 메일 전송 실패 
	}


	public MemberDto(int mno, String mid, String mpwd, String memail, String mimg, int mpoint) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
		this.mpoint = mpoint;
	}
	
	

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public MemberDto(int count) {
		super();
		this.count = count;
	}


	public MemberDto() {
		super();
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}


	public int getMpoint() {
		return mpoint;
	}


	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
    
	
	
    
}
