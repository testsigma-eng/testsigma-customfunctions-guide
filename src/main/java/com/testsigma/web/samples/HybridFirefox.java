package com.testsigma.web.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HybridFirefox 
{
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver","/Users/rajeshreddy/testsigma/drivers/mozilla/0.210/geckodriver");
		
		driver = new FirefoxDriver();
		
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
