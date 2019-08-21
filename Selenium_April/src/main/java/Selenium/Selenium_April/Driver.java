package Selenium.Selenium_April;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public static void main(String[] args) throws Throwable {

		XSSFWorkbook testCaseFile = new XSSFWorkbook("src/test/TestCases/TC_1.xlsx");

		XSSFSheet testSheet = testCaseFile.getSheetAt(0);

		int TestDescriptionColumnNumber = -1, TestActionColumnNumber = -1, TestDataColumnNumber = -1,
				LocatorColumnNumber = -1;

		int totalNumberofColumnsinHeaderRow = testSheet.getRow(0).getLastCellNum();

		/* Identifying the required columns presence */

		for (int i = 0; i < totalNumberofColumnsinHeaderRow; i++) {

			XSSFCell headerCell = testSheet.getRow(0).getCell(i);

			if (headerCell != null && !headerCell.toString().trim().isEmpty()) {

				String headerName = headerCell.toString().trim();

				if (headerName.equalsIgnoreCase("TestDescription")) {

					TestDescriptionColumnNumber = i;

				} else if (headerName.equalsIgnoreCase("TestAction")) {

					TestActionColumnNumber = i;

				} else if (headerName.equalsIgnoreCase("TestData")) {

					TestDataColumnNumber = i;

				} else if (headerName.equalsIgnoreCase("Locator")) {

					LocatorColumnNumber = i;

				}
			}
		}

		/* Verifying the format of the Test Data provided and */
		if (TestDescriptionColumnNumber < 0) {

			throw new Exception("Test Description column is missing. Please check");
		}
		if (TestActionColumnNumber < 0) {

			throw new Exception("Test Description column is missing. Please check");
		}
		if (TestDataColumnNumber < 0) {

			throw new Exception("Test Description column is missing. Please check");
		}
		if (LocatorColumnNumber < 0) {

			throw new Exception("Test Description column is missing. Please check");
		}

		int totalRows = testSheet.getLastRowNum() + 1;

		/*
		 * Identifying each row's action and executing them
		 */
		
		for (int i = 1; i < totalRows; i++) {

			XSSFCell TestDescriptionCell, TestActionCell, TestDataCell, LocatorCell;
			String TestDescriptionValue = null, TestDataValue = null, LocatorValue = null;
			String TestActionValue = null;

			TestDescriptionCell = testSheet.getRow(i).getCell(TestDescriptionColumnNumber);
			TestActionCell = testSheet.getRow(i).getCell(TestActionColumnNumber);
			TestDataCell = testSheet.getRow(i).getCell(TestDataColumnNumber);
			LocatorCell = testSheet.getRow(i).getCell(LocatorColumnNumber);

			if (TestDescriptionCell != null && !TestDescriptionCell.toString().trim().isEmpty()) {
				TestDescriptionValue = TestDescriptionCell.toString().trim();
			}
			if (TestActionCell != null && !TestActionCell.toString().trim().isEmpty()) {
				TestActionValue = TestActionCell.toString().trim();
			}
			if (TestDataCell != null && !TestDataCell.toString().trim().isEmpty()) {
				TestDataValue = TestDataCell.toString().trim();
			}
			if (LocatorCell != null && !LocatorCell.toString().trim().isEmpty()) {
				LocatorValue = LocatorCell.toString().trim();
			}

			System.out.println("*************************************************************************************");
			System.out.println("TestDescriptionValue:::::::::" + TestDescriptionValue);
			System.out.println("TestActionValue::::::::::::::" + TestActionValue);
			System.out.println("TestDataValue::::::::::::::::" + TestDataValue);
			System.out.println("LocatorValue:::::::::::::::::" + LocatorValue);
			System.out.println("*************************************************************************************");

			AllActions ActionName = AllActions.valueOf(TestActionValue);
			
			Actions.ExecuteAction(ActionName, TestDataValue, LocatorValue);
			
			
			
		}

		testCaseFile.close();

	}

}
