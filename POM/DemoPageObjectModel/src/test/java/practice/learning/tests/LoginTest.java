package practice.learning.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practice.learning.pages.PracticePage;

public class LoginTest {
	
	WebDriver driver;
	PracticePage pageObj;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		pageObj = new PracticePage(driver);
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
  @Test
  public void f() {
  }
}
