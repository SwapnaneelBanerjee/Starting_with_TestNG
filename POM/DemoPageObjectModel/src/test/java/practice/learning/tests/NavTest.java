package practice.learning.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practice.learning.pages.PracticePage;

public class NavTest {
	
	WebDriver driver;
	PracticePage pageObj;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		pageObj = new PracticePage(driver);
	}
	
	@AfterMethod
	public void resetBack() {
		driver.navigate().back();
		  	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
  @Test
  public void testNavigationLogin() {
	  pageObj.clickTestLoginPage();
	  System.out.println(driver.getTitle());
	  }
  
  @Test
  public void testNavigationException() {
	  
	  pageObj.clickTestException(); 
	  System.out.println(driver.getTitle());}
  
  @Test
  public void testNavigationTable() {
	  pageObj.clickTestTable();
	  System.out.println(driver.getTitle());
	  
  }
  
}
