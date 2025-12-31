package practice.learning.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practice.learning.pages.HomePage;

public class HomeTest {
	WebDriver driver;
	HomePage pageObj;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		pageObj = new HomePage(driver);
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
  @Test
  public void testHomeNavigation() {
	  pageObj.clickHome();
	  System.out.println(driver.getTitle());
  }
}
