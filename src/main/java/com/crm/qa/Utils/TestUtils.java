package com.crm.qa.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.Base.TestBase;

public class TestUtils extends TestBase {

	static Workbook workbook;
	static Sheet sheet;

	// For switching to mainapanel frame
	public void switchFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public void waitForElementToPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// TO get data from excel
	public Object[][] getTestdata(String sheetname) {

		FileInputStream filepath = null;
		try {
			filepath = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/crm/qa/Testdata/Testdata.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			workbook = WorkbookFactory.create(filepath);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = workbook.getSheet(sheetname);

		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {

				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

			}
			System.out.println();
		}

		return data;
	}

}
