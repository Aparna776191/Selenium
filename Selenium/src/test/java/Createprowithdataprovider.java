import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Createprowithdataprovider {

	@Test(dataProvider = "getDataExcel")
	
	public void loginData(String Firstname,String Lastname) {
		
		WebDriver driver = new ChromeDriver();
		
	    driver.get("https://www.facebook.com/");
	    
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.id("email")).sendKeys(Firstname);
	    driver.findElement(By.id("pass")).sendKeys(Lastname);
	    driver.findElement(By.name("login")).click();
	    
	}
	
	@DataProvider(name = "getDataExcel")
	
	public Object[][] getDataExcel() throws Exception, IOException {
		
		FileInputStream fs = new FileInputStream("./src/test/resources/DDTexcel.xlsx");
		Workbook book = WorkbookFactory.create(fs);
        Sheet sheet = book.getSheet("Sheet1");
        
        int rowCount = sheet.getLastRowNum();
        int cellCount  =sheet.getRow(0).getLastCellNum();
        
        Object[][] obj =new Object[rowCount][cellCount];
        
        for (int i = 1; i <=rowCount ; i++) {
        	 Row row = sheet.getRow(i);
        	for (int j = 0; j <cellCount; j++) {
        		  Cell cell = row.getCell(j);
				obj[i-1][j]= (cell != null) ? cell.toString() : "";
			}
			
		}
        
        book.close();
        fs.close();
		return obj;
        
        
		
	}
}
