package conf.conf;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Task1 {
	
	public String baseURL="https://confengine.com/conferences/selenium-conf-2022/proposals";
	public static WebDriver driver;

	@Test
	public void tests() throws InterruptedException {
		driver.get(baseURL);
		
		
		
		
		try {
		    long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

		    while (true) {
		    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		        Thread.sleep(2000);

		        long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
		        if (newHeight == lastHeight) {
		            break;
		        }
		        lastHeight = newHeight;
		    }
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("title")));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("speaker_name_in_title")));
		
		List<WebElement> l= driver.findElements(By.className("speaker_name_in_title"));
		List<WebElement> p = driver.findElements(By.className("title"));

		System.out.println(l.size()+" "+ p.size());
		for(int j = 0; j< l.size(); j++) {
	         String v = l.get(j).getText();
	         String w = p.get(j).getText();
	         System.out.println(v+" - "+ w);
	    }



		

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
