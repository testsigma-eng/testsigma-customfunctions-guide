package com.testsigma.android.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HybridLocalAppTest {
	public static void main(String args[]) throws Exception{
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "6cebaa96");
		cap.setCapability("app", "");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.launchApp();
	}
}
