package practice.learning.EcomWeb;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBaseEcom {
	public WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@BeforeMethod
	public void setup() {
		System.out.println("From ---> setup()");

		driver = new EdgeDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	

	@AfterMethod
	public void tearDown() throws InterruptedException {
		System.out.println("From ---> tearDown()");
		Thread.sleep(1000);
		driver.quit();}

	
	
}
