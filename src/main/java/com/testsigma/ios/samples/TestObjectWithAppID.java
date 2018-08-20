package com.testsigma.ios.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class TestObjectWithAppID 
{
	public static IOSDriver driver;
	private static final String TESTOBJECT = "https://us1.appium.testobject.com/wd/hub";
	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("testobject_api_key","00AE6985C9C84134B1E96BDE5C6F240");
		caps.setCapability("testobject_app_id", "8");
		caps.setCapability("testobject_device", "iPhone_6_10_3_real");
		caps.setCapability("name", "My Test 1");

		driver = new IOSDriver(new URL(TESTOBJECT), caps);

		driver.launchApp();

		System.out.println("working fine");
		driver.quit();
	}

}
