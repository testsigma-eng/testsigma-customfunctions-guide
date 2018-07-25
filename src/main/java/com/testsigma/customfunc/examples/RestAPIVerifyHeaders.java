package com.testsigma.customfunc.examples;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;
/*While Creating CustomStep in 'https://app.testsigma.com' use 
"import com.testsigma.customfunc.result.TeststepResult;"*/


public class RestAPIVerifyHeaders
{
	public static WebDriver driver;
	public RestAPIVerifyHeaders(WebDriver driver){
		this.driver = driver;
	}
	
	@CustomTestStep
	public TestStepResult curl() throws Exception{

		String Rurl = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
		HttpUriRequest request = new HttpGet(Rurl);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		System.out.println(httpResponse.getStatusLine());

		TestStepResult result= new TestStepResult();

		String Header = httpResponse.getHeaders("Content-Type")[0].getValue();

		if(Header.contains("application/json"))
		{
			System.out.println("Specified Header value Available");
			result.setStatus(ResultConstants.SUCCESS);
			result.setMessage("Custom step executed successfully");
		}
		else
		{
			System.out.println("BAD REQUEST HEADER");
			result.setStatus(ResultConstants.FAILURE);
			result.setMessage("Bad Request Header");
		}

		return result;
	}
}
