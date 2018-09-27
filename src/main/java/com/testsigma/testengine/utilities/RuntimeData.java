package com.testsigma.testengine.utilities;

import java.util.Map;

public class RuntimeData {

	/**
	 * Clear run time data.
	 */
	public void clearRunTimeDataForAllSessions() {

	}

	/**
	 * Clear run time data for a webdriver session mapped to an execution ID.
	 */
	public void clearRunTimeData(String executionID) {
		// TODO: remove from database
	}

	public String getRuntimeData(String varibleName, Map<String, String> envSettings) {

		return null;
	}

	public void storeRuntimeVarible(String variableName, String value, Map<String, String> envSettings) {

	}

}
