package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	//@FindBy -Selenium annotation used in the Page Object Model (POM) to locate web elements. 
	
	@FindBy(name="user_name")
	private WebElement usernameField;
	
	@FindBy(name="user_password")
	private WebElement passwordField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	

	
	
	
	public Login(WebDriver driver){ // object creation
		PageFactory.initElements(driver, this);   //it will search for all the elements
	}
	
	public void logintoApp(String username,String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	
}
