package Gneric_Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import POM.HomePage;
import POM.Login;

public class Baseclasstest {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite
	public void Beforesuite() {
		System.out.println("DB connection established");
	}

	@BeforeTest
	public void Beforetest() throws InterruptedException {
		
		System.out.println("Parallel execution");
	}
	
	@BeforeClass
	public void Beforeclass() {
		System.out.println("Browser launch");
		
	}
	
	@BeforeMethod
	public void BT() throws InterruptedException {
		File_Utilities config = new File_Utilities();
		// fetch data from the config file
		String BROWSER = config.getProperty("browser");
		String URL = config.getProperty("url");
		String USERNAME = config.getProperty("username");
		String PASSWORD = config.getProperty("password");
		
		//read data from the command prompt
//		String BROWSER = System.getProperty("browser");
//		String URL = System.getProperty("url");
//		String USERNAME = System.getProperty("username");
//		String PASSWORD = System.getProperty("password");

		// Null check for safety
		if (BROWSER == null || URL == null || USERNAME == null || PASSWORD == null) {
		    throw new RuntimeException("Missing required parameters: browser, url, username, or password.");
		}

		Base_Class bc = new Base_Class();
		driver = bc.launchBrowser(BROWSER, URL);
		sdriver = driver;
		Login login =new Login(driver);
		Thread.sleep(3000);
		login.logintoApp(USERNAME, PASSWORD);
		System.out.println("Login application");
	}
	@AfterMethod
	public void AM() {
		HomePage homepage =new HomePage(driver);
		//homepage.logoutApp();
		System.out.println("Logout application");
	}
	@AfterClass
	public void AC() {
		    if (driver != null) {
		        driver.quit();
		        System.out.println("Browser closed");
		    }
		}

		
	
	
	@AfterTest
	public void AT() {
		System.out.println("Parallelexecution done");
	}
	@AfterSuite
	public void AS() {
		System.out.println("DB is closed ");
	}
	
}
