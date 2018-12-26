package com.testsigma.web.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HybridUploadFile {
	private static String FF_DRIVER = "/Users/krnaidu/Projects/workspace/.metadata/.plugins/org.eclipse.wst.server.core/drivers/mozilla/0.210/geckodriver";
	
	private static String CHROME_DRIVER = "/Users/krnaidu/Projects/workspace/.metadata/.plugins/org.eclipse.wst.server.core/drivers/googlechrome/2.40/chromedriver";
	public static void main(String args[]) {

		WebDriver driver = null;
		try {
			
			
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
			DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ()   ;    
			handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
			handlSSLErr.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new ChromeDriver(handlSSLErr);
	
			
			driver.get("https://www.geniusplaza.com/en/");
			driver.findElement(By.xpath("//p[text()='Log In']")).click();
			driver.findElement(By.xpath("//div[@class='modal-common-container flex-column flex-centered open-login-modal']/descendant::input[@name='username']")).sendKeys("myteacher");
		    driver.findElement(By.xpath("//div[@class='modal-common-container flex-column flex-centered open-login-modal']/descendant::input[@name='password']")).sendKeys("123");
		    driver.findElement(By.xpath("//div[@class='modal-common-container flex-column flex-centered open-login-modal']/descendant::input[@value='Submit']")).click();
		    
		    driver.findElement(By.xpath("//a[@class='co-create-plus-icon']")).click();
		    driver.findElement(By.xpath("//a[@class='authoring Video-author']")).click();
		    driver.findElement(By.xpath("//i[@class='fa fa-plus']")).click();
		    //driver.findElement(By.xpath("//div[@id='videoDropzone']")).click();
			
			
		    String jsScript = "var input = document.getElementsByClassName('dz-hidden-input')[1];"
		            +"input.value='/Users/krnaidu/Downloads/test1.png';";
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript(jsScript);
		    
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			if (driver != null)
				driver.quit();
		}
		
		
				
	}
}
