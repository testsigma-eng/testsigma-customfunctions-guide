package com.testsigma.mobile.samples;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.ios.IOSDriver;

public class HybridiOS 
{
	public static IOSDriver driver;

	public static void main(String[] args) throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Orugunta’s iPhone");
		capabilities.setCapability("udid", "e647c2802660d73c9340fb00411373e4b068960");
		capabilities.setCapability("platformVersion", "11.1");
		capabilities.setCapability(CapabilityType.BROWSER_NAME,"SAFARI");
		capabilities.setCapability(CapabilityType.PLATFORM,"ios");

		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

		driver.get("https://demoqa.com/registration/");
		Thread.sleep(3000);
		driver.findElement(By.id("name_3_firstname")).sendKeys("Testsigma Testing");
		WebElement select = driver.findElement(By.id("dropdown_7"));
		Select country = new Select(select);
		country.selectByValue("Brazil");

		System.out.println("working fine");
		driver.quit();
	}

}
