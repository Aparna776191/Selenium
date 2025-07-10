package Products;




import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteProduct {

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

		// Step 4: Click on Products link
		driver.findElement(By.linkText("Products")).click();

		// Step 5: Select a product checkbox (first row)
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[1]/input")).click();

		// Step 6: Click Delete button
		driver.findElement(By.xpath("//input[@value='Delete']")).click();

		// Step 7: Handle alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		System.out.println("✅ Product deleted successfully");

		// Step 8: Logout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		// Step 9: Close browser
		driver.quit();
	}
}



