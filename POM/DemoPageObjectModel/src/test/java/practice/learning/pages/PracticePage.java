package practice.learning.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage {

	WebDriver driver;
	WebElement testLoginPage;
	WebElement testException;
	WebElement testTable;
	
	public PracticePage( WebDriver d) {
		driver = d;
		driver.get("https://practicetestautomation.com/practice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		testLoginPage = driver.findElement(By.linkText("Test Login Page"));
		testException = driver.findElement(By.linkText("Test Exceptions"));
		testTable = driver.findElement(By.linkText("Test Table"));
	}
	
	
	public void clickTestLoginPage() {
		testLoginPage.click();
	}
	
	public void clickTestException() {
		testException.click();
	}
	
	public void clickTestTable() {
		testTable.click();
	}

	}

