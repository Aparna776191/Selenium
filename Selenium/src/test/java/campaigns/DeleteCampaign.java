package campaigns;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Gneric_Utilities.Baseclasstest;
import Gneric_Utilities.Excel_Utilities;
import POM.CampaignsPage;
import POM.HomePage;

public class DeleteCampaign extends Baseclasstest {

    @Test
    public void deleteCampaign() throws Exception {

        // Navigate to Campaigns
        HomePage home = new HomePage(driver);
       
        home.clickCampaignsLink(driver);

        // Load Excel (multiple columns per row)
        Excel_Utilities excel = new Excel_Utilities();
        List<List<String>> campaignList = excel.getMultipleColumns("./src/test/resources/Campaigns.xlsx", "Sheet1");

        // Create CampaignsPage POM
        CampaignsPage campaignPage = new CampaignsPage(driver);

        // Loop and delete each campaign
        for (List<String> row : campaignList) {
            String campaignName = row.get(0);  // get campaign name from first column
            boolean found = false;

            List<WebElement> rows = campaignPage.getAllCampaignRows();
            for (int i = 3; i < rows.size(); i++) {
                String currentCampaign = campaignPage.getCampaignNameByRow(i);

                if (currentCampaign.equalsIgnoreCase(campaignName.trim())) {
                    found = true;
                    campaignPage.selectCampaignCheckbox(i);
                    campaignPage.clickDeleteButton();
                    campaignPage.acceptDeleteAlert();
                    System.out.println("✅ Deleted campaign: " + campaignName);
                    break;
                }
            }

            if (!found) {
                System.out.println("❌ Campaign not found: " + campaignName);
            }

            // Reload page for next deletion
            
            home.clickCampaignsLink(driver);
        }
        home.logoutApp();
        driver.quit();
    }
}
