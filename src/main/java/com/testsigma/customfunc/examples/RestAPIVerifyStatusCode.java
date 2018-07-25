package com.testsigma.customfunc.examples;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;


public class RestAPIVerifyStatusCode
{
	public static WebDriver driver;
	public RestAPIVerifyStatusCode(WebDriver driver){
		this.driver = driver;
	}

	@CustomTestStep
	public TestStepResult curl() throws Exception{

		String Rurl = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
		HttpUriRequest request = new HttpGet(Rurl);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		System.out.println(httpResponse.getStatusLine());

		TestStepResult result= new TestStepResult();

		//Statuscode Verification
		int Statuscode = httpResponse.getStatusLine().getStatusCode();

		if(Statuscode == 200)
		{
			System.out.println("OK");
			result.setStatus(ResultConstants.SUCCESS);
			result.setMessage("Custom step executed successfully");
		}
		else
		{
			System.out.println("BAD REQUEST");
			result.setStatus(ResultConstants.FAILURE);
			result.setMessage("Bad Request");
		}
		return result;
	}
}
