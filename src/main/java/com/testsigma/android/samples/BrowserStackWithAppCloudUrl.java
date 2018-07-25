package com.testsigma.android.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BrowserStackWithAppCloudUrl {

	public static String userName = "mythri7";
	public static String accessKey = "b2Msz9uSQyDnUfHVDcxV";
	
	public static void main(String args[]) throws Exception {
		
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("device", "Google Nexus 6");
    caps.setCapability("app", "bs://e139ff6b5d13d43ed22f0a661c670e5ff718249e");
	
	AndroidDriver driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"),caps);
    driver.launchApp();
	System.out.println("working");
	}

}
