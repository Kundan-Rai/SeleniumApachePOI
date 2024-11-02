package section04_lec41;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataInSpecificRowAndCell
{
	// Write data in the specific row and cell
	@Test
	public void writeData() throws IOException
	{
		File file = new File("testData/Random.xlsx");
		
		FileOutputStream fos = new FileOutputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("RandomDataSheet");
		
		XSSFRow row = sheet.createRow(3);
		XSSFCell cell = row.createCell(4);
	
		cell.setCellValue("Selenium");
		
		workbook.write(fos);
		
		workbook.close();
		fos.close();
	}
}
