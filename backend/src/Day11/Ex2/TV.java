package Day11.Ex2;

public class TV implements RemoteControl{

	//필드
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("티비를 키다");
	}

	@Override
	public void turnOff() {
		System.out.println("티비를 끄다");
	}

	@Override
	public void setVolume(int volume) {
		 if(volume > RemoteControl.MAX_VOLUME) {
			 this.volume = RemoteControl.MAX_VOLUME;
			 System.out.println("최대볼륨보다 클 수 없습니다.");
		 }else if(volume < RemoteControl.Min_volume) {
			 this.volume = RemoteControl.Min_volume;
			 System.out.println("최소볼륨보다 작을 수 없습니다.");
		 }else {
			 System.out.println("TV 볼륨을 "+volume +" 만큼 킵니다.");
		 }
	}
	
}
