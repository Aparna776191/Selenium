package Gneric_Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

public class ListenerImp implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot on test failure
        TakesScreenshot ts = (TakesScreenshot) Baseclasstest.sdriver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/" + result.getName() + ".png");

        try {
            FileUtils.copyFile(src, dest);
            System.out.println("📸 Screenshot captured: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot: " + e.getMessage());
        }
    }
}
