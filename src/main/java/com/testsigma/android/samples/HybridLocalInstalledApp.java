package com.testsigma.android.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HybridLocalInstalledApp {
	public static void main(String args[]) throws Exception{
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "6cebaa960104");
		cap.setCapability("appPackage", "org.wikipedia.alpha");
		cap.setCapability("appActivity", "org.wikipedia.main.MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.launchApp();

		System.out.println("working fine");
		driver.quit();
	}
}

/*How to find appPackage and appActivity
Connect device to your system
In command prompt type 
1.adb shell
2.dumpsys window windows | grep -E ‘mCurrentFocus|mFocusedApp’*/
//Example
//For WhatsApp aapPackage is com.whatsapp and the aapActivity is com.whatsapp.HomeActivity.




