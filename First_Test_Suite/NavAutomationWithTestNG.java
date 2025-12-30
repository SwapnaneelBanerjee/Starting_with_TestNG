package practice.learning.seleniumWithTestNG;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class NavAutomationWithTestNG {

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

	@Test(priority = 1)
	public void performNavigationHome() {
		System.out.println("Navigation Test Function 1: GoToHome");
		driver.findElement(By.id("menu-item-43")).click();
		String expText = "Practice Test Automation | Learn Selenium WebDriver";
		if(expText.equals(driver.getTitle())) 
			assertTrue(true);
		else
			assertTrue(false);

	}

	@Test(priority = 2)
	public void performNavigationBlog() {
		System.out.println("Navigation Test Function 2: GoToBlog");
		driver.findElement(By.id("menu-item-19")).click();

		String expText = "Blog | Practice Test Automation";
		if(expText.equals(driver.getTitle())) 
			assertTrue(true);
		else
			assertTrue(false);

	}
	
	@Test(priority = 3)
	public void performNavigationContact() {
		System.out.println("Navigation Test Function 2: GoToContact");
		driver.findElement(By.id("menu-item-18")).click();
		String expText = "Contact | Practice Test Automation | Selenium WebDriver";
		if(expText.equals(driver.getTitle())) 
			assertTrue(true);
		else
			assertTrue(false);

	}

	@Test(priority = 4)
	public void performNavigationPractice() {
		System.out.println("Navigation Test Function 3: GoToPractice");
		driver.findElement(By.id("menu-item-20")).click();
		String expText = "Practice | Practice Test Automation";
		if(expText.equals(driver.getTitle())) 
			assertTrue(true);
		else
			assertTrue(false);

	}

	@Test(priority = 5)
	public void performNavigationCourses() {
		driver.findElement(By.id("menu-item-21")).click();

		
		String expTitle = "Courses | Practice Test Automation";

		if(expTitle.equals(driver.getTitle()))
			System.out.println("Passed: Test for Practice Page");
		else
			System.out.println("Failed: Test for Practice Page");

	}
	
	@Test(priority = 6)
	public void performNavigationHome1() {
		System.out.println("Navigation Test Function 1: GoToHome");
		driver.findElement(By.id("menu-item-43")).click();
		String expText = "Practice Test Automation | Learn Selenium WebDriver";
		if(expText.equals(driver.getTitle())) 
			assertTrue(true);
		else
			assertTrue(false);

	}
	
	@Test(priority = 7)
	public void performNavigationPractice1() {
		System.out.println("Navigation Test Function 3: GoToPractice");
		driver.findElement(By.id("menu-item-20")).click();
		String expText = "Practice | Practice Test Automation";
		if(expText.equals(driver.getTitle())) 
			assertTrue(true);
		else
			assertTrue(false);
}
	@Test(priority = 8)
	public void performNavigationCourses1() {
		driver.findElement(By.id("menu-item-21")).click();

		
		String expTitle = "Courses | Practice Test Automation";

		if(expTitle.equals(driver.getTitle()))
			System.out.println("Passed: Test for Practice Page");
		else
			System.out.println("Failed: Test for Practice Page");

	}
	
	@Test(priority = 9)
	public void performNavigationContact1() {
		System.out.println("Navigation Test Function 2: GoToContact");
		driver.findElement(By.id("menu-item-18")).click();
		String expText = "Contact | Practice Test Automation | Selenium WebDriver";
		if(expText.equals(driver.getTitle())) 
			assertTrue(true);
		else
			assertTrue(false);

	}
	
	@Test(priority = 10)
	public void performNavigationHome2() {
		System.out.println("Navigation Test Function 1: GoToHome");
		driver.findElement(By.id("menu-item-43")).click();
		String expText = "Practice Test Automation | Learn Selenium WebDriver";
		if(expText.equals(driver.getTitle())) 
			assertTrue(true);
		else
			assertTrue(false);
	
	}
}
