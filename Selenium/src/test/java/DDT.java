import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DDT {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fb = new FileInputStream("C:\\Users\\USER\\Desktop\\DDT.properitiesfile");
		
		Properties pro = new 	Properties();
		pro.load(fb);
		
		String Browser = pro.getProperty("Browser");
		String Url = pro.getProperty("URL");
		String Username = pro.getProperty("Username");
		String Password = pro.getProperty("password");
		
		WebDriver driver;
		
		if (Browser.equalsIgnoreCase("Chrome")) {
           
            driver = new ChromeDriver();
        } else if (Browser.equalsIgnoreCase("edge")) {
            
            driver = new EdgeDriver();
        } else {
        	driver = new ChromeDriver();
        }

     driver.get(Url);
     driver.findElement(By.name("user_name")).sendKeys("Username");
     driver.findElement(By.name("user_password")).sendKeys("Password");
        
				
	}
}
