package section04_lec41;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel
{
	@Test
	public void readData() throws IOException
	{
//		System.out.println(System.getProperty("user.dir"));
//		File file = new File(System.getProperty("user.dir")+"/testData/data.xlsx");
		File file = new File("testData/readData.xlsx");
//		System.out.println(file.exists());
		
		// Open the file in reading mode
		FileInputStream fis = new FileInputStream(file);
		
		// Excel File has workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		// Workbook can have multiple sheets
		// So, we have to give sheet name / index
//		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		// Sheet has multiple Rows
		// Get last row
		int totalRow = sheet.getLastRowNum();
		
		// Row has cells
		
		// Get a row
		XSSFRow row = sheet.getRow(1);
		
		// Get total cells in each row
		int totalCell = row.getLastCellNum();
		
//		System.out.println("Total rows : "+totalRow);
//		System.out.println("Total cells : "+totalCell);
	
		for(int r = 0; r <= totalRow ; r++)	// for rows
		{
			XSSFRow currentRow = sheet.getRow(r);
			for(int c = 0; c < totalCell ; c++)	// for cells
			{
//				XSSFCell currentCell = currentRow.getCell(c);
//				String cellValue = currentCell.toString();
				String cellValue = currentRow.getCell(c).toString();
				System.out.print(cellValue+"  ");
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
	}
}
