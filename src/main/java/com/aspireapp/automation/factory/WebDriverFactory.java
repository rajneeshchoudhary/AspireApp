package com.aspireapp.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	public static WebDriver getWindowsChromeDriver() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream").addArguments("allow-file-access-from-files");
		options.addArguments("--use-fake-device-for-media-stream");
		options.addArguments("--ignore-certificate-errors");
		return new ChromeDriver(options);
	}

	public static WebDriver getChromeDriverHeadless() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("allow-file-access-from-files");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("headless");
		options.addArguments("window-size=1200x800");
		return new ChromeDriver(options);
	}


}
