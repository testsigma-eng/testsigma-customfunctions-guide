package com.testsigma.customfunc.examples;

import com.testsigma.customfunc.common.CustomTestData;
import com.testsigma.testengine.custom.TestsigmaCustomFunction;
import com.testsigma.testengine.exceptions.TestEngineException;

public class StoreRuntimeTestDataExample extends TestsigmaCustomFunction {

	@CustomTestData
	public String storeRuntimeTestData(String name, String value) throws TestEngineException {

		setRuntimeData(name, value);
		
		return value;

	}

}
