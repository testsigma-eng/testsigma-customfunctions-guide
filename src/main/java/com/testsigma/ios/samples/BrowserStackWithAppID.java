package com.testsigma.ios.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class BrowserStackWithAppID 
{
	public static IOSDriver driver;
	public static String userName = "bharathiv1";
	public static String accessKey = "9gTT7adCeMrKs8Qx5kcj";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("realMobile", true);
		caps.setCapability("device", "iPhone 7 Plus");
		caps.setCapability("app", "bs://fca94897b0604b75ed9c7908dfda4e995dfa4546");

		driver = new IOSDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

		driver.launchApp();

		Thread.sleep(3000);

		System.out.println("working fine");
		driver.quit();
	}

}
