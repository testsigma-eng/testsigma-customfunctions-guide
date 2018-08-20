package com.testsigma.web.samples;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SauceLabsChrome 
{
	public static WebDriver driver;
	public static final String USERNAME = "Username";
	public static final String ACCESS_KEY = "Access_Key";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "OS X 10.9");
		caps.setCapability("version", "61.0");
		caps.setCapability("screenResolution", "1024x768");

		driver = new RemoteWebDriver(new URL(URL), caps);

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
