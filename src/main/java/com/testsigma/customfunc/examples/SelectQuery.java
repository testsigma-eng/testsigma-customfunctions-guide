package com.testsigma.customfunc.examples;

import java.sql.*;
import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;

public class SelectQuery {

	protected static WebDriver webdriver;

	public SelectQuery(WebDriver webdriver) {
		this.webdriver = webdriver;

	}

	@CustomTestStep
	public TestStepResult select() throws Exception {

		TestStepResult result = new TestStepResult();

		try {
			// 1.Get connection to Database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			// 2.Create a Statement.
			Statement myStmt = myConn.createStatement();
			String query = "SELECT * FROM employees WHERE Last_name='House'";
			ResultSet Myrs = myStmt.executeQuery(query);
			if (Myrs.next()) {
				result.setStatus(ResultConstants.SUCCESS);
				result.setMessage("custom step Executed successfully");
			} else {
				result.setStatus(ResultConstants.FAILURE);
				result.setMessage("Fail to verify SelectQuery");
			}
			
				myStmt.close();
				
		} catch (Exception exc) {
			result.setStatus(ResultConstants.FAILURE);
			result.setMessage(exc.getMessage());
		}
		return result;

	}
}
