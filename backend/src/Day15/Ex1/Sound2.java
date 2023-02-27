package Day15.Ex1;

import java.awt.Toolkit;

public class Sound2 implements Runnable {

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0 ; i < 5 ; i++) {
			toolkit.beep(); //0.5초마다 울림
			try {Thread.sleep(500);} 
			catch(Exception e) {}
		}// for e
	}
	
}
