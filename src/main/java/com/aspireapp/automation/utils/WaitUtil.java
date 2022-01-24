package com.aspireapp.automation.utils;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	public static void waitForInvisibility(WebDriver driver, WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitForClickable(WebDriver driver, WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForVisibility(WebDriver driver, WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForURL(WebDriver driver, String url, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.urlToBe(url));
	}

	public static void waitForPageLoad(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	public static boolean isElementPresent(WebDriver driver, By selector) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		boolean returnVal = false;
		try {
			driver.findElement(selector);
			returnVal = true;
		} catch (Exception e) {
			returnVal = false;
		} finally {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		return returnVal;
	}

	public static boolean isAlertPresent(WebDriver driver) {
		boolean alertPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				System.out.println("alert was present");
				alertPresent = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alertPresent;
	}
}


