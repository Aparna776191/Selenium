package Contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Createconatact {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Step 1: Load config properties
        FileInputStream fb = new FileInputStream("./src/test/resources/Config.properties");
        Properties pro = new Properties();
        pro.load(fb);

        String Browser = pro.getProperty("browser");
        String URL = pro.getProperty("url");
        String Username = pro.getProperty("username");
        String Password = pro.getProperty("password");

        // Step 2: Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);

        // Step 3: Login
        driver.findElement(By.name("user_name")).sendKeys(Username);
        driver.findElement(By.name("user_password")).sendKeys(Password);
        driver.findElement(By.id("submitButton")).click();

        // Step 4: Navigate to Contacts and Click "Create Contact"
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

        // Step 5: Select Salutation
        Select salutation = new Select(driver.findElement(By.name("salutationtype")));
        salutation.selectByValue("Ms.");

        // Step 6: Read first name, last name, and org name from Excel
        FileInputStream fs = new FileInputStream("./src/test/resources/Camp.xlsx");
        Workbook book = WorkbookFactory.create(fs);
        Sheet sheet = book.getSheet("Sheet2");
        Row row = sheet.getRow(0);
        String firstname = row.getCell(0).getStringCellValue();
        String lastname = row.getCell(1).getStringCellValue();
        String orgname = row.getCell(2).getStringCellValue();
        book.close();

        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("lastname")).sendKeys(lastname);

        // Step 7: Click on Org Lookup
        driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();

        String parentWin = driver.getWindowHandle();
        Set<String> allWins = driver.getWindowHandles();
        for (String win : allWins) {
            driver.switchTo().window(win);
            if (driver.getTitle().contains("Accounts&action")) {
                break;
            }
        }

        // Step 8: Search and select the org
        driver.findElement(By.name("search_text")).sendKeys(orgname);
        driver.findElement(By.name("search")).click();
        Thread.sleep(2000); // wait for search results

        driver.findElement(By.linkText(orgname)).click();
        driver.switchTo().window(parentWin);

        // Step 9: Save Contact
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

        // Step 10: Validation
        String headerText = driver.findElement(By.className("dvHeaderText")).getText();
        if (headerText.contains(lastname)) {
            System.out.println("✅ Contact created successfully: " + firstname + " " + lastname);
        } else {
            System.out.println("❌ Contact creation failed.");
        }

        // Step 11: Logout
        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.linkText("Sign Out")).click();

        driver.quit();
    }
}
