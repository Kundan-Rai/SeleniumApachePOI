package section04_lec42;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// Data Driven Testing (DDT)
public class FDCalculator
{
	@Test
	public void calculateFD() throws IOException, InterruptedException
	{
		String URL = "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);
		CalculatorPage pageObj = new CalculatorPage(driver);
		
		// Click on No thanks button
		pageObj.getNoThanksButton().click();
		
		String xlFilePath = System.getProperty("user.dir")+"/testData/MoneyControlData.xlsx";
		String xlSheetName = "Sheet1";
		
		// Get total row in the sheet
		int totalRow = ExcelUtils.getRowCount(xlFilePath, xlSheetName);
		
		// Get total cell in each row
		// Not need in the current script
//		int totalCol = ExcelUtils.getCellCount(xlFilePath, xlSheetName, totalRow);
	
		for(int i = 1; i <= totalRow; i++)	// for each row
		{
			// 1. read data from the cell/sheet
			
			// Principal
			String principal = ExcelUtils.getCellData(xlFilePath, xlSheetName, i, 0);
			
			// Rate of interest
			String roi = ExcelUtils.getCellData(xlFilePath, xlSheetName, i, 1);
			
			// Period
			String period = ExcelUtils.getCellData(xlFilePath, xlSheetName, i, 2);
			
			String tenurePeriod = ExcelUtils.getCellData(xlFilePath, xlSheetName, i, 3);
			
			// Frequency
			String frequency = ExcelUtils.getCellData(xlFilePath, xlSheetName, i, 4);
			
			// Expected Maturity value
			String expectedMatValue = ExcelUtils.getCellData(xlFilePath, xlSheetName, i, 5);
		
			// 2. Pass the data read from excel to the application
			pageObj.getPrincipal().sendKeys(principal);
			pageObj.getRateOfInterest().sendKeys(roi);
			pageObj.getPeriod().sendKeys(period);
			pageObj.setTenurePeriod(tenurePeriod);
			pageObj.setFrequency(frequency);
			pageObj.getCalculateButton().click();
			
			// 3. Validation
			String actualMatValue = pageObj.getActualMaturityValue().getText();
			if(Double.parseDouble(actualMatValue) == Double.parseDouble(expectedMatValue))
			{
				ExcelUtils.setCellData(xlFilePath, xlSheetName, i, 7, "Passed!!");
				ExcelUtils.fillGreenColor(xlFilePath, xlSheetName, i, 7);
			}
			else
			{
				ExcelUtils.setCellData(xlFilePath, xlSheetName, i, 7, "Failed!!");
				ExcelUtils.fillRedColor(xlFilePath, xlSheetName, i, 7);
			}
			
			// Clear all the entered data
			Thread.sleep(5000);
			pageObj.getClearButton().click();;
		}
		driver.close();
	}
}
