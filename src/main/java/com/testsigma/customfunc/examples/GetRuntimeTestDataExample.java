package com.testsigma.customfunc.examples;

import com.testsigma.customfunc.common.CustomTestData;
import com.testsigma.customfunc.common.TestsigmaCustomFunctions;
import com.testsigma.testengine.exceptions.TestEngineException;

public class GetRuntimeTestDataExample extends TestsigmaCustomFunctions {

	@CustomTestData
	public String useRuntimeTestData(String name) throws TestEngineException {

		String testData = getRuntimeData(name);
		return testData;

	}

}
