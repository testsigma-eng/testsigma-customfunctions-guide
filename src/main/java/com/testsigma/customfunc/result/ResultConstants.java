package com.testsigma.customfunc.result;

import java.util.HashMap;
import java.util.Map;

public enum ResultConstants {
	SUCCESS(0, "Passed"),
	FAILURE(1,"Failed"),
	ABORTED(2,"Aborted"),
	NOT_EXECUTED(3,"Not Executed"),
	PRE_REQUISITE_FAILURE(4,"PreRequisite Failed"),
	QUEUED(5,"Queued"),
	STOPPED(6,"Stopped");
	
	private Integer id;
	private String actName;
	ResultConstants(Integer type, String actName){
		this.id = type;
		this.actName = actName;
	}
	 
	public Integer getId(){
		return id;
	}
		
	public String getActName(){
		return actName;
	}
	
	public static ResultConstants getStatus(Integer id){
		switch(id){
			case 0:
				return SUCCESS;
			case 1:
				return FAILURE;
			case 2:
				return ABORTED;
			case 3:
				return NOT_EXECUTED;
			case 4:
				return PRE_REQUISITE_FAILURE;
			case 5:
				return QUEUED;	
			case 6:
				return STOPPED;	
		}
		return null;
	}

	
	public static Map<Integer, String> getDispNameMap(){
		Map<Integer, String> toReturn = new HashMap<Integer, String>();
		for(ResultConstants type : ResultConstants.values()){
			toReturn.put(type.getId(), type.getActName());
		}
		return toReturn;
	}
	
}
