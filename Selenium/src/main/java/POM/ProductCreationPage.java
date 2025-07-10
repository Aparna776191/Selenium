
	
	package POM;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ProductCreationPage {

	    @FindBy(linkText = "Products")
	    private WebElement productLink;

	    @FindBy(css = "img[title='Create Product...']")
	    private WebElement createProductIcon;

	    @FindBy(name = "productname")
	    private WebElement productNameField;

	    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	    private WebElement saveButton;
	    
	    @FindBy(name="search_text")
	    private WebElement searchButton;
	    
	    @FindBy(name="search")
	    private WebElement search;
	    
	   
	    

	    public ProductCreationPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    public void createProduct(String productName) {
	        productLink.click();
	        createProductIcon.click();
	        productNameField.sendKeys(productName);
	        saveButton.click();
	    }
	    public void searchAndSelectProduct(String productName) {
	    	searchButton.sendKeys(productName);
	    	search.click();
	    	productLink.click();
	    }

		public String getProductHeaderText() {
			// TODO Auto-generated method stub
			return null;
		}
	}



