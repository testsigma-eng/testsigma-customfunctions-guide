package com.testsigma.customfunc.examples;

import com.testsigma.customfunc.common.CustomTestData;
import com.testsigma.customfunc.common.TestsigmaCustomFunctions;
import com.testsigma.testengine.exceptions.TestEngineException;

public class StoreRuntimeTestDataExample extends TestsigmaCustomFunctions {

	@CustomTestData
	public String storeRuntimeTestData(String name, String value) throws TestEngineException {

		setRuntimeData(name, value);
		
		return value;

	}

}
