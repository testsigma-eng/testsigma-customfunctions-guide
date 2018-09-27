package com.testsigma.testengine.exceptions;



public class TestEngineException extends Exception {
	private static final long serialVersionUID = 7078834846841544586L;
	
	
	
	private Integer errorCode ;
	private String message;
	private String details;
	private String dispMessage;

	public TestEngineException(Integer errorCode){
		this.errorCode = errorCode;
		
	}
	
	public TestEngineException(String message, String details){
		this.message = message;
		this.details = details;
		
	}
	
	public TestEngineException(Exception ex){
		super(ex);		
		this.dispMessage = ex.getLocalizedMessage();
		this.message = ex.getMessage();
		
	}
	
	public TestEngineException(String msg, Exception ex){
		super(msg, ex);		
		this.dispMessage = msg;
		this.message = msg;
		
	}
	
	public TestEngineException(String exceptionMessage){
		errorCode = 0;
		this.message = exceptionMessage;
		
	}

	public TestEngineException(Integer errorCode ,String message){
		this.errorCode = errorCode;
		this.message = message;
		this.dispMessage = message;
		
	}
	
	public TestEngineException(Integer errorCode ,String message, String details){
		this.errorCode = errorCode;
		this.message = message;
		this.dispMessage = message;
		this.details = details;
		
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDispMessage() {
		return dispMessage;
	}
	public void setDispMessage(String dispMessage) {
		this.dispMessage = dispMessage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}

