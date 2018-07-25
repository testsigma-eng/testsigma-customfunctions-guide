package com.testsigma.customfunc.examples;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;


public class RestAPIVerifyContent
{
	public static WebDriver driver;
	public RestAPIVerifyContent(WebDriver driver){
		this.driver = driver;
	}
	
	@CustomTestStep
	public TestStepResult curl() throws Exception{

		String Rurl = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
		HttpUriRequest request = new HttpGet(Rurl);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		System.out.println(httpResponse.getStatusLine());

		TestStepResult result= new TestStepResult();

		HttpEntity entity = httpResponse.getEntity();

		if(EntityUtils.toString(entity).contains("Hyderabad")) {
			
			System.out.println("Specified Content value Available");
			result.setStatus(ResultConstants.SUCCESS);
			result.setMessage("Custom step executed successfully");
			
		} else {
			
			System.out.println("BAD REQUEST CONTENT");
			result.setStatus(ResultConstants.FAILURE);
			result.setMessage("Bad Request Content");
			
		}

		return result;
	}
}
