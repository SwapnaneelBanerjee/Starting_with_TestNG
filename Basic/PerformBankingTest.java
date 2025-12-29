package practice.learning.testng;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import org.testng.annotations.Test;

public class PerformBankingTest {
  @Test(priority = -10)
  public void verifyUserRegistration() {
	  System.out.println("Verifying User data");
  }
  
  @Test
  public void checkingBalance() {
	  Random rn = new Random();
	 int i = rn.nextInt(2);
	  if(i>0) {
	  System.out.println("Your balance is "+rn.nextFloat(10000));
	  assertTrue(true);}
	  else {
	  System.out.println("Balance not available");
	  assertTrue(false); }
  }
  
  
  @Test (dependsOnMethods = "checkingBalance")
  public void transfersFunds() {
	  System.out.println("Transfering Funds");
  }
}
