package com.testsigma.customfunc.examples;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.common.TestsigmaCustomFunctions;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;
import com.testsigma.testengine.exceptions.TestsigmaTestdataNotFoundException;

public class ValidateUrl extends TestsigmaCustomFunctions{
    @SuppressWarnings("unchecked")
    @CustomTestStep
    public TestStepResult navigate(String rName) throws TestsigmaTestdataNotFoundException, Exception {
            	
     String url = "http://demo5kentico10.raybiztech.com/web-hook/Executing/ProcessDomainPortfolio?itemID="+getRuntimeData(rName)+"&Status=Run%20Successful&StatusDate=08-08-2018%2012:00"; 
		
      	driver.navigate().to(url);
        Thread.sleep(5000);
        TestStepResult result= new TestStepResult();
        result.setStatus(ResultConstants.SUCCESS);
        result.setMessage("custom step Executed successfully");
        return result;
    }
}