package com.cdac.basics.interfaces;

public class Launcher {

	public void launch(MobileApplication mobileApp) {
		mobileApp.start();
		mobileApp.pause();
		mobileApp.stop();
	}
}
