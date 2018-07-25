package com.testsigma.customfunc.android.examples;

import org.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;


public class CustomSteps {
	
	protected WebDriver webdriver;
	
	public CustomSteps(WebDriver webdriver){
		this.webdriver = webdriver;
	}
	
	public TestStepResult gotoPage(JSONArray arr){
		
		TestStepResult result = new TestStepResult();
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
	public TestStepResult verifyElementsCount(String locator,int size) {
		TestStepResult result= new TestStepResult();
		//Change locator type(Id,className, Xpath .....etc) as per your requirement	`
		//Size means Elements count
		if(webdriver.findElements(By.xpath(locator)).size()==size) {
			 result.setStatus(ResultConstants.SUCCESS);
			 result.setMessage("custom step Executed successfully");
		} else {
			result.setStatus(ResultConstants.FAILURE);
			result.setMessage("custom step Executed Failed");
		}
		  
		   return result;
	  
	  }
	
		
	}
	

