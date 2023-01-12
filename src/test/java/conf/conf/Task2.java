package conf.conf;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;

public class Task2 {
	
	public String baseURL="https://www.meridianfurnitureusa.com/sitefiles/product-1084-13145/601-s119-black.html";
	public static WebDriver driver;

	@Test
	public void tests() throws InterruptedException {
		driver.get(baseURL);
		WebElement element=(WebElement)driver.findElement(By.cssSelector(".fltrt.prod_info"));
		String s=element.getText();
		String[] result = s.split("\n");
		System.out.println(result[1]);
		

	
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
