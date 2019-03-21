package com.testsigma.customfunc.examples;


import org.jboss.aerogear.security.otp.Totp;

import com.testsigma.customfunc.common.TestsigmaCustomFunctions;
import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;
import com.testsigma.testengine.exceptions.TestsigmaTestdataNotFoundException;

public class multiFactorAuthentication extends TestsigmaCustomFunctions{
    
    @CustomTestStep
    public TestStepResult testMFA(String securityKey , String totp) throws TestsigmaTestdataNotFoundException {
      
      TestStepResult result= new TestStepResult();
       try{
      
       String otpKeyStr = securityKey;
       
        Totp otpStr = new Totp(otpKeyStr);
	    String mfaStr = otpStr.now();
      
        setRuntimeData(totp, mfaStr);
      
        result.setStatus(ResultConstants.SUCCESS);
        result.setMessage("custom step Executed successfully");
       }
      catch(Exception e){
      	result.setStatus(ResultConstants.FAILURE);
      	result.setMessage("otp not generated");
      }
      return result;
    }
}
