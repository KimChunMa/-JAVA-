package Day13.Ex4;

import java.io.IOException;

public class 실행 {
	public static void main(String[] args) throws IOException {
		System.out.println("출력"); // 출력
		System.err.println("에러"); // 에러
		
		try {
		int value = Integer.parseInt("1oo");
		} catch(Exception e) {
			System.err.println("에러");
			System.err.println(e.getMessage());
		}
		
		
		//2.
		
		int speed = 0;
		int keyCode = 0;
		
		while(true) {
			
			if( keyCode != 13 && keyCode != 10) {
				if(keyCode == 49) { // 1번
					speed++;
				}else if(keyCode ==50) { //2번
					speed--;
				}else if (keyCode == 51) { // 3번
//					/break;
					System.exit(0); // 0 정상종료, 1 or -1 비정상
				}
				System.out.println("현재 속도 : "+ speed);
				System.out.print("1. 증속 2. 감속 3. 중지 : ");
			}
			
			
			
			try {
			keyCode =  System.in.read(); //예외처리
			} catch (Exception e) {
			}
			
			
		}
		
	}
}
