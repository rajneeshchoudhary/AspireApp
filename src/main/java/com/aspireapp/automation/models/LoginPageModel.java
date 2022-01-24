package com.aspireapp.automation.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aspireapp.automation.factory.LoginPageLocators;
import com.aspireapp.automation.utils.WaitUtil;

public class LoginPageModel extends BasePage {

	private LoginPageLocators factory;

	public LoginPageModel(WebDriver driver) {
		super(driver);
		factory = PageFactory.initElements(driver, LoginPageLocators.class);
	}

	public void provideInputsInEmailAndPassword(String email, String pwd) {
		WaitUtil.waitForClickable(factory.getDriver(), factory.loginCard, 20);
		factory.email.sendKeys(email);
		factory.password.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.loginCard, 20);
		factory.loginButton.click();
	}

	public boolean isLoggedIn() {
		return isVisible(factory.inventory);

	}

}

