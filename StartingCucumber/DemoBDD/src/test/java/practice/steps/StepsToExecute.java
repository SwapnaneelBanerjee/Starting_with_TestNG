package practice.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StepsToExecute {
	
	WebDriver driver;
	
	//hooks 1. @Before ; 2. @BeforeAll ; 3. @BeforeStep; 4. @AfterStep; 5. @AfterAll; 6. @After
	
	@Before
	public void setup() {
		driver = new EdgeDriver(); driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	/*
	 * @BeforeStep public void befEachStep() {
	 * 
	 * }
	 * 
	 * @AfterStep public void aftEachStep() {
	 * 
	 * }
	 * 
	 */	

	@Given("User on login page")
	public void user_on_login_page() {
	    driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("User Enters correct username and password")
	public void user_enters_correct_username_and_password() {	    
		driver.findElement(By.name("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");		
	}

	@When("User clicks login button")
	public void user_clicks_login_button() {
	    driver.findElement(By.id("submit")).click();
	}

	@Then("User lands on welcome page")
	public void user_lands_on_welcome_page() {
	    
	   if(driver.findElement(By.linkText("Log out")).isDisplayed()) {
		   Assert.assertTrue(true);
	   }
	   else
		   Assert.assertFalse(false);
	}


}