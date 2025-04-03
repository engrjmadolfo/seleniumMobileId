package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

public FileInputStream input;
public FileOutputStream output;
public XSSFWorkbook workbook;
public XSSFSheet sheet;
public XSSFRow row;
public XSSFCell cell;
//public String path = "./src/test/resources/testusers.xlsx";
String path;
String outputPath;
/*
	public ExcelUtility(String path, String outputPath)
	{
		this.path = path;
		this.outputPath = outputPath;
	}
*/

public ExcelUtility(String path)
{
	this.path = path;
}
	public int getRowCount(String sheetName) throws IOException
	{	
		 input = new FileInputStream(path);
		 workbook = new XSSFWorkbook(input);
		 sheet = workbook.getSheet(sheetName);
		 int row = sheet.getLastRowNum();
		 workbook.close();
		 input.close();	 
		 return row;
	}
	
	public int getColumnCount(String sheetName, int rownum) throws IOException
	{
		input = new FileInputStream(path);
		workbook = new XSSFWorkbook(input);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int column = row.getLastCellNum();
		workbook.close();
		input.close();
		
		return column;
	}
	
	public String getCellData(String sheetName, int rownum, int column) throws IOException
	{
		input = new FileInputStream(path);
		workbook = new XSSFWorkbook(input);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(column);
		
		String data;
		
		DataFormatter dF = new DataFormatter();
		
		try
		{
			data = dF.formatCellValue(cell);
		}
		catch (Exception e)
		{
			data="";
		}
		
		workbook.close();
		input.close();
		return data;
		
	}

	/*
	public void setCellData(String outputPath, String sheetName, int rownum, int column, String data) throws IOException
	{
	//	output = new FileOutputStream(outputPath);
	//	workbook.write(output);
		
		input = new FileInputStream(path);
		workbook = new XSSFWorkbook(input);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
	    cell = row.createCell(column);
	    
	    cell.setCellValue(data);
	    
	    output = new FileOutputStream(outputPath);
	    workbook.write(output);
	    
	    workbook.close();
	    input.close();
	    output.close();
		
	} */
}