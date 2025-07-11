package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import POM.HomePage;

public class CreateOrg {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver;
        
        //Hi

        // Load properties from file
        FileInputStream fis = new FileInputStream("./src/test/resources/Config.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        // Launch browser
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser. Launching Chrome as default.");
            driver = new ChromeDriver();
        }

        // Open application
        driver.manage().window().maximize();
        driver.get(url);

        // Login
        driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
        
        // Read organization name from Excel
        FileInputStream excelFile = new FileInputStream("./src/test/resources/Orgnaizations.xlsx");
        Workbook workbook = WorkbookFactory.create(excelFile);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row  row =  sheet.getRow(0);
        int  lastindex = row.getLastCellNum()-1;
        Cell cell = row.getCell(lastindex);
       // String orgName = cell.getStringCellValue();
        for (int i = 0; i < lastindex; i++) {
        	String orgName = cell.getStringCellValue();
		
         System.out.println(orgName);
//
//        // Add random number to org name
       Random rand = new Random();
       orgName = orgName + "_" + rand.nextInt(1000);
        workbook.close();
        HomePage home = new HomePage(driver);
        home.clickOrgLink();
//
//        // Create Organization
//        driver.findElement(By.linkText("Organizations")).click();
//        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//        driver.findElement(By.name("accountname")).sendKeys(orgName);
//        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//
//        // Validate
        Thread.sleep(3000);
       String header = driver.findElement(By.className("dvHeaderText")).getText();
      if (header.contains(orgName)) {
         System.out.println("✅ Organization created successfully: " + orgName);
      } else {
           System.out.println("❌ Organization creation failed.");
        }
          // Close
          driver.quit();
    }
}
}
