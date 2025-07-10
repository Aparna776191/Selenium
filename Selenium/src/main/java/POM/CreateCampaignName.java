package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCampaignName {

	WebDriver driver;

	public CreateCampaignName(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Campaign name input
	@FindBy(name = "campaignname")
	private WebElement campaignNameInput;

	// Product select button
	@FindBy(xpath = "//img[@title='Select']") // Update this if locator is different
	private WebElement selectProductBtn;

	// Save campaign button
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	// Campaign header text (after creation)
	@FindBy(xpath = "//span[@id='dtlview_Campaign_Name']")
	private WebElement campaignHeaderText;


	// --- Business logic methods ---

	public void enterCampaignName(String name) {
		campaignNameInput.sendKeys(name);
	}

	public void clickSelectProduct() {
		selectProductBtn.click();
	}

	public void clickSave() {
		saveButton.click();
	}

	public void entercampaignAndSave(String name) {
		campaignNameInput.sendKeys(name);
		saveButton.click();
	}

	public String getCampaignHeaderText() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(campaignHeaderText));
	    return campaignHeaderText.getText();
	}


	// --- Switch to child window and select product ---
	public void selectProductFromPopup(String productName, WebDriver driver) {
		// Switch to child window
		for (String win : driver.getWindowHandles()) {
			driver.switchTo().window(win);
		}
		// Enter product name and search
		driver.findElement(By.name("search_text")).sendKeys(productName);
		driver.findElement(By.name("search")).click();

		// Click the product link
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();

		// Switch back to main window
		for (String win : driver.getWindowHandles()) {
			driver.switchTo().window(win);
		}
	}
}
