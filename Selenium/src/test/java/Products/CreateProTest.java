package Products;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import Gneric_Utilities.Baseclasstest;
import Gneric_Utilities.Excel_Utilities;
import POM.HomePage;
import POM.ProductCreationPage;


public class CreateProTest extends Baseclasstest {

    @Test(groups = "smoketest")
    public void createProductTest() throws IOException, Exception {
    	
    	//HI -- branch1
    

        // Navigate to Product Page
        HomePage homepage = new HomePage(driver);
        homepage.clickProductLink();

        // Load Excel Data
        Excel_Utilities excel = new Excel_Utilities();
        List<List<String>> productList = excel.getMultipleColumns("./src/test/java/Flipkart.xlsx", "Sheet1");

        // Loop through each product
        for (List<String> row : productList) {
            String productName = row.get(0); // Assuming product name is in first column

            // Create product
            ProductCreationPage productPage = new ProductCreationPage(driver);
            productPage.createProduct(productName);

            // Validate header
            String actualHeader = productPage.getProductHeaderText();
            if (actualHeader.contains(productName)) {
                System.out.println("✅ Product created successfully: " + productName);
            } else {
                System.out.println("❌ Product creation failed: " + productName);
            }

            // Go back to product page for next creation
            homepage.clickProductLink();
        }
    }
}
