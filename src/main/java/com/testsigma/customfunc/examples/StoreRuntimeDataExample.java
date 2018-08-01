package com.testsigma.customfunc.examples;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;
import com.testsigma.testengine.custom.TestsigmaCustomFunction;
import com.testsigma.testengine.exceptions.TestEngineException;

public class StoreRuntimeDataExample extends TestsigmaCustomFunction {
	@CustomTestStep
	public TestStepResult storeRuntimeData(String name, String value) throws TestEngineException {
		TestStepResult result = new TestStepResult();
		setRuntimeData(name, value);
		result.setStatus(ResultConstants.SUCCESS);
		result.setMessage("custom step Executed successfully");
		result.getMetadata().put("metadatakey", "metadataresult");
		return result;
	}

}
