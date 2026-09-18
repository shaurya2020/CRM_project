package Object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoPage {
	
	public SauceDemoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	declaration
	@FindBy(id = "user-name")
	private WebElement usernameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login-button")
	private WebElement loginButton;
	
public WebElement getUsernameField() {
	return usernameField;
}
	
	public WebElement getPasswordField() {
		return passwordField;
}
		
		public WebElement getloginButton() {
			return loginButton;
}
		@FindBy(id = "add-to-cart-sauce-labs-backpack" )
		private WebElement addTocartButton;
		
		public WebElement getAddTocartButton() {
			return addTocartButton;
		}
}