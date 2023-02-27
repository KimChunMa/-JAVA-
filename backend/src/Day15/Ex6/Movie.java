package Day15.Ex6;

public class Movie extends Thread{
	
	public boolean stop = false;
	
	@Override
	public void run() {
		while(stop) {
			System.out.println(" --영화재생중-- ");
			try {Thread.sleep(1000);}
			catch(Exception e) {}
		}
	}
	
	
}
