package Selenium.Selenium_April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLibrary {

	public static WebDriver driver = null;

	public static void LaunchBrowserAndNavigateToUrl(String TestDataValue) {
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(TestDataValue);
	}

	public static void MaximizingBrowser() {
		driver.manage().window().maximize();
	}

	public static void ClickingAnElement(String LocatorValue) {
		WebelementToHandle(LocatorValue).click();
	}

	public static void EnteringText(String LocatorValue, String TestDataValue) {
		WebelementToHandle(LocatorValue).sendKeys(TestDataValue);
	}
	
	public static WebElement WebelementToHandle(String LocatorValue) {
		return driver.findElement(By.xpath(LocatorValue));
	}

}
