package com.cdac.basics.interfaces;

public class TestLauncher {

	public static void main(String[] args) {
		MyMobileApplication mobileApp = new MyMobileApplication();
		Launcher launcher = new Launcher();
		launcher.launch(mobileApp);
	}
}
