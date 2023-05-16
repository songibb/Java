package com.yedam.homework0516;

public class PortableNotebook implements Notebook, Tablet{
	//MODE, 문서 프로그램, 인터넷 브라우저, 영상종류, 앱종류를 필드
	int mode;
	String documtApp;
	String browser;
	String videoType;
	String appType;
	
	
	
	@Override
	public void writeDocumentation() {
		System.out.println("'문서 프로그램'을 통해 문서를 작성.");
		
	}
	
	@Override
	public void searchInternet() {
		System.out.println("'인터넷 브라우저'를 통해 인터넷을 검색.");
		
	}
	
	@Override
	public void watchVideo() {
		System.out.println("'영상종류'를 시청.");
		
	}

	@Override
	public void useApp() {
	
		
	}
	
	public void changeMode() {
		
	}


}
