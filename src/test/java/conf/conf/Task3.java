package conf.conf;

import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;

public class Task3 {
	
	public String baseURL="https://indiarailinfo.com/trains";
	public static WebDriver driver;
	String trainNo="";
	@Test
	public void tests() throws Exception {
		driver.get(baseURL);
		
		String beforeSel=".srhres > div:nth-child(";
		String afterSel=") > div:nth-child(1)";
		for(int i=5;i<22;i+=2) {
			String actualSel=beforeSel+i+afterSel;
				trainNo=driver.findElement(By.cssSelector(actualSel)).getText();
				
				System.out.println(trainNo);
			
			
			
		
			
			
//			actualSel=beforeSel+i+") > div:nth-child(2)";
//			String name=driver.findElement(By.cssSelector(actualSel)).getText();
//			System.out.println(name);
		}
		
		
	
		writeExcel("Sheet1", trainNo, 0, 0);
		writeExcel("Sheet1", trainNo, 1, 0);
	
	
	}
	
	
	
		 

		 public void writeExcel(String sheetName, String cellvalue, int r, int c) throws Exception {
			  
				String excelFileName = "/Users/ankitdixit/eclipse-workspace/conf/TestData/Book1.xlsx";//name of excel file

				

				XSSFWorkbook wb = new XSSFWorkbook();
				XSSFSheet sheet = wb.createSheet(sheetName) ;
				XSSFRow row = sheet.createRow(r);
				XSSFCell cell = row.createCell(c);
				cell.setCellValue(cellvalue);

				FileOutputStream fileOut = new FileOutputStream(excelFileName);

				//write this workbook to an Outputstream.
				wb.write(fileOut);
				fileOut.flush();
				fileOut.close();
			 
			 
			 
			 }


  @BeforeTest
  public void beforeTest() throws Exception {
		//set path to chromedriver.exe
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
