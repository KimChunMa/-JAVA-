package 과제.과제9.메일시스템;

import java.util.Scanner;

import 과제.과제9.메일시스템.super_.메일;

public class 실행 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		메일 DB = new 메일();
		
		
		while(true) {
			System.out.println("1.회원가입 2.로그인");  int ch01 = sc.nextInt();
			
			//1.회원가입
			if(ch01==1) {
				System.out.println("이름을 입력해주세요"); String name = sc.next();
				메일 myMail = new 메일(name); 
				DB.pushMember( myMail );
			}
			
			//2. 로그인
			else if(ch01==2){
				System.out.println("로그인 할 이름을 입력해주세요");String name = sc.next();
				
				boolean result=false;
				int i = 0;
				for(메일 멤버: DB.getMember()) {
					if(멤버.get발신지().equals(name)) {
						System.out.println("로그인 성공!");
						result=true;
						break;
					}
					i++;
				}//for e
				
				
				if(result) {
					while(true) {
						System.out.println("------메일함------");
						System.out.println("이름: "+DB.getMember().get(i).get발신지() +" 알림 :"+DB.getMail().size());
				
						System.out.println("1.메일 보내기 2.메일 보기 3.뒤로가기"); int ch02 = sc.nextInt();
					
						//메일 보내기
						if(ch02==1) {
							System.out.println("수신지를 입력해주세요"); String 수신지 = sc.next();
							System.out.println("제목를 입력해주세요"); String 제목 = sc.next();
							System.out.println("내용를 입력해주세요"); String 내용 = sc.next();
							
							
							메일 sendMail = new 메일(DB.getMember().get(i).get발신지(),수신지,제목,내용);
							
							for(메일 멤버: DB.getMember()) {
								if(수신지 == 멤버.get발신지()) {
									DB.pushMail(sendMail);
									System.out.println("메일보내기 성공");
									
								}
							}//for e
							
						}//ch02 1 e
						
						//메일 보기
						else if(ch02==2) {
								
							int j = 0;
							for(메일 mail: DB.getMail()) {
							System.out.printf("번호:%d\t제목%s\t수신자%s\n",j,mail.title , mail.수신지);
							j++;
							}
							
							System.out.println("몇번째 메일을 보시겠습니까?"); int ch03 = sc.nextInt();
							
							System.out.printf("번호:%d\n제목%s\t수신자%s\n내용:\n%s", ch03 ,DB.getMail().get(ch03).title,DB.getMail().get(ch03).수신지 
											  ,DB.getMail().get(ch03).content);
								
								
						}//ch02 2e
						
						
						else if(ch02==3) {break;}
						
						}//while e
				}//if e
				
				
				
				
			}//ch01 2 e
			
			
		}//while e
	}//main e
}//class e
