package practice.learning.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	WebElement homeicon;
	
	public HomePage( WebDriver d) {
		driver = d;
		driver.get("https://practicetestautomation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		homeicon = driver.findElement(By.className("custom-logo"));
		}

	public void clickHome() {
		homeicon.click();
	}
}
