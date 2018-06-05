package com.testsigma.customfunc.web.examples;

import org.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.common.ResultConstants;
import com.testsigma.customfunc.common.ResultConsts;
import com.testsigma.customfunc.common.TeststepResult;


public class CustomSteps {
	
	protected WebDriver webdriver;
	
	public CustomSteps(WebDriver webdriver){
		this.webdriver = webdriver;
	}
	
	public TeststepResult gotoPage(JSONArray arr){
		
		TeststepResult result = new TeststepResult();
		try {
			//JSONArray arr = new JSONArray(json.toString());

/*			JSONObject param2 = (JSONObject)arr.get(1);
			
			param2.get("key1");*/
			String param1 = arr.get(0).toString();
			//String param1 = arr.getJSONObject(0).toString();  
			
			for(int i=0; i<arr.length(); i++){   
			  //JSONObject o = arr.getJSONObject(i);  
			  //System.out.println(o);  
			}
			
			webdriver.navigate().to(param1);
			
			result.setStatus(ResultConstants.SUCCESS);
			result.setMessage("Successfully Executed");
			
		} catch(UnreachableBrowserException e){
			result.setStatus(ResultConstants.FAILURE);	
			result.setMessage("Unreachable Browser Exception"+ e.getMessage());
		} catch(WebDriverException e){
			result.setStatus(ResultConstants.FAILURE);
			result.setMessage("Web Driver exception" + e.getMessage());
		}
		
		return result;
	}

	public String getLastName(String pass){
		return pass;
	}
	
	public String getFirstLastName(String first, String last){
		return first + " " + last;
	}
	
	//This Step is verify no.of displayed elements with your expected count elements
	@CustomTestStep
	public TeststepResult verifyElementsCount(String locator,int size) {
		TeststepResult result= new TeststepResult();
		//Change locator type(Id,className, Xpath .....etc) as per your requirement	`
		//Size means Elements count
		if(webdriver.findElements(By.xpath(locator)).size()==size) {
			 result.setStatus(ResultConsts.SUCCESS.getId());
			 result.setMessage("custom step Executed successfully");
		} else {
			result.setStatus(ResultConsts.FAILURE.getId());
			result.setMessage("custom step Executed Failed");
		}
		  
		   return result;
	  
	  }
	 @CustomTestStep
	  public TeststepResult attributeValue() {
	  TeststepResult result= new TeststepResult();
	   	JavascriptExecutor js = (JavascriptExecutor) webdriver;
	   // getElementById('u_0_11')= getting value for same element
	   	//change element type and value, id = attribute here, changing id value to 300
	   	
		js .executeScript("document.getElementById('u_0_11').setAttribute('id', '300')");
		result.setStatus(0);
	    result.setMessage("custom step Executed successfully");
	   return result;
	  }
	
		
	}
	

