package 과제.과제9.개발툴;

import java.util.Scanner;

import 과제.과제9.개발툴.implement1.비쥬얼스튜디오;
import 과제.과제9.개발툴.implement1.이클립스;
import 과제.과제9.개발툴.implement1.인텔리제이;
import 과제.과제9.개발툴.interface0.소프트웨어;

public class 실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("어떤 개발툴을 사용하시겠습니까?");
		System.out.println("1.이클립스 2.인텔리제이 3. 비쥬얼스튜디오");
		int ch = sc.nextInt();
		
		if(ch==1) {소프트웨어 sw = new 이클립스("이클립스","E","Jvm");
		System.out.println("시뮬레이션 1.콘솔 2.숏컷 3.에러 4.다른 프로그램 설치"); int ch2 = sc.nextInt();
		
			if(ch2==1) {sw.consol();}
			else if(ch2==2) {sw.shortcut();}
			else if(ch2==3) {sw.error();}
			else if(ch2==4) {System.out.println("어떤 프로그램을 설치하시겠습니까?");
							System.out.println("1.이클립스 2.인텔리제이 3. 비쥬얼스튜디오");
							 int ch3 = sc.nextInt();
							 
							 if(ch3==1) {sw= new 이클립스("이클립스","E","Jvm"); sw.consol();}
							 else if(ch3==2) {sw = new 인텔리제이("인텔리제이","In"); sw.consol();}
							 else if(ch3==3) {sw = new 비쥬얼스튜디오("비쥬얼 스튜디오","Vs","api"); sw.consol();}
							 }
		}
		
		else if(ch==2) {소프트웨어 sw = new 인텔리제이("인텔리제이","In");
		System.out.println("시뮬레이션 1.콘솔 2.숏컷 3.에러 4.다른 프로그램 설치"); int ch2 = sc.nextInt();
		
			if(ch2==1) {sw.consol();}
			else if(ch2==2) {sw.shortcut();}
			else if(ch2==3) {sw.error();}
			else if(ch2==4) {System.out.println("어떤 프로그램을 설치하시겠습니까?");
							System.out.println("1.이클립스 2.인텔리제이 3. 비쥬얼스튜디오");
							 int ch3 = sc.nextInt();
							 
							 if(ch3==1) {sw= new 이클립스("이클립스","E","Jvm"); sw.consol();}
							 else if(ch3==2) {sw = new 인텔리제이("인텔리제이","In"); sw.consol();}
							 else if(ch3==3) {sw = new 비쥬얼스튜디오("비쥬얼 스튜디오","Vs","api"); sw.consol();}
							 }
		}
		
		else if(ch==3) {소프트웨어 sw = new 비쥬얼스튜디오("비쥬얼 스튜디오","Vs","api");
		System.out.println("시뮬레이션 1.콘솔 2.숏컷 3.에러 4.다른 프로그램 설치\""); int ch2 = sc.nextInt();
		
			if(ch2==1) {sw.consol();}
			else if(ch2==2) {sw.shortcut();}
			else if(ch2==3) {sw.error();}
			
			else if(ch2==4) {System.out.println("어떤 프로그램을 설치하시겠습니까?");
							System.out.println("1.이클립스 2.인텔리제이 3. 비쥬얼스튜디오");
							 int ch3 = sc.nextInt();
							 
							 if(ch3==1) {sw= new 이클립스("이클립스","E","Jvm"); sw.consol();}
							 else if(ch3==2) {sw = new 인텔리제이("인텔리제이","In"); sw.consol();}
							 else if(ch3==3) {sw = new 비쥬얼스튜디오("비쥬얼 스튜디오","Vs","api"); sw.consol();}
							 }
		}
		
	
	}
}
