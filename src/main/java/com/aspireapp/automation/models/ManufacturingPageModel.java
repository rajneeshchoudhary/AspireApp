package com.aspireapp.automation.models;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aspireapp.automation.factory.ManufacturingPageLocators;
import com.aspireapp.automation.utils.Constants;
import com.aspireapp.automation.utils.WaitUtil;

public class ManufacturingPageModel extends BasePage {

	private ManufacturingPageLocators factory;

	public ManufacturingPageModel(WebDriver driver) {
		super(driver);
		factory = PageFactory.initElements(driver, ManufacturingPageLocators.class);
	}

	public void clickOnApplicationIcon() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.applicationIcon, 20);
		factory.applicationIcon.click();
	}

	public void clickOnManufacturingTab() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.ManufacturingTab, 20);
		factory.ManufacturingTab.click();
	}

	public void clickOnCreateButton() {
		clickUsingJS(factory.CreateButton);
	}

	public boolean isManufacturingSectionDisplayed() {
		return isVisible(factory.manufacturingSection);
	}

	public void createManufacturingOrder() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.product, 20);
		factory.product.sendKeys(Constants.PRODUCT_NAME);
		clickUsingJS(factory.dropdownListItems.get(0));
		factory.productQuantity.clear();
		factory.productQuantity.sendKeys("10");
	}

	public void provideInputInTable() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.addALineButton.get(0), 20);
		clickUsingJS(factory.addALineButton.get(0));
		WaitUtil.waitForClickable(factory.getDriver(), factory.tableInputs.get(0), 20);
		factory.tableInputs.get(0).sendKeys(Constants.PRODUCT_NAME);
		factory.tableInputs.get(0).sendKeys(Keys.TAB);
		factory.tableInputs.get(1).sendKeys("10");
		factory.tableInputs.get(1).sendKeys(Keys.TAB);
		factory.tableInputs.get(2).sendKeys("Dozen");
	}

	public void saveManufacturingOrder() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.SaveButton, 20);
		clickUsingJS(factory.SaveButton);
	}

	public void confirmManufacturingOrder() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.ConfirmButton, 20);
		clickUsingJS(factory.ConfirmButton);
	}

	public void markAsDone() {
		WaitUtil.waitForClickable(factory.getDriver(), factory.markAsDone, 20);
		clickUsingJS(factory.markAsDone);
	}

	public boolean isModelDisplayed() {
		return isVisible(factory.model);
	}
}

