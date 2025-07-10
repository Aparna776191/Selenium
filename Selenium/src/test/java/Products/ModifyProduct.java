package Products;




import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModifyProduct {

	public static void main(String[] args) throws InterruptedException {

		// Step 1: Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Step 2: Open application
		driver.get("http://localhost:8888");

		// Step 3: Login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// Step 4: Click on Products
		driver.findElement(By.linkText("Products")).click();

		// Step 5: Click on a product name to modify (first product in list)
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[3]/a")).click();

		// Step 6: Click Edit button
		driver.findElement(By.name("Edit")).click();

		// Step 7: Modify product name
		WebElement productName = driver.findElement(By.name("productname"));
		productName.clear();
		productName.sendKeys("ModifiedProductName");

		// Step 8: Click Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 9: Validate
		String header = driver.findElement(By.className("lvtHeaderText")).getText();
		if (header.contains("ModifiedProductName")) {
			System.out.println("✅ Product modified successfully.");
		} else {
			System.out.println("❌ Product modification failed.");
		}

		// Step 10: Logout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		// Step 11: Close browser
		driver.quit();
	}
}

