package Day15.Ex4;

public class 실행 {
	public static void main(String[] args) {
		WorkThread wtA = new WorkThread("workThreadA");
		WorkThread wtB = new WorkThread("workThreadB");
		wtA.start();
		wtB.start();
		
		try {Thread.sleep(2000);}
		catch(Exception e) {}
		wtA.work = false;
		
		try {Thread.sleep(2000);}
		catch(Exception e) {}
		wtA.work = true;
	}
}
