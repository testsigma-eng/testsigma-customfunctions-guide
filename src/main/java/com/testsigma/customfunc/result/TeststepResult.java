package com.testsigma.customfunc.result;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TeststepResult {
	private Long id;
	private Long environmentId;
	private Long testCaseId;
	private Long tesCaseStepResultId = 0L;
	private Long testCaseResultId;
	private Long stepId;
	private Long parentId;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer status;
	private String message;
	private Integer errorCode;
	private String details;
	private Long duration;
	private Long parentResultId ;
	private String teststepKey ;
	private boolean skipExe = false;
	private String skipMessage;
	private Map<String, String> files;
	
	private Map<Object, Object> metadata;
	
	public TeststepResult(Long id,Long environmentId, Long testCaseId,
			Long tesCaseStepResultId, Long testCaseResultId, Long stepId) {
		this.id = id ;
		this.environmentId = environmentId;
		this.testCaseId = testCaseId;
		this.tesCaseStepResultId = tesCaseStepResultId;
		this.testCaseResultId = testCaseResultId;
		this.stepId = stepId;
	}

	private List<TeststepResult> stepResults = new ArrayList<TeststepResult>();
	
	private Map<String, String> outputData = new HashMap<String, String>();
	/**
	 * This is a default constructor for Test case step class.
	 */
	public TeststepResult() {
	}

	public TeststepResult(Long stepId) {
		this.stepId=stepId;
	}

	

	public boolean getSkipExe() {
		return skipExe;
	}

	public void setSkipExe(boolean skipExe) {
		this.skipExe = skipExe;
	}

	public Timestamp getStartTime() {
		return startTime;
	}


	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}


	public Timestamp getEndTime() {
		return endTime;
	}


	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}



	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Long getEnvironmentId() {
		return environmentId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEnvironmentId(Long environmentId) {
		this.environmentId = environmentId;
	}


	public Long getTestCaseId() {
		return testCaseId;
	}


	public void setTestCaseId(Long testCaseId) {
		this.testCaseId = testCaseId;
	}


	public Long getStepId() {
		return stepId;
	}


	public void setStepId(Long stepId) {
		this.stepId = stepId;
	}


	public Long getParentId() {
		return parentId;
	}


	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Map<String, String> getOutputData() {
		return outputData;
	}

	public void setOutputData(Map<String, String> outputData) {
		this.outputData = outputData;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public Long getParentResultId() {
		return parentResultId;
	}

	public String getTeststepKey() {
		return teststepKey;
	}

	public void setTeststepKey(String teststepKey) {
		this.teststepKey = teststepKey;
	}

	public void setParentResultId(Long parentResultId) {
		this.parentResultId = parentResultId;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getTestCaseResultId() {
		return testCaseResultId;
	}

	public void setTestCaseResultId(Long testCaseResultId) {
		this.testCaseResultId = testCaseResultId;
	}

	public List<TeststepResult> getStepResults() {
		return stepResults;
	}

	public void setStepResults(List<TeststepResult> stepResults) {
		this.stepResults = stepResults;
	}

	public Long getTesCaseStepResultId() {
		return tesCaseStepResultId;
	}

	public void setTesCaseStepResultId(Long tesCaseStepResultId) {
		this.tesCaseStepResultId = tesCaseStepResultId;
	}

	public Map<Object, Object> getMetadata() {
		return metadata;
	}

	public void setMetadata( Map<Object, Object> metadata) {
		this.metadata = metadata;
	}

	public String getSkipMessage() {
		return skipMessage;
	}

	public void setSkipMessage(String skipMessage) {
		this.skipMessage = skipMessage;
	}

	public Map<String, String> getFiles() {
		return files;
	}

	public void setFiles(Map<String, String> files) {
		this.files = files;
	}	
}
