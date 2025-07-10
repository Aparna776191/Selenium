package campaigns;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Gneric_Utilities.Base_Class;
import Gneric_Utilities.Baseclasstest;
import Gneric_Utilities.Excel_Utilities;
import POM.CreateCampaignName;
import POM.HomePage;
import POM.LookUpImgPage;

//@Listeners(Gneric_Utilities.ListenerImp.class)
@Listeners(Gneric_Utilities.ExtendReports.class)
public class CreateCamp1 extends Baseclasstest {

    @Test(retryAnalyzer = Gneric_Utilities.Retryanalyzer.class)
    public void createCampaign() throws Throwable {

        // Step 1: Read Excel Data
        Excel_Utilities excel = new Excel_Utilities();
        List<List<String>> data = excel.getMultipleColumns("./src/test/resources/Campaigns.xlsx", "Sheet1");

        HomePage home = new HomePage(driver);

        for (List<String> row : data) {
            String campaignName = row.get(0);

            // Step 2: Navigate to Campaign Creation
            home.clickCampaignsLink(driver);

            LookUpImgPage lookup = new LookUpImgPage(driver);
            lookup.clickCampaignLookUp();

            CreateCampaignName campaign = new CreateCampaignName(driver);
            campaign.enterCampaignName(campaignName);
            campaign.clickSave();

            // Step 3: Validation
          
            String actual = campaign.getCampaignHeaderText();

            if (actual != null && actual.contains(campaignName)) {
                System.out.println("✅ Campaign created and validated: " + campaignName);
            } else {
                System.out.println("❌ Header not found or doesn't match:");
                System.out.println("   ➤ Actual header: " + actual);
                System.out.println("   ➤ Expected campaign name: " + campaignName);
                Assert.fail("❌ Campaign header is null or doesn't match expected name.");
            }

            Base_Class base =new Base_Class();
            base.takeScreenShotEx(driver, "CreateCampaignFail");
           // Assert.assertTrue(actual.contains(campaignName), "❌ Campaign name mismatch");

            System.out.println("✅ Campaign created successfully: " + campaignName);
        }

        // Step 4: Logout and Quit (after all campaigns are created)
        
        home.logoutApp();
        driver.quit();
    }

   
}
    
   

