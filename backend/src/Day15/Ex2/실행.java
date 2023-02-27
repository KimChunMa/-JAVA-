package Day15.Ex2;

public class 실행 {
	public static void main(String[] args) {
		
		//1. Thread 자식 클래스로 멀티 스레드 구현
		A a = new A();
		a.start();
		
		//2. Thread 자식 클래스의 익명 객체로 구현
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(true) {
					System.out.println("2. 익명객체 main스레드 : "+Thread.currentThread());
					try{Thread.sleep(1000);} // 1초간 일시정지
					catch (Exception e ) {}
				}
			
			}
		};
		thread.start();
		
		//3. Runnable 인터페이스 구현 객체 구현
		Runnable runnable = new B(); 
		Thread thread2 = new Thread(runnable);
		thread2.start();
		
		
		//4. Runnable 인터페이스의 익명 객체로 구현
		
		Thread thread3 = new Thread( new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println("4. 익명 인터페이스 : "+Thread.currentThread());
					try{Thread.sleep(1000);} // 1초간 일시정지
					catch (Exception e ) {}
				}
			
			}
		}
		);
		thread3.start();
		
		
		//5 . main 스레드
		while(true) {
			System.out.println("5. while main스레드 : "+Thread.currentThread());
			try{Thread.sleep(1000);} // 1초간 일시정지
			catch (Exception e ) {}
		}
	}
}
