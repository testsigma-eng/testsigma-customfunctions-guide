package com.testsigma.customfunc.examples;

import java.sql.*;

import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;

public class UpdateQuery {

	protected WebDriver webdriver;

	public UpdateQuery(WebDriver webdriver) {
		this.webdriver = webdriver;
	}

	@CustomTestStep
	public TestStepResult UpdateQuery() throws Exception {

		TestStepResult result = new TestStepResult();

		try {
			// 1.Get connection to Database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			// 2.Create a Statement.
			Statement myStmt = myConn.createStatement();
			String querry = "UPDATE employees SET Last_name = 'Sean Cooper' where id=5";
			myStmt.executeUpdate(querry);

			ResultSet Myrs = myStmt.executeQuery("select * from employees WHERE Last_name = 'Sean Cooper'");
			if (Myrs.next()) {
				result.setStatus(ResultConstants.SUCCESS);
				result.setMessage("custom step Executed successfully");
			} else {
				result.setStatus(ResultConstants.FAILURE);
				result.setMessage("Fail to verify UpdateQuery");
			}
			
			    myStmt.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return result;

	}
}
