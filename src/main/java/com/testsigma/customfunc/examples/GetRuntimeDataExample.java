package com.testsigma.customfunc.examples;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;
import com.testsigma.testengine.custom.TestsigmaCustomFunction;
import com.testsigma.testengine.exceptions.TestEngineException;

public class GetRuntimeDataExample extends TestsigmaCustomFunction {

	@CustomTestStep
	public TestStepResult gettingRuntimeData(String name) throws TestEngineException {
		TestStepResult result = new TestStepResult();
		String testData = getRuntimeData(name);
		result.setStatus(ResultConstants.SUCCESS);
		result.setMessage("custom step Executed successfully");
		result.getMetadata().put("metadatakey", "metadataresult");
		return result;

	}

}