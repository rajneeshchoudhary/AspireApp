package com.aspireapp.automation.models;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aspireapp.automation.factory.LoginPageLocators;
import com.aspireapp.automation.utils.WaitUtil;

public class BasePage {
	private LoginPageLocators factory;

	public BasePage(WebDriver driver) {
		super();
		factory = PageFactory.initElements(driver, LoginPageLocators.class);
	}

	public boolean isVisible(WebElement element) {
		boolean retVal = false;
		try {
			WaitUtil.waitForVisibility(factory.getDriver(), element, 20);
			retVal = element.isDisplayed();
		} catch (Exception e) {
			retVal = false;
			System.out.println("Exception occurred during test: " + e.getMessage());
		}
		return retVal;
	}

	public boolean isComponentPresent(List<WebElement> ele) {
		if (getSize(ele) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize(List<WebElement> ele) {
		int size = 0;
		if (ele != null) {
			size = ele.size();
		}
		return size;
	}

	public static String getText(WebElement elem) {
		String retVal = "";
		try {
			retVal = elem.getText();
		} catch (Exception e) {
			System.out.println("Exception occurred during test: " + e.getMessage());
		}
		return retVal;
	}

	public String clickLink(List<WebElement> ele, int index) {
		String href = ele.get(index).getAttribute("href");
		clickUsingJS(ele.get(index));
		return href;
	}

	public void clickUsingJS(WebElement element) {
		JavascriptExecutor jse2 = (JavascriptExecutor) factory.getDriver();
		jse2.executeScript("arguments[0].scrollIntoView()", element);
		jse2.executeScript("arguments[0].click()", element);
	}

	public void clearFieldAndProvideInput(int Index, String Input, WebElement elem) {
		WaitUtil.waitForClickable(factory.getDriver(), elem, 20);
		clearFields(elem);
		elem.sendKeys(Input);
	}

	public static String getAttribute(List<WebElement> ele, int index, String attribute) {
		String retVal = "";
		try {
			retVal = ele.get(index).getAttribute(attribute);
		} catch (Exception e) {
			System.out.println("=============ERROR " + e.getMessage());
		}
		return retVal;
	}

	public void SendKeysInReadOnlyField(String DOB, WebElement ele) {
		WaitUtil.waitForVisibility(factory.getDriver(), ele, 20);
		((JavascriptExecutor) factory.getDriver()).executeScript("arguments[0].removeAttribute('readonly','readonly')",
				ele);
		ele.sendKeys(DOB, Keys.TAB);
	}

	public void clearFields(WebElement elem) {
		JavascriptExecutor js = (JavascriptExecutor) factory.getDriver();
		js.executeScript("arguments[0].value='';", elem);
	}

}
