package Gneric_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class {
	
	public WebDriver driver;
	
	public WebDriver  launchBrowser(String BROWSER,String URL) {
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("EDGE")){
			driver = new EdgeDriver();
		}else if(BROWSER.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
	
	
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	
	}
	
	public static String takeScreenShotEx(WebDriver driver,String screenShotName) throws Throwable {
		TakesScreenshot  ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots"+screenShotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
		
	}

}
