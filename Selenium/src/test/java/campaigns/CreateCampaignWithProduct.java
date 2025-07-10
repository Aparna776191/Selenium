package campaigns;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Gneric_Utilities.Baseclasstest;
import Gneric_Utilities.Excel_Utilities;
import POM.CreateCampaignName;
import POM.HomePage;
import POM.LookUpImgPage;
import POM.ProductCreationPage;

@Listeners(Gneric_Utilities.ListenerImp.class)
public class CreateCampaignWithProduct extends Baseclasstest {

    @Test(retryAnalyzer = Gneric_Utilities.Retryanalyzer.class)
    public void createCampaignsWithProducts() throws Exception {
        // Read Excel Data (campaign name and product name)
        Excel_Utilities excel = new Excel_Utilities();
        List<List<String>> data = excel.getMultipleColumns("./src/test/resources/Campaigns.xlsx", "Sheet1");

        HomePage home = new HomePage(driver);

        for (List<String> row : data) {
            String campaignName = row.get(0);
            String productName = row.get(1);

            // Step 1: Create Product
            home.clickProductLink();
            ProductCreationPage productPage = new ProductCreationPage(driver);
            productPage.createProduct(productName);

            // Step 2: Create Campaign with Product
            
            home.clickCampaignsLink(driver);

            LookUpImgPage lookup = new LookUpImgPage(driver);
            lookup.clickCampaignLookUp();

            CreateCampaignName campaign = new CreateCampaignName(driver);
            campaign.enterCampaignName(campaignName);
            campaign.clickSelectProduct();
            campaign.selectProductFromPopup(productName, driver);
            campaign.clickSave();

            // Step 3: Assertion
            String actual = campaign.getCampaignHeaderText();
           // Assert.assertEquals(actual.trim(), campaignName.trim(), "❌ Campaign name mismatch");

            System.out.println("✅ Campaign created with product: " + campaignName);
        }
         home.logoutApp();
         driver.quit();
    }
}
