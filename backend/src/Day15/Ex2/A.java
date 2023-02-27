package Day15.Ex2;

public class A extends Thread{

	@Override
	public void run() {
		while( true ) {
			System.out.println("1. A main스레드 : "+Thread.currentThread());
			try{Thread.sleep(1000);} // 1초간 일시정지
			catch (Exception e ) {}
		}
	}
	
}
