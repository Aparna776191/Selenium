package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LookUpImgPage {
	
	WebDriver driver;

    @FindBy(css = "[title='Create Campaign...']")
    private WebElement campaignLookUp;

    @FindBy(css = "[title='Create Product...']")
    private WebElement productLookUp;

    @FindBy(css = "[title='Create Contact...']")
    private WebElement contactLookUp;

    public LookUpImgPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCampaignLookUp() {
        return campaignLookUp;
    }

    public WebElement getProductLookUp() {
        return productLookUp;
    }

    public WebElement getContactLookUp() {
        return contactLookUp;
    }

    // Reusable business logic methods
    public void clickCampaignLookUp() {
        campaignLookUp.click();
    }

    public void clickProductLookUp() {
        productLookUp.click();
    }

    public void clickContactLookUp() {
        contactLookUp.click();
    }
}
