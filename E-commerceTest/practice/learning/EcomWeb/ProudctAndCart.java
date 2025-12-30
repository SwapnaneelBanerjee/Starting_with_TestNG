package practice.learning.EcomWeb;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProudctAndCart extends TestNGBaseEcom {

	@BeforeMethod
	public void performLogin() {
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		assertTrue(true);
	}

	@AfterMethod
	public void performReset() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
	}


	@Test
	public void addToCart() throws InterruptedException {
		System.out.println("Adding to Cart"); 
		Thread.sleep(500);
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));

		String count = cartBadge.getText();
		System.out.println("Current items in cart: " + count);

		org.testng.Assert.assertEquals(count, "1", "Cart count should be 1 after adding a product!");
	}

	@Test (dependsOnMethods = "addToCart")
	public void removeFromCart() {
		System.out.println("--- Validating Remove from Cart ---");

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
		int countBefore = Integer.parseInt(badge.getText());
		System.out.println("Count before removal: " + countBefore);

		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

		if (countBefore > 1) {
			WebElement badgeAfter = driver.findElement(By.className("shopping_cart_badge"));
			int countAfter = Integer.parseInt(badgeAfter.getText());
			assertTrue(countAfter < countBefore, "Cart count did not decrease!");
		} else {
			boolean isBadgeMissing = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("shopping_cart_badge")));
			assertTrue(isBadgeMissing, "Cart badge is still visible after removing the last item!");
		}

		System.out.println("Result: Success! Item removed.");
	}
}
