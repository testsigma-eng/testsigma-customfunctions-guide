package com.testsigma.customfunc.examples;

import java.sql.*;

import org.openqa.selenium.WebDriver;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;

public class InsertQuery {

	protected WebDriver webdriver;

	public InsertQuery(WebDriver webdriver) {
		this.webdriver = webdriver;
	}

	@CustomTestStep
	public TestStepResult InsertQuery() throws Exception {

		TestStepResult result = new TestStepResult();

		try {
			// 1.Get connection to Database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			// 2.Create a Statement.
			Statement myStmt = myConn.createStatement();
			String query = " Insert into employees (id,First_name, Last_name,email) values(?,?,?,?)";
			PreparedStatement preparedStmt = myConn.prepareStatement(query);
			preparedStmt.setString(1, "15");
			preparedStmt.setString(2, "Stephen");
			preparedStmt.setString(3, "Gregory");
			preparedStmt.setString(4, "Stephen@Gregory.com");
			preparedStmt.execute();
			ResultSet Myrs = myStmt.executeQuery("select * from employees WHERE id=11 AND Last_name123='Stephen'");
			if (Myrs.next()) {
				result.setStatus(ResultConstants.SUCCESS);
				result.setMessage("custom step Executed successfully");
			} else {
				result.setStatus(ResultConstants.FAILURE);
				result.setMessage("Fail to verify InsertQuery");
			}
			
			    myStmt.close();
			
		} catch (Exception exc) {
			result.setStatus(ResultConstants.FAILURE);
			result.setMessage(exc.getMessage());
		}
		return result;

	}
}
