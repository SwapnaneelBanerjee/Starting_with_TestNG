package practice.learning.testng;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LoginTestWithTestNG {	
	
	
	@Test (priority = -100)
	public void verifyRegistration() {
		System.out.println("Checking Registration");
		assertTrue(true);
	}
	
  @Test
  public void verifyLoginWithValidCredential() {
	  System.out.println("Login works");	  
	  
  }
  
  @Test (dependsOnMethods = "verifyRegistration")
  public void verifyLoginWithValidUsernameAndInvalidPassword() {
	  System.out.println("Incorrect Password");
	  
  }
  
  @Test
  public void verifyLoginWithInvalidUsernameAndValidPassword() {
	  System.out.println("Invalid Username");
	  
	  
  }
  
  
  
  
  
}