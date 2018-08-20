package com.testsigma.ios.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class HybridLocalAppTest 
{
	public static IOSDriver driver;

	public static void main(String[] args) throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", "iPhone X");    
		capabilities.setCapability("platformVersion", "11.2");
		capabilities.setCapability("udid", "e647c2802660d73c9340fb00411373e4b5068960");
		capabilities.setCapability("bundleId", "com.facebook.wda.integrationApp");
		
		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

		driver.launchApp();

		System.out.println("working fine");
		driver.quit();
	}

}
