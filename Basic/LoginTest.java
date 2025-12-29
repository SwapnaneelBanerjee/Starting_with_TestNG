package practice.learning.testng;
 
import static org.testng.Assert.assertTrue;
 
import org.testng.annotations.Test;
 
public class LoginTest {	
	
	//What is a test cycle???
	//Test Cycle is a logical grouping of tests - > SmokeTests, SanityTests, Regresssion Tests, End2EndTests etc
	
	@Test (groups = {"smokeTests", "sanityTests"})
	public void verifyRegistrationWithInvalidInfo() {
		System.out.println("registration fails... coz of invalid info...");
		
		assertTrue(true);
	}
	
	@Test (groups = {"smokeTests"})
	public void verifyRegistration() {
		
		System.out.println("Verifying the registration for a user...");
		
		//By assert, we are checking amounting to check point => Testing
		assertTrue(5>1);		
	}
	
  @Test (dependsOnMethods = {"verifyRegistration"} ,
		  groups = {"sanityTests"}, dependsOnGroups = {"smokeTests"})
  public void verifyLoginWithValidCredential() {
	  
	  System.out.println("Login works...");
  }
  
  @Test  (dependsOnMethods = {"verifyLoginWithValidCredential"},
		  	groups = {"regressionTests"}, dependsOnGroups = {"sanityTests"})
  public void verifyLoginWithValidUsernameAndInvalidPassword() {
	  
	  System.out.println("Invalid password... Try again...");
  }
  
  @Test (groups = {"end2endTests"}, 		  
		  dependsOnMethods = {"verifyLoginWithValidUsernameAndInvalidPassword", "verifyLoginWithValidCredential"})
  public void verifyLoginWithInvalidUsernameAndValidPassword() {
	  
	  System.out.println("Invalid username... Try again...");
	  
  }  
}
 