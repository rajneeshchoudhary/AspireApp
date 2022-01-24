package com.aspireapp.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageLocators {
	final WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public LoginPageLocators(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@id='login']")
	public WebElement email;
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;
	@FindBy(xpath = "//div[@class='card-body']")
	public WebElement loginCard;
	@FindBy(xpath = "//div[text()='Inventory']")
	public WebElement inventory;
}
