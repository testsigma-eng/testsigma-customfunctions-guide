package com.testsigma.customfunc.examples;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;

public class ExecuteShellScript {
	
	public static WebDriver driver;
	public ExecuteShellScript(WebDriver driver){
		this.driver = driver;
	} 
	
	@CustomTestStep
	public TestStepResult runExecutionInJava(String path) {
		TestStepResult result= new TestStepResult();   
		try {
			Process proc = Runtime.getRuntime().exec(path); //Whatever you want to execute
			BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));              

			proc.waitFor();

			while (read.ready()) {
				System.out.println(read.readLine());
			}
		}  catch (InterruptedException e) {
			
			result.setStatus(ResultConstants.FAILURE);  
			result.setMessage("Failed to execute shell script");  
			return result; 
			
		}catch (IOException e) {
			
			result.setStatus(ResultConstants.FAILURE);  
			result.setMessage("Failed to execute shell script"); 
			return result; 
			
		}catch (Exception e) {

			result.setStatus(ResultConstants.FAILURE);  
			result.setMessage("Failed to execute shell script, file not found, " + path);  
			return result; 
		}

		result.setStatus(ResultConstants.SUCCESS);  
		result.setMessage("Shell script executed successfully");  
		
		return result;
	}


}


