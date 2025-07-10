

package POM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampaignsPage {

	WebDriver driver;

	public CampaignsPage(WebDriver driver) {
		this.driver = driver;
	}
        //getcampaigns1
	public List<WebElement> getAllCampaignRows() {
		return driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr"));
	}

	public String getCampaignNameByRow(int rowIndex) {
		return driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[" + rowIndex + "]/td[3]")).getText();
	}

	public void selectCampaignCheckbox(int rowIndex) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[" + rowIndex + "]/td[1]/input")).click();
	}

	public void clickDeleteButton() {
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
	}

	public void acceptDeleteAlert() {
		driver.switchTo().alert().accept();
	}
}



