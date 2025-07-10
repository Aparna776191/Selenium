package Products;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CreateProduct {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 1: Open application
        driver.get("http://localhost:8888");

        // Step 2: Login
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();

        // Step 3: Click on "Products"
        driver.findElement(By.linkText("Products")).click();

        // Step 4: Click on "Create Product"
        driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

        // Step 5: Read product name from Excel
        FileInputStream fis = new FileInputStream("./src/test/resources/Flipkart.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        String productName = sheet.getRow(0).getCell(0).getStringCellValue();
        workbook.close();

        // Step 6: Enter product name
        driver.findElement(By.name("productname")).sendKeys(productName);

        // Step 7: Save the product
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

        // Step 8: Validate product creation
        String headerText = driver.findElement(By.className("lvtHeaderText")).getText();
        if (headerText.contains(productName)) {
            System.out.println("✅ Product created successfully: " + productName);
        } else {
            System.out.println("❌ Product creation failed");
        }
        
        Assert.assertTrue(headerText.contains(productName),"Proname mismatched");
        System.out.println("Proname matched successfully");

        // Step 9: Logout
        
//        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//        driver.findElement(By.linkText("Sign Out")).click();

        // Step 10: Close browser
        driver.quit();
    }
}
