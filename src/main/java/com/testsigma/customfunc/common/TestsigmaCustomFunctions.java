package com.testsigma.customfunc.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;
import com.testsigma.testengine.entity.TestDataEntity;
import com.testsigma.testengine.exceptions.TestEngineException;
import com.testsigma.testengine.exceptions.TestsigmaTestdataNotFoundException;
import com.testsigma.testengine.utilities.RuntimeData;
import com.testsigma.testengine.utilities.TestDataProvider;

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

	public String getRuntimeData(String name) throws  TestEngineException  {
		String testData = new RuntimeData().getRuntimeData(name, settings);
		return testData;

	}
	
	public String getTestDataParamterValue(String name) {
		
		return null;
	
	}
	public void setRuntimeData(String name, String value) throws TestEngineException   {

		RuntimeData runtimedata = new RuntimeData();
		runtimedata.storeRuntimeVarible(name, value, settings);

	}
	
	public TestDataEntity getTestData(String name) throws  TestEngineException  {
		
		return null;
		
	}
	
	public void setTestData(TestDataEntity testData) throws TestEngineException   {

	}

}