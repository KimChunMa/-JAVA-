package Day15.Ex4;
//yield
public class WorkThread extends Thread{
	public boolean work = true; //  필드

	public WorkThread(String name) { // 생성자
		setName(name); // 스레드 이름 변경
	}

	@Override
	public void run() { 
		while(true) {
			if(work) {
				System.out.println(getName() + " : 작업처리 ");
			}else{
				Thread.yield(); // 양보
				}
		}
	}
	
	
	
}
