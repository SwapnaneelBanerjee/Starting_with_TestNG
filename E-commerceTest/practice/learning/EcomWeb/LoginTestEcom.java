package practice.learning.EcomWeb;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTestEcom extends TestNGBaseEcom{
	@Test
	public void validLogin() {
		System.out.println("Login Test Function 1: ValidLogin");

		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		System.out.println(driver.findElement(By.className("title")).getText());
		if(driver.findElement(By.className("title")).getText().equals("Products"))
			{assertTrue(true);}
		else
			{assertTrue(false);}
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
	}
}
