package com.testsigma.mobile.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SauceLabsAndroid 
{
	public static AndroidDriver driver;
	private static final String TESTOBJECT = "https://us1.appium.testobject.com/wd/hub";
	
	public static void main(String[] args) throws Exception {
	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("testobject_api_key","D2471E5C1B9C4BADBFF0D42797E8E37");
		caps.setCapability("testobject_device", "LG_Nexus_5X_real2");

		driver = new AndroidDriver(new URL(TESTOBJECT), caps);

		driver.get("https://demoqa.com/registration/");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		System.out.println("working fine");
		driver.quit();
	}

}
