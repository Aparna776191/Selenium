import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        Thread.sleep(2000);
        
        try {
            driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
        } catch (Exception e) {
            System.out.println("Login popup not displayed");
        }
        
        driver.findElement(By.name("q")).sendKeys("iphone");
        
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        List<WebElement> phones = driver.findElements(By.xpath("//div[@class='DOjaWF gdgoEp']"));
        
        for (WebElement phone : phones) {
			
        	System.out.println(phone.getText());
		}
        
        
	}

}
