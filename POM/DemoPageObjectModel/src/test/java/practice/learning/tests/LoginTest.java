package practice.learning.tests;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import practice.learning.pages.PracticePage;

@Listeners(practice.learning.utility.Listeners.class)
public class LoginTest {
    
    public WebDriver driver;
    PracticePage pageObj;
    
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageObj = new PracticePage(driver);
    }

    @BeforeMethod 
    public void resetState() {
    	pageObj.openLoginPage();
    }
    
    @AfterClass 
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
            driver.quit();
    }

    @Test
    public void performValidLogin() {
        pageObj.login("student", "Password123");
        
        String expectedTitle = "Logged In Successfully | Practice Test Automation";
  	  String actualTitle = pageObj.getPageTitle();
  	  assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void performInvalidLoginPassword() {
        pageObj.login("student", "wrongPass");
        String expectedText = "Your password is invalid!";
        String actualText = pageObj.errorMessageDisplayed();
        assertEquals(actualText,expectedText);
    }
    
    @Test
    public void performInvalidLoginUsername() {
        pageObj.login("Notstudent", "Password123");
        String expectedText = "Your username is invalid!";
        String actualText = pageObj.errorMessageDisplayed();
        assertEquals(actualText,expectedText);        
    }
    
}