package com.testsigma.customfunc.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;
import com.testsigma.testengine.entity.TestDataEntity;
import com.testsigma.testengine.exceptions.TestEngineException;
import com.testsigma.testengine.exceptions.TestsigmaTestdataNotFoundException;
import com.testsigma.testengine.utilities.RuntimeData;
import com.testsigma.testengine.utilities.TestDataProvider;
import com.testsigma.customfunc.common.TestsigmaCustomFunctions;
import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;

public class UpdateTestData extends TestsigmaCustomFunctions{
    @SuppressWarnings("unchecked")
    @CustomTestStep
    public TestStepResult updateTestData(String testDataName, String field, String serachKey, String replaceKey) throws TestsigmaTestdataNotFoundException, TestEngineException {
        
    	TestDataEntity entity = getTestData(testDataName);
    	List<Map<String, Object>> testdataSets = entity.getTestdataSets();
    	List<Map<String, Object>> newTestdataSets = new ArrayList<Map<String, Object>>(); 
    	for(Map<String, Object> dataSet : testdataSets) {
    		Map<String, String> data = (Map<String, String>)dataSet.get("data");
    		String replacedData = data.get(field) .replaceAll(Pattern.quote(serachKey), replaceKey);
          data.put(field,replacedData);
    		newTestdataSets.add(dataSet);
    	}
    	entity.setTestDataSets(newTestdataSets);;
    	setTestData(entity);
    	
        TestStepResult result= new TestStepResult();
        result.setStatus(ResultConstants.SUCCESS);
        result.setMessage("custom step Executed successfully");
        return result;
    }
}
