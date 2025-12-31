package practice.learning.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) throws IOException {
    
        TakesScreenshot ts = (TakesScreenshot) driver;
        
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        String destPath = System.getProperty("user.dir") + "/src/test/resources/" + testName + ".png";
        File destination = new File(destPath);
        
        FileUtils.copyFile(source, destination);
        System.out.println("Screenshot taken for failed test: " + testName);
    }
}