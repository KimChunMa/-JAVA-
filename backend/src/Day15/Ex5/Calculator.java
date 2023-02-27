package Day15.Ex5;

public class Calculator {
	private int memory;
	
	

	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		
		
		try {
			Thread.sleep(2000);
		}catch(Exception e) {}
		
		System.out.println(Thread.currentThread().getName()+":"+this.memory);
		
	}
	

	
}
