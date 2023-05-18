package com.yedam.homework0516;

public class PortableNotebook implements Notebook, Tablet{
	
	int mode;
	String docuApp;
	String browser;
	String video;
	String app;
	
	PortableNotebook(String docuApp, String browser, String video, String app) {
		this.docuApp = docuApp;
		this.browser = browser;
		this.video = video;
		this.app = app;
		System.out.println("NOTEBOOK_MODE");
	}
	@Override
	public void writeDocumentation() {
		System.out.println(docuApp + "을 통해 문서를 작성.");
		
	}
	
	@Override
	public void searchInternet() {
		System.out.println(browser + "을 통해 인터넷을 검색.");
		
	}
	
	@Override
	public void watchVideo() {
		System.out.println(video + "를 시청.");
		
	}

	@Override
	public void useApp() {
		if (mode == NOTEBOOK_MODE) {
			mode = TABLET_MODE;
			System.out.println(app + "을 실행.");
		} else {
			System.out.println(app + "을 실행.");
		}
		
	}
	
	public void changeMode() {
		String modename;
		if(mode == NOTEBOOK_MODE) {
			mode = TABLET_MODE;
			modename = "TABLET_MODE";
		} else {
			mode = NOTEBOOK_MODE;
			modename = "NOTEBOOK_MODE";
		}
		System.out.println(modename);
	}


}
