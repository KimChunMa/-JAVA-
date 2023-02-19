package 과제.과제9.메일시스템.class_;

import 과제.과제9.메일시스템.interface_.메일보내기;
import 과제.과제9.메일시스템.interface_.메일삭제;
import 과제.과제9.메일시스템.interface_.알림;
import 과제.과제9.메일시스템.super_.메일;

public class 내게보내기 extends 메일 implements 메일보내기,알림,메일삭제{

	@Override
	public void sendMail() {
		System.out.println("내게메일을 보냅니다.");
	}

	@Override
	public void 메일삭제() {
		System.out.println("메일을 삭제합니다");
		
	}

	@Override
	public void 알림() {
		System.out.println("알림");
		
	}
	
	
	
	
	
}
