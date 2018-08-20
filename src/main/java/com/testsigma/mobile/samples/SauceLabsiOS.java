package com.testsigma.mobile.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class SauceLabsiOS 
{
	public static IOSDriver driver;
	private static final String TESTOBJECT = "https://us1.appium.testobject.com/wd/hub";
	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("testobject_api_key","00AE6985C9C84134B1E96BD5BC6F240");
		caps.setCapability("testobject_device", "iPhone_6_10_3_real");

		driver = new IOSDriver(new URL(TESTOBJECT), caps);

		driver.get("https://demoqa.com/registration/");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());

		System.out.println("working fine");
		driver.quit();
	}

}
