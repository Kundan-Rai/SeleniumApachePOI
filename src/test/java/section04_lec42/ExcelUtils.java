package section04_lec42;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	public static File file;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	// Returns total no of rows
	public static int getRowCount(String xlFilePath, String xlSheetName) throws IOException
	{
		file = new File(xlFilePath);
		fis = new FileInputStream(file);
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlSheetName);
		int rowCount = sheet.getLastRowNum();
		
		workbook.close();
		fis.close();
		return rowCount;
	}
	
	// Returns total no of cells in each row
	public static int getCellCount(String xlFilePath, String xlSheetName, int rowNum) throws IOException
	{
		file = new File(xlFilePath);
		fis = new FileInputStream(file);
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlSheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		
		workbook.close();
		return cellCount;
	}
	
	// Get cell data from the specific cell
	public static String getCellData(String xlFilePath, String xlSheetName, int rowNum, int cellNum) throws IOException
	{
		file = new File(xlFilePath);
		fis = new FileInputStream(file);
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlSheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		String data;
		try
		{
//			cell.toString();
			
			// Use either toString() or below class
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String regardless of the cell type
		}
		catch(Exception e)
		{
			data = "";
		}
		workbook.close();
		return data;
	}
	
	// Write data to the cell
	public static void setCellData(String xlFilePath, String xlSheetName, int rowNum, int cellNum, String data) throws IOException
	{
		file = new File(xlFilePath);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);	// Read/get/open workbook workbook) from the excel file
		sheet = workbook.getSheet(xlSheetName);
		row = sheet.getRow(rowNum);
		
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(file);
		workbook.write(fos);	// write/attach workbook to the excel file
		
		workbook.close();
	}
	
	// Fill green color to the cell
	public static void fillGreenColor(String xlFilePath, String xlSheetName, int rowNum, int cellNum) throws IOException
	{
		file = new File(xlFilePath);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);	// Read/get/open workbook workbook) from the excel file
		sheet = workbook.getSheet(xlSheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fos = new FileOutputStream(file);
		workbook.write(fos);	// write/attach workbook to the excel file
		
		workbook.close();
		
	}

	// Fill Red color to the cell
	public static void fillRedColor(String xlFilePath, String xlSheetName, int rowNum, int cellNum) throws IOException
	{
		file = new File(xlFilePath);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);	// Read/get/open workbook workbook) from the excel file
		sheet = workbook.getSheet(xlSheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
			
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
		cell.setCellStyle(style);
		fos = new FileOutputStream(file);
		workbook.write(fos);	// write/attach workbook to the excel file
			
		workbook.close();
			
	}
	

}
