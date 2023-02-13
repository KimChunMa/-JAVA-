package Day09.EX03;
/*
	return 메소드의 실행을 강제 종료하고 호출한 곳으로 돌아감

*/
public class Car {
	int gas;
	
	Car() {};
	Car(int gas){this.gas = gas;}
	
	
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean isLetGas() {
		if(gas==0) {
			System.out.println("가스가 없습니다.");
			return false;
		}
		System.out.println("가스가 있습니다.");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas > 0 ) {
				System.out.println("달립니다. (남은 gas잔량 : " + gas+")");
				gas--;
			}else {
				System.out.println("멈춥니다. (남은 gas잔량 : "+ gas+")");
				return;
			}
		}
	}
	
	
	
}
