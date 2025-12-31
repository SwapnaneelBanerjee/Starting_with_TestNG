package practice.learning.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class Listeners implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (driver != null) {
			try {
				ScreenshotUtil.captureScreenshot(driver, result.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}