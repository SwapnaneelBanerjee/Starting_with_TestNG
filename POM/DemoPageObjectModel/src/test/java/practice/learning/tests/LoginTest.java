package practice.learning.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practice.learning.pages.PracticePage;

public class LoginTest {
    
    WebDriver driver;
    PracticePage pageObj;
    
    @BeforeClass // Runs ONCE for the whole class
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
        // Assert success
    }

    @Test
    public void performInvalidLoginPassword() {
        pageObj.login("student", "wrongPass");
        // Assert error message
    }
    
    @Test
    public void performInvalidLoginUsername() {
        pageObj.login("Notstudent", "Password123");
        // Assert error message
    }
    
}