package com.testsigma.customfunc.examples;

import com.testsigma.customfunc.common.CustomTestData;
import com.testsigma.testengine.custom.TestsigmaCustomFunction;
import com.testsigma.testengine.exceptions.TestEngineException;

public class GetRuntimeTestDataExample extends TestsigmaCustomFunction {

	@CustomTestData
	public String getRuntimeTestData(String name) throws TestEngineException {

		String testData = getRuntimeData(name);
		return testData;

	}

}
