package com.aspireapp.automation.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aspireapp.automation.factory.InventoryPageLocators;
import com.aspireapp.automation.utils.Constants;
import com.aspireapp.automation.utils.WaitUtil;

public class InventoryPageModel extends BasePage{
	private InventoryPageLocators factory;

	public InventoryPageModel(WebDriver driver) {
		super(driver);
		factory = PageFactory.initElements(driver, InventoryPageLocators.class);
	}

	public void clickOnInventoryTab() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.inventory, 20);
		factory.inventory.click();
	}

	public void clickOnProductInDropdown() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.inventoryHLMenuItems.get(2), 20);
//		clickUsingJS(factory.inventoryHLMenuItems.get(2));
		factory.inventoryHLMenuItems.get(2).click();
		WaitUtil.waitForClickable(factory.getDriver(), factory.dropdownMenuItems.get(0), 20);
//		factory.inventoryHLMenuItems.get(2).click();
		clickUsingJS(factory.dropdownMenuItems.get(0));
	}

	public boolean isInventoryMenuDisplayed() {
		return isVisible(factory.inventoryHLMenu);
	}

	public boolean isCreateProductSectionDisplayed() {
		return isVisible(factory.createProductSection);
	}

	public void clickOnCreateProductButton() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.createProductButton, 20);
		clickUsingJS(factory.createProductButton);
	}

	public boolean isCreateProductFormDisplayed() {
		return isVisible(factory.createProductForm);
	}

	public void provideProductName(String ProductName) {
		WaitUtil.waitForClickable(factory.getDriver(), factory.ProductName, 20);
		factory.ProductName.sendKeys(ProductName);
	}

	public void clickOnSaveButton() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.SaveButton, 20);
		clickUsingJS(factory.SaveButton);
	}

	public boolean isProductCreated() {
		boolean flag = getText(factory.ActiveBreadcrumbItem).contains(Constants.PRODUCT_NAME);
		return isVisible(factory.ActiveBreadcrumbItem) && flag;
	}


}
