package practice.learning.seleniumWithTestNG;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class LoginAutomationWithTestNG {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@BeforeTest
	public void setup() {
		System.out.println("From ---> setup()");

		driver = new EdgeDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		System.out.println("From ---> tearDown()");
		Thread.sleep(1000);
		driver.close();
	}

	
	@Test
	public void performLoginValied() {
		System.out.println("Login Test Function 1: ValidLogin");

		driver.findElement(By.id("menu-item-20")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Test Login Page")));
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();

		String expTitle = "Logged In Successfully | Practice Test Automation";
		String actTitle = driver.getTitle();


		if(expTitle.equals(actTitle))
			assertTrue(true);
		else
			assertTrue(false);

	}
	
	@Test
	public void performLoginInvalid() {
		System.out.println("Login Test Function 1: InvalidLogin->Username");

		driver.findElement(By.id("menu-item-20")).click();
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("ABC");
		driver.findElement(By.name("password")).sendKeys("ABC");
		driver.findElement(By.id("submit")).click();

		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

		if (errorMsg.getText().contains("Your username is invalid!")) 
			assertTrue(true);
		else 
			assertTrue(false);
	}
	@Test
	public void performLoginInvalidUsername() {
		System.out.println("Login Test Function 1: InvalidLogin->Username");

		driver.findElement(By.id("menu-item-20")).click();
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("ABC");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();

		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

		if (errorMsg.getText().contains("Your username is invalid!")) 
			assertTrue(true);
		else 
			assertTrue(false);
	}
	
	@Test
	public void performLoginInvalidPassword() {
		System.out.println("Login Test Function 1: InvalidLogin->Password");

		driver.findElement(By.id("menu-item-20")).click();
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password");
		driver.findElement(By.id("submit")).click();

		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

		if (errorMsg.getText().contains("Your password is invalid!")) 
			assertTrue(true);
		else 
			assertTrue(false);
	}

}
