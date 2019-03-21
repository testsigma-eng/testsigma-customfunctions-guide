package com.testsigma.android.samples;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HybridLocalInstalledAppBackup {
	public static void main(String args[]) throws Exception{
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("app", "/Users/krnaidu/Projects/SampleApps/APIDemosforAndroid_v1.9.0_apkpure.com.apk");
		//cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
		//cap.setCapability("appActivity", "com.touchboarder.android.api.demos.MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		Thread.sleep(3000);
				driver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//android.widget.TextView[@text='Alert Dialogs']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//android.widget.Button[@text='Repeat alarm']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//android.app.AlertDialog")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Every Monday']"));
		
		driver.launchApp();
	}

}

/*How to find appPackage and appActivity
Connect device to your system
In command prompt type 
1.adb shell
2.dumpsys window windows | grep -E ‘mCurrentFocus|mFocusedApp’*/
//Example
//For WhatsApp aapPackage is com.whatsapp and the aapActivity is com.whatsapp.HomeActivity.




