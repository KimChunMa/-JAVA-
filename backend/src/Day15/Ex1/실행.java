package Day15.Ex1;

import java.awt.Toolkit;

public class 실행 {
	
	//main 메소드() : 메인 thread 싱글스레드
	public static void main(String[] args) {
		
		//---------------------1.싱글 스레드-----------------------
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0 ; i< 5 ; i++) {
			toolkit.beep(); // 비프음 소리내기
			toolkit.beep();
			toolkit.beep();// 3번넣어도 1번만 소리나옴
			
			try { 
				Thread.sleep(500); // 스레드 0.5 대기상태 (3*5 = 15 번 울림)
			}catch(Exception e) {}
		}//for e
		
		//2. 출력코드 
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("띵"); // 15번 울린뒤 나옴 0.5초마다 "띵"
			
			try { 
				Thread.sleep(500); // 스레드 0.5 대기상태 (3*5 = 15 번 울림)
			}catch(Exception e) {}
			
		}
		
		//-------------------------- 2. 멀티스레드 ---------------------------------
		System.out.println("2.멀티스레드");
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0 ; i < 5 ; i++) {
					toolkit.beep(); //0.5초마다 울림
					try {Thread.sleep(500);} 
					catch(Exception e) {}
				}// for e
			}// run e
		});// 생성자 end
		
		thread.start();
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("띵"); //소리가 울리면서 실행
			try {Thread.sleep(500);}
			catch(Exception e) {}
		}// for e
		
		// ------------------------- 3. 멀티 스레드 구현 2 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		System.out.println("3.멀티스레드");
		Sound thread2 = new Sound();
		thread2.start();
		
		//  ------------------------- 4. 멀티 스레드 구현 3 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		System.out.println("4. 멀티스레드");
		Runnable runnable = new Sound2();
		Thread thread3 = new Thread(runnable);
		thread3.start();
		
		for(int i = 0 ; i<5 ; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch (Exception e) {}
			
		}
		
	}
}
