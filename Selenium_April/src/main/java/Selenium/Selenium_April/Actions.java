package Selenium.Selenium_April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actions {

	

	public static void ExecuteAction(AllActions TestActionValue, String TestDataValue, String LocatorValue) {

		switch (TestActionValue) {

		case LaunchURL:
			SeleniumLibrary.LaunchBrowserAndNavigateToUrl(TestDataValue);
			break;
		case MaximizeWindow:
			SeleniumLibrary.MaximizingBrowser();
			break;
		case ClickElement:
			SeleniumLibrary.ClickingAnElement(LocatorValue);
			break;
		case TypeText:
			SeleniumLibrary.EnteringText(LocatorValue, TestDataValue);
			break;
		default:
			System.out.println("Action could not be found. Please the action given");
			break;
		}

	}
}
