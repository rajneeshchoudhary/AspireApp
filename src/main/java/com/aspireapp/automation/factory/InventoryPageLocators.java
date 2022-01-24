package com.aspireapp.automation.factory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPageLocators {
	final WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public InventoryPageLocators(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	@FindBy(xpath = "//div[@role='listbox']//a")
	public List<WebElement> listboxItems;

	@FindBy(xpath = "//div[text()='Inventory']")
	public WebElement inventory;

	@FindBy(xpath = "//ul[@class='o_menu_sections']")
	public WebElement inventoryHLMenu;

	@FindBy(xpath = "//ul[@class='o_menu_sections']//li")
	public List<WebElement> inventoryHLMenuItems;

	@FindBy(xpath = "//ul[@class='o_menu_sections']//li//div[@class='dropdown-menu show']//a")
	public List<WebElement> dropdownMenuItems;

	@FindBy(xpath = "//div[@class='o_action_manager']")
	public WebElement createProductSection;

	@FindBy(xpath = "//div[@class='o_form_sheet_bg']")
	public WebElement createProductForm;

	@FindBy(xpath = "//button[@class='btn btn-primary o-kanban-button-new']")
	public WebElement createProductButton;

	@FindBy(xpath = "//input[@placeholder='Product Name']")
	public WebElement ProductName;

	@FindBy(xpath = "//button[@class='btn btn-primary o_form_button_save']")
	public WebElement SaveButton;

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	public WebElement ActiveBreadcrumbItem;

}
