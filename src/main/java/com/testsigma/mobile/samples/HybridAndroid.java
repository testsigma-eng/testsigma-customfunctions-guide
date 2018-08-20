package com.testsigma.mobile.samples;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;

public class HybridAndroid 
{
	public static AndroidDriver driver;

	public static void main(String[] args) throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "70069a00");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability(CapabilityType.BROWSER_NAME,"chrome");
		capabilities.setCapability(CapabilityType.PLATFORM,"Android");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

		driver.get("https://demoqa.com/registration/");
		Thread.sleep(3000);
		driver.getTitle();
		WebElement firstname = driver.findElement(By.id("name_3_firstname"));
		firstname.sendKeys("Testsigma Testing");
		WebElement select = driver.findElement(By.id("dropdown_7"));
		Select country = new Select(select);
		country.selectByValue("Brazil");
		
		System.out.println("working fine");
		driver.quit();
	}
}
