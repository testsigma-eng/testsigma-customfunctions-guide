package com.testsigma.customfunc.examples;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.common.TestsigmaCustomFunctions;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;
import com.testsigma.testengine.exceptions.TestEngineException;
import com.testsigma.testengine.exceptions.TestsigmaTestdataNotFoundException;

public class UpdateTestDataParamter extends TestsigmaCustomFunctions{
    @SuppressWarnings("unchecked")
    @CustomTestStep
    public TestStepResult storeRuntimeVaribleinTestDataParemeter(String runtimeData, String testdataParameter) throws TestsigmaTestdataNotFoundException, TestEngineException {
        
    	String runtimeVarValue = getRuntimeData(runtimeData);    	
    	setTestDataParameterValue(testdataParameter, runtimeVarValue);
    	TestStepResult result= new TestStepResult();
        result.setStatus(ResultConstants.SUCCESS);
        result.setMessage("custom step Executed successfully");
        return result;
    }
}
