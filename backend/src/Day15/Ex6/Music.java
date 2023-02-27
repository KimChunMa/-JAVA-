package Day15.Ex6;

public class Music extends Thread{
	
	public boolean stop = false;
	
	@Override
	public void run() {
		while(stop) {
			System.out.println(" --음악재생중-- ");
			try {Thread.sleep(1000);}
			catch(Exception e) {}
		}
	}
	
}
