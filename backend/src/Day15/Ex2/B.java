package Day15.Ex2;

public class B implements Runnable{
	@Override
	public void run() {
		while( true ) {
			System.out.println("3. B main스레드 : "+Thread.currentThread());
			try{Thread.sleep(1000);} // 1초간 일시정지
			catch (Exception e ) {}
		}
	}
}
