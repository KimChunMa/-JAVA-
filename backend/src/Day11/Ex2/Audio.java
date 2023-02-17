package Day11.Ex2;

public class Audio implements RemoteControl{
	
	//필드
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("오디오를 키다");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오를 끄다");
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
			 this.volume = volume;
			 System.out.println("오디오 볼륨을 "+volume +" 만큼 킵니다.");
		 }
		 
	}
	
	//필드 추가
	private int memoryVolume; 
	
	//디폴트 메소드 재정의
	@Override
	public void setMute(boolean mute) {
		if(mute) {
			this.memoryVolume = this.volume;
			System.out.println("무음처리합니다.");
			setVolume(RemoteControl.Min_volume);
		}else {
			System.out.println("무음 해제");
			setVolume(memoryVolume);
		}
	}
	
	
}
