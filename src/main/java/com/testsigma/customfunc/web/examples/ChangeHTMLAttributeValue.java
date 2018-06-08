package com.testsigma.customfunc.web.examples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.TeststepResult;

public class ChangeHTMLAttributeValue {
	protected WebDriver webdriver;
	
	public ChangeHTMLAttributeValue(WebDriver webdriver){
		this.webdriver = webdriver;
	}
	 @CustomTestStep
	  public TeststepResult attributeValue() {
	  TeststepResult result= new TeststepResult();
	   	JavascriptExecutor js = (JavascriptExecutor) webdriver;
	    // getElementById('u_0_11')= getting element element
	   	//change element type and value, id = attribute here, changing id value to 300
	   	
		js .executeScript("document.getElementById('u_0_11').setAttribute('id', '300')");
		result.setStatus(0);
	    result.setMessage("custom step Executed successfully");
	   return result;
	  }
	
}
