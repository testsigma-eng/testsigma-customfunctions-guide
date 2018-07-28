package com.testsigma.customfunc.examples;

import java.sql.*;

import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;

public class DeleteQuery {
	protected static WebDriver webdriver;

	public DeleteQuery(WebDriver webdriver) {
		this.webdriver = webdriver;
	}

	@CustomTestStep
	public TestStepResult DeleteQuery() throws Exception {

		TestStepResult result = new TestStepResult();

		try {
			// 1.Get connection to Database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			// 2.Create a Statement.
			Statement myStmt = myConn.createStatement();
			String querry = "DELETE FROM employees WHERE id = 5";
			int value = myStmt.executeUpdate(querry);
			if (value != 0) {

				result.setStatus(ResultConstants.SUCCESS);
				result.setMessage("executed successfully");
			} else {
				result.setStatus(ResultConstants.FAILURE);
				result.setMessage("Fail to verify DeleteQuery");
			}
			
			    myStmt.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return result;

	}

}
