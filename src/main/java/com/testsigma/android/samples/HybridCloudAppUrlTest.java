package com.testsigma.android.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HybridCloudAppUrlTest {
	public static void main(String args[]) throws Exception{
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "6cebaa96");
		cap.setCapability("app", "https://s3-us-west-2.amazonaws.com/fakepath/WikipediaSample.apk");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.launchApp();

		System.out.println("working fine");
		driver.quit();
	}
}
