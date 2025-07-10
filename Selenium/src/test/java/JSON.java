import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File fb = new File("../Selenium/src/test/resources/Jack.json");
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(fb);
		
       String Browser = data.get("BROWSER").asText();
       
		WebDriver driver;
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (Browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
	}

}
