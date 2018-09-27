package com.testsigma.customfunc.common;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.testsigma.testengine.utilities.RuntimeData;

public abstract class TestsigmaCustomFunctions {
	
	protected WebDriver driver;
	private Map<String, String> settings;
	
	
	public Map<String, String> getSettings() {
		return settings;
	}

	public void setSettings(Map<String, String> settings) {
		this.settings = settings;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getRuntimeData(String name)  {
		 String testData = new RuntimeData().getRuntimeData(name, settings);
		 return testData;
		
	}
	public void setRuntimeData(String name, String value)  {
		
		RuntimeData runtimedata=new RuntimeData();
		runtimedata.storeRuntimeVarible(name, value, settings);
		
		
	}
	

}
