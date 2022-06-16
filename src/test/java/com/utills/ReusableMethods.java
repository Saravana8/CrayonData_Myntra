package com.utills;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class ReusableMethods {

	public static WebDriver driver;

	public void lunchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vijay\\git\\CryonData_Myntra\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}

	public void elementClk(WebElement element) {

		element.click();

	}

	public void elementClkwithWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

	}
	
	public void waitFor(long seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}

	public void typeValue(WebElement element, String text) {

		element.sendKeys(text);
	}

	public void Screenshot_OnFail(Scenario scenario) {

		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");

		}

	}

}
