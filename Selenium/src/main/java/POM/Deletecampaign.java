

package POM;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deletecampaign {

	WebDriver driver;

	public Deletecampaign(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr")
	private List<WebElement> campaignRows;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;

	/**
	 * Method to delete campaign by name
	 */
	public boolean deleteCampaignByName(String campaignName) {
		boolean found = false;

		for (int i = 3; i < campaignRows.size(); i++) {
			WebElement nameCell = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[" + i + "]/td[3]"));

			if (nameCell.getText().equalsIgnoreCase(campaignName)) {
				found = true;

				// Click checkbox of the row
				WebElement checkbox = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[" + i + "]/td[1]/input[@type='checkbox']"));
				checkbox.click();

				// Click Delete
				deleteBtn.click();

				// Accept alert
				driver.switchTo().alert().accept();
				break;
			}
		}
		return found;
	}
}



