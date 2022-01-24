package com.aspireapp.automation.test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aspireapp.automation.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void verifyLoginFunctionality() {
		boolean pass = false;
		String message = "Verify Login Functionality of the application.";
		try {
			loginToTheApplication();
			pass = LoginPageBaseObject().isLoggedIn();
			Assert.assertTrue(pass, message);
		} catch (Exception e) {
			pass = false;
			Assert.assertTrue(pass, message);
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void initBeforeMethodCalls() {
		// initialize pages
		System.out.println(" ================ BEFORE METHOD ========");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		// Closing the report
	}

}
