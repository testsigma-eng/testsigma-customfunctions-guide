package com.testsigma.android.samples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class TestObjectWithAppCloudUrl {
	public static void main(String args[]) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("testobjectApiKey", "28BECA78C20949129B4FDC1187D334D3");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "LG_Nexus_5X_real");
		capabilities.setCapability("testobject_app_id", "43");
        capabilities.setCapability("name", "My Test 3!");
        AppiumDriver driver = new AppiumDriver(new URL("https://us1.appium.testobject.com/wd/hub"), capabilities);
        driver.launchApp();
	}

}
