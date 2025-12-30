package practice.learning.seleniumWithTestNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import static org.testng.Assert.assertTrue;


public class ContactAutomationWithTestNG {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@BeforeTest
	public void setup() {
		System.out.println("From ---> setup()");

		driver = new EdgeDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("menu-item-18")).click();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		System.out.println("From ---> tearDown()");
		Thread.sleep(1000);
		driver.close();
	}
	
	public String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	@Test
	public void sendMessage() throws IOException, InterruptedException {
		System.out.println("performing sendMessage");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		try {
			WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpforms-161-field_0")));
			firstName.clear();
			firstName.sendKeys("TestUser");
			driver.findElement(By.id("wpforms-161-field_0-last")).sendKeys("LastName");

			driver.findElement(By.id("wpforms-161-field_1")).sendKeys("test@example.com");
			driver.findElement(By.id("wpforms-161-field_2")).sendKeys("This is a test message for my test suite.");
			
			WebElement submitBtn = driver.findElement(By.id("wpforms-submit-161"));
			submitBtn.click();
			
			
			boolean isSuccess = wait.until(ExpectedConditions.textToBePresentInElementLocated(
					By.className("wpforms-confirmation-container-full"), "Thanks for contacting us!"));
			js.executeScript("window.scrollBy(0, 500)");

			if (isSuccess) {
				System.out.println("Result: Message Sent Successfully (Positive Test Passed)");
			}

		} catch (Exception e) {
			System.out.println("Result: Test Failed due to: " + e.getMessage());
			WebElement formArea = driver.findElement(By.id("wpforms-161"));
			Thread.sleep(1200);
			File scrFile = formArea.getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile, new File("./src/test/resources/"+timestamp()+".png"));
			assertTrue(false);
		}
	}

}

