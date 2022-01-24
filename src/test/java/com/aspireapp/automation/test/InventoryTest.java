package com.aspireapp.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aspireapp.automation.BaseTest;
import com.aspireapp.automation.utils.Constants;

public class InventoryTest extends BaseTest {

	@Test(priority = 1)
	public void verifyInventorySectionDisplayed() {
		boolean pass = false;
		String message = "Verify user is navigated to inventory overview.";
		try {
			loginToTheApplication();
			InventoryPageModelObject().clickOnInventoryTab();
			pass = InventoryPageModelObject().isInventoryMenuDisplayed();
			Assert.assertTrue(pass, message);
		} catch (Exception e) {
			pass = false;
			Assert.assertTrue(pass, message);
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void verifyCreateProductsSectionDisplayed() {
		boolean pass = false;
		String message = "Verify user is navigated to Create Product section.";
		try {
			log(message);
			wait(2000);
			InventoryPageModelObject().clickOnProductInDropdown();
			wait(2000);
			pass = InventoryPageModelObject().isCreateProductSectionDisplayed();
			Assert.assertTrue(pass, message);
		} catch (Exception e) {
			pass = false;
			Assert.assertTrue(pass, message);
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void verifyCreateProductFormDisplayed() {
		boolean pass = false;
		String message = "Verify Create Product form is displayed to the user.";
		try {
			log(message);
			wait(2000);
			InventoryPageModelObject().clickOnCreateProductButton();
			pass = InventoryPageModelObject().isCreateProductFormDisplayed();
			Assert.assertTrue(pass, message);
		} catch (Exception e) {
			pass = false;
			Assert.assertTrue(pass, message);
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 4)
	public void verifyCreateProductFunctionality() {
		boolean pass = false;
		String message = "Verify user is able to Create Product.";
		try {
			log(message);
			InventoryPageModelObject().provideProductName(Constants.PRODUCT_NAME);
			InventoryPageModelObject().clickOnSaveButton();
			wait(2000);
			pass = InventoryPageModelObject().isProductCreated();
			Assert.assertTrue(pass, message);
		} catch (Exception e) {
			pass = false;
			Assert.assertTrue(pass, message);
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 5)
	public void verifyManufactoringSectionDisplayed() {
		boolean pass = false;
		String message = "Verify user is navigated to Create Manufactoring Section.";
		try {
			log(message);
			ManufacturingPageModelObject().clickOnApplicationIcon();
			ManufacturingPageModelObject().clickOnManufacturingTab();
			ManufacturingPageModelObject().clickOnCreateButton();
			pass = ManufacturingPageModelObject().isManufacturingSectionDisplayed();
			Assert.assertTrue(pass, message);
		} catch (Exception e) {
			pass = false;
			Assert.assertTrue(pass, message);
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 6)
	public void verifyCreateManufacturingItem() {
		boolean pass = false;
		String message = "Verify user is able to Create Manufactoring.";
		try {
			log(message);
			ManufacturingPageModelObject().createManufacturingOrder();
			ManufacturingPageModelObject().provideInputInTable();
			ManufacturingPageModelObject().saveManufacturingOrder();
//			ManufacturingPageModelObject().confirmManufacturingOrder();
//			ManufacturingPageModelObject().markAsDone();
			pass = ManufacturingPageModelObject().isModelDisplayed();
			Assert.assertTrue(pass, message);
		} catch (Exception e) {
			pass = false;
			Assert.assertTrue(pass, message);
			System.out.println(e.getMessage());
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void initBeforeMethodCalls() {
		// initialize pages
		System.out.println(" ================ BEFORE METHOD ========");
	}

}

