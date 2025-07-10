package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "More")
    private WebElement moreLink;

    @FindBy(linkText = "Campaigns")
    private WebElement campaignsLink;

    @FindBy(linkText = "Organizations")
    private WebElement orgLink;

    @FindBy(linkText = "Products")
    private WebElement prdLink;

    @FindBy(linkText = "Contacts")
    private WebElement contactLink;

    @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement AdmLink;

    @FindBy(linkText = "Sign Out")
    private WebElement signOutLink;

    public void clickCampaignsLink(WebDriver driver) {
        moreLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(campaignsLink));

        campaignsLink.click();
    }

    public void clickOrgLink() {
        orgLink.click();
    }

    public void clickProductLink() {
        prdLink.click();
    }

    public void clickContactLink() {
        contactLink.click();
    }

    public void logoutApp() {
        AdmLink.click();
        signOutLink.click();
    }

    
}
