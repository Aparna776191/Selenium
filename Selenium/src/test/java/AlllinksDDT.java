import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlllinksDDT {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		String path = "../Selenium/src/test/java/Flipkart.xlsx";
		FileInputStream fb = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fb);
		Sheet s = wb.getSheet("Sheet1");
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
		
        List<WebElement> allLinks = driver.findElements(By.tagName("//a"));
        
        for(WebElement links : allLinks) {
        	String url = links.getAttribute("href");
        	String text = links.getText();
        }
		
		

	}

}
