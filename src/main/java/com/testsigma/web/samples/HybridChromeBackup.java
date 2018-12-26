package com.testsigma.web.samples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HybridChromeBackup {
	private static String FF_DRIVER = "/Users/krnaidu/Projects/workspace/.metadata/.plugins/org.eclipse.wst.server.core/drivers/mozilla/0.210/geckodriver";
	
	private static String CHROME_DRIVER = "/Users/krnaidu/Projects/workspace/.metadata/.plugins/org.eclipse.wst.server.core/drivers/googlechrome/2.40/chromedriver";
	public static void main(String args[]) {

		WebDriver driver = null;
		try {
			

			/*DesiredCapabilities handlSSLErr = DesiredCapabilities.internetExplorer();    
			handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
			handlSSLErr.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
//			driver = 
//					new RemoteWebDriver("http://127.0.0.1:9515",
//					        DesiredCapabilities.chrome());
			
					
					new InternetExplorerDriver(handlSSLErr);
			//driver.get("http://tci:H)p6Lg9y@ybf-dev.tci-test.net");
			driver.get("https://tci:H)p6Lg9y@ybf-dev.tci-test.net");
			Thread.sleep(5000);
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("tci" + Keys.TAB.toString()+ "H)p6Lg9y");
			alert.sendKeys("tci" + Keys.TAB.toString()+ "H)p6Lg9y");
			
			alert.accept();*/
			
			/*DesiredCapabilities handlSSLErr = DesiredCapabilities.safari();    
			handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
			handlSSLErr.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new SafariDriver(handlSSLErr);
			//driver.get("http://tci:H)p6Lg9y@ybf-dev.tci-test.net");
			driver.get("https://tci:H)p6Lg9y@ybf-dev.tci-test.net");
			Thread.sleep(5000);
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("tci" + Keys.TAB.toString()+ "H)p6Lg9y");
			alert.accept();*/
			
			
			System.setProperty("webdriver.gecko.driver", FF_DRIVER);

			/*DesiredCapabilities handlSSLErr = DesiredCapabilities.firefox()   ;    
			handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
			handlSSLErr.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new FirefoxDriver(handlSSLErr);
			driver.get("https://tci:H)p6Lg9y@ybf-dev.tci-test.net");
			
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("tci" + Keys.TAB.toString()+ "H)p6Lg9y");
			alert.accept();
			Thread.sleep(5000);*/
			
			
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
			DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ()   ;    
			handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
			handlSSLErr.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new ChromeDriver(handlSSLErr);
			
			//driver.get("https://untrusted-root.badssl.com/");	
			//driver.wait(10000);
			driver.get("https://tci:H)p6Lg9y@ybf-dev.tci-test.net");
			
			/*Alert alert = driver.switchTo().alert();
			alert.sendKeys("tci" + Keys.TAB.toString()+ "H)p6Lg9y");
			alert.accept();*/
			
			String url = "test"; String username = ""; String password = "test";
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browser = cap.getBrowserName();
			if(browser.equals(BrowserType.CHROME) || browser.equals(BrowserType.GOOGLECHROME)) {
				if(url.startsWith("https://")) {
					url = url.replace("https://", "https://" + username + ":" + password + "@");
				} else {
					url = url.replace("http://", "http://" + username + ":" + password + "@");
				}
				driver.get(url);
			} else if (browser.equals(BrowserType.FIREFOX)) {
				driver.get(url);		
				Alert alert = driver.switchTo().alert();
				alert.sendKeys("tci" + Keys.TAB.toString()+ "H)p6Lg9y");
				alert.accept();
			} else if (browser.equals(BrowserType.IE)) {
				if(url.startsWith("https://")) {
					url = url.replace("https://", "https://" + username + ":" + password + "@");
				} else {
					url = url.replace("http://", "http://" + username + ":" + password + "@");
				}
				
				driver.get(url);
			} else {
				driver.get(url);
			}
			
			System.out.println("Done!!!" + browser);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			if (driver != null)
				driver.quit();
		}
		
		
				
	}
}
