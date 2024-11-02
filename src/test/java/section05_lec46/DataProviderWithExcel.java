package section05_lec46;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel
{
	@Test(dataProvider = "dp")
	public void readData(String bookName, String purchaseData, String amount, String location)
	{
		System.out.println(bookName+" "+purchaseData+" "+amount+" "+location);
	}
	
	@DataProvider(name = "dp")
	public Object[][] passData() throws IOException
	{
		FileInputStream fis = new FileInputStream("testData/readData.xlsx");
		
//		File file = new File("testData/readData.xlsx");
//		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
//		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFSheet sheet = workbook.getSheetAt(0);
		
//		int totalRow = sheet.getLastRowNum();
		int totalRow = sheet.getPhysicalNumberOfRows();	
		
//		XSSFRow row = sheet.getRow(totalRow);
//		int totalCell = row.getLastCellNum();
		XSSFRow row = sheet.getRow(0);
		int totalCell = row.getPhysicalNumberOfCells();
		
		Object[][] data = new Object[totalRow-1][totalCell];
		
		for(int i = 1; i < totalRow ; i++)
		{
			for(int j = 0; j < totalCell; j++)
			{
				data[i-1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return data;
		
//		return new Object[][] {
//			{totalRow,totalCell}
//		};
	}
}
