package com.aspireapp.automation.factory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManufacturingPageLocators {
	final WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public ManufacturingPageLocators(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@title='Applications']")
	public WebElement applicationIcon;

	@FindBy(xpath = "//div[text()='Manufacturing']")
	public WebElement ManufacturingTab;

	@FindBy(xpath = "//button[@class='btn btn-primary o_list_button_add']")
	public WebElement CreateButton;

	@FindBy(xpath = "//input[@id='o_field_input_909']")
	public WebElement product;

	@FindBy(xpath = "//input[@name='product_qty']")
	public WebElement productQuantity;

	@FindBy(xpath = "//input[@id='o_field_input_1100']")
	public WebElement toProduce;

	@FindBy(xpath = "//button[@class='btn btn-primary o_form_button_save']")
	public WebElement SaveButton;

	@FindBy(xpath = "//li[@class='ui-menu-item']//a")
	public List<WebElement> dropdownListItems;

	@FindBy(xpath = "//button[@name='action_confirm']")
	public WebElement ConfirmButton;

	@FindBy(xpath = "//div[@class=\"clearfix position-relative o_form_sheet\"]")
	public WebElement manufacturingSection;

	@FindBy(xpath = "//div[@class='table-responsive']//table//a")
	public List<WebElement> addALineButton;
	@FindBy(xpath = "//div[@class='table-responsive']//table//input")
	public List<WebElement> tableInputs;
	@FindBy(xpath = "//button//span[text()=\"Mark as Done\"]")
	public WebElement markAsDone;

	@FindBy(xpath = "//header[@class='modal-header']")
	public WebElement model;

}
