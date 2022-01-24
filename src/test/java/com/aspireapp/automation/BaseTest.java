package com.aspireapp.automation;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aspireapp.automation.factory.WebDriverFactory;
import com.aspireapp.automation.models.InventoryPageModel;
import com.aspireapp.automation.models.LoginPageModel;
import com.aspireapp.automation.models.ManufacturingPageModel;
import com.aspireapp.automation.utils.Constants;

public class BaseTest {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal();

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) {

		String suitName = context.getSuite().getName();
		System.out.println(" ================ BEFORE SUITE ========" + suitName);
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println(" ================ AFTER SUITE ========");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass(ITestContext context) {
		System.out.println(" ================ AFTER Class ========");
		getCurrentDriver().close();
		System.out.println(" ================ Browser Closed ========");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println(" ================ BEFORE Class ========");
		setupDriver();
		openPage();
	}

	public WebDriver getCurrentDriver() {

		return driver.get();
	}

	public void setupDriver() {

		driver.set(WebDriverFactory.getWindowsChromeDriver());
	}

	public void setImplicitWait(int waitSeconds) {
		getCurrentDriver().manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
	}

	public void openPage() {
		getCurrentDriver().get(Constants.URL);
		setImplicitWait(15);
		getCurrentDriver().manage().window().maximize();

	}

	public String capture(WebDriver driver) {
		String errFilePath = "";
		try {
			String name = System.currentTimeMillis() + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File Dest = new File("test-output/custom/images/" + name);
			errFilePath = Dest.getAbsolutePath();

			FileUtils.copyFile(scrFile, Dest);
		} catch (Exception e) {
			log(e.getMessage());
		}
		return errFilePath.substring(errFilePath.indexOf("/images") + 1).replace("/images", "./images");
	}

	public void refreshPage() {
		getCurrentDriver().navigate().refresh();
	}

	public void navigateBackPage() {
		getCurrentDriver().navigate().back();
	}

	public String currentURL() {
		return getCurrentDriver().getCurrentUrl();
	}

	public void log(String message) {
		System.out.println(new Date() + " ================ " + message);
	}

	public void wait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}

	protected LoginPageModel LoginPageBaseObject() {
		return new LoginPageModel(getCurrentDriver());
	}

	protected InventoryPageModel InventoryPageModelObject() {
		return new InventoryPageModel(getCurrentDriver());
	}

	protected ManufacturingPageModel ManufacturingPageModelObject() {
		return new ManufacturingPageModel(getCurrentDriver());
	}

	protected void loginToTheApplication() {
		log("providing credentials....");
		LoginPageBaseObject().provideInputsInEmailAndPassword(Constants.EMAIL, Constants.PASSWORD);
		log("Clicking on login button.");
		LoginPageBaseObject().clickOnLoginButton();
	}
}

