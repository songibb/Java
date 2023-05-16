package com.yedam.inter;

public class Audio implements RemoteControl {
	
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		
		System.out.println("현재 Audio 볼륨: " + this.volume);
	}

	@Override
	public void search(String url) {
		//RemoteControl이 Searchable을 상속받으면서
		//Audio클래스도 search()메소드를 구현해야함
		
	}

}
