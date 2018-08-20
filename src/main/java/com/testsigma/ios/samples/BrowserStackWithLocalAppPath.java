package com.testsigma.ios.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class BrowserStackWithLocalAppPath 
{
	public static IOSDriver driver;
	public static String userName = "Username";
	public static String accessKey = "Access_Key";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("realMobile", true);
		caps.setCapability("device", "iPhone 7 Plus");
		caps.setCapability("app", "bs://fca94897b0604b75ed9c7908dfda4e995dfa4546");

		driver = new IOSDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

		driver.launchApp();

		System.out.println("working fine");
		driver.quit();
	}

}
