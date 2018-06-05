package com.testsigma.customfunc.examples;

public class CustomTestdataUtil {
	
	public String getFirstName(){
		return "Rukmangada";
	}

	public String getLastName(String pass){
		return pass;
	}
	
	public String getFirstLastName(String first, String last){
		return first + " " + last;
	}
	
}