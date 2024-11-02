package section04_lec41;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataToExcel
{
	// Write static data to the excel
	@Test(enabled = false)
	public void writeStaticData() throws IOException
	{
		// Create a workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Create new sheet. Here sheet name is : dataSheet
		// workbook has sheet
		XSSFSheet sheet = workbook.createSheet("staticDataSheet");
		
		// Create Row. Sheet has row
		XSSFRow row1 = sheet.createRow(0);
		
			// Create cell. Row has sheet
			row1.createCell(0).setCellValue("Java");
			row1.createCell(1).setCellValue(17);
			row1.createCell(2).setCellValue("Automation");
			
		XSSFRow row2 = sheet.createRow(1);
			
			// Create cell. Row has sheet
			row2.createCell(0).setCellValue("Python");
			row2.createCell(1).setCellValue(3);
			row2.createCell(2).setCellValue("Automation");
			
		XSSFRow row3 = sheet.createRow(2);
			
			// Create cell. Row has sheet
			row3.createCell(0).setCellValue("C#");
			row3.createCell(1).setCellValue(5);
			row3.createCell(2).setCellValue("Automation");
			
		// Now I have to add/attach the above workbook to the excel file
		File file = new File("testData/writeStaticData.xlsx");
			
//		System.out.println(file.exists());
//		file.createNewFile();
//		System.out.println(file.exists());
			
		// Open file in write mode
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.flush();
		workbook.close();
		fos.close();
	}


	// Write dynamic data to the excel sheet
	@Test
	public void writeDynamicData() throws IOException
	{
		// Create a workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Create new sheet. Here sheet name is : dataSheet
		// workbook has sheet
		XSSFSheet sheet = workbook.createSheet("DynamicDataSheet");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many row do you want");
		int totalRow = scan.nextInt();
		System.out.println("How many cells do you want in each row?");
		int totalCell = scan.nextInt();
		
		// Creating row and column and entering the data
		for(int r = 0; r < totalRow; r++)
		{
			XSSFRow currentRow = sheet.createRow(r);
			System.out.println("Enter "+(r+1)+" row data");
			for(int c = 0; c < totalCell; c++)
			{
				XSSFCell cell = currentRow.createCell(c);
				cell.setCellValue(scan.next());
			}
		}
		
		// Open the file in write mode
		File file = new File("testData/writeDynamicData.xlsx");
		
		FileOutputStream fos = new FileOutputStream(file);
		
		// Attach/Write workbook to the file
		workbook.write(fos);
		
		workbook.close();
		fos.close();
	}
}
