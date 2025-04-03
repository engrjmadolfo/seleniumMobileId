package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class DataProviders {
public WebDriver driver;

	
	@DataProvider(name="SearchData")
	
	public String[][] getData() throws IOException
	{
		String path = "./src/test/resources/searchdata.xlsx";
	//	String outputPath = "./src/test/resources/searchdata_report.xlsx";

		//LoginPage lP = new LoginPage(driver);
		//MainPage mP = new MainPage(driver);
		//TC01_Login_ValidUser lt = new TC01_Login_ValidUser();
		
//		ExcelUtility xlUtility = new ExcelUtility(path, outputPath);
		ExcelUtility xlUtility = new ExcelUtility(path);
		
//		 FileInputStream input = new FileInputStream(outputPath);.
		FileInputStream input = new FileInputStream(path);
		 XSSFWorkbook workbook = new XSSFWorkbook(input);
		 XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		
		int totalRows = xlUtility.getRowCount("Sheet1");
		int totalColumns = xlUtility.getColumnCount("Sheet1",1);

		
		String loginData [][] = new String[totalRows][totalColumns];
		
		
		for(int i=1;i <= totalRows;i++)
		{
			for(int j=0;j<totalColumns;j++)
			{
				loginData[i-1][j] = xlUtility.getCellData("Sheet1", i, j);	
				
				String expected = xlUtility.getCellData("Sheet1", i, 3);
				//Writes the test result to column 4 in tesusers_report.xlsx
				XSSFRow row = sheet.getRow(i);
			    XSSFCell cell = row.createCell(3);
			/*    if(lt.loginTest(expected, path, outputPath).)
			    	cell.setCellValue("Passed");
	//		    else if (expected.equalsIgnoreCase(lP.getErrorMessage()) == true)
		//	    	 cell.setCellValue("Passed");
			    else
			    	cell.setCellValue("Failed"); */
			} 
			
		}
		
		//    FileOutputStream  output = new FileOutputStream(outputPath);
	//	    workbook.write(output);
		    workbook.close();
		    input.close();
	//	    output.close();
		    
//		System.out.println("Extracted data from excel is: " + loginData);
		return loginData;
	}
}
