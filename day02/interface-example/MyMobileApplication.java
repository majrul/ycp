package com.cdac.basics.interfaces;

public class MyMobileApplication implements MobileApplication {

	@Override
	public void start() {
		System.out.println("MyMobileApplication started..");
	}

	@Override
	public void pause() {
		System.out.println("MyMobileApplication paused..");
	}

	@Override
	public void stop() {
		System.out.println("MyMobileApplication stopped..");
	}

}
