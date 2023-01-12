
package conf.conf;

import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {
	public String baseURL="https://indiarailinfo.com/trains";
	public static WebDriver driver;

@Test
 public void writeExcel() throws Exception {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.get(baseURL);
	
	String headingBeforeSel=".srhres > div:nth-child(2) > div:nth-child(";
	String headingAfterSel=")";
	
	
	

	String excelFileName = "/Users/ankitdixit/eclipse-workspace/conf/TestData/Book1.xlsx";	//name of excel file

	String sheetName = "Sheet1";	//name of sheet

	XSSFWorkbook wb = new XSSFWorkbook();
	XSSFSheet sheet = wb.createSheet(sheetName) ;
	
	String trainHeading="";
	
	//iterating r number of rows
	for (int r=0;r < 1; r++ )
	{	
		

		
		XSSFRow row = sheet.createRow(r);

		//iterating c number of columns
		for (int c=0;c < 17; c++ )
		{
			int i=c+1;
			trainHeading=driver.findElement(By.cssSelector(".srhres > div:nth-child(2) > div:nth-child("+i+")")).getText();
			XSSFCell cell = row.createCell(c);
			
			cell.setCellValue(trainHeading);
		}
	}

	String train="";

	int rn=1;
	for(int k=3;k<21;k+=2) {
		XSSFRow row = sheet.createRow(rn);
		for (int c=0;c < 17; c++ )
		{
			int i=c+1;
			train=driver.findElement(By.cssSelector(".srhres > div:nth-child("+k+") > div:nth-child("+i+")")).getText();
			XSSFCell cell = row.createCell(c);
			
			cell.setCellValue(train);
		}
		rn=rn+1;
		
	}
	
	
	FileOutputStream fileOut = new FileOutputStream(excelFileName);

	//write this workbook to an Outputstream.
	wb.write(fileOut);
	fileOut.flush();
	fileOut.close();
	 

	
	 }
}