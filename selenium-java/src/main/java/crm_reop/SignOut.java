package crm_reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOut {
     public SignOut(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
      	@FindBy( css = "img[src='themes/softed/images/user.PNG']")
      	private WebElement pro;                                   
      	                                                          
    	@FindBy(linkText = "Sign Out")                            
      	private WebElement SingnOutE;

		public WebElement getPro() {
			return pro;
		}

		public WebElement getSingnOut() {
			return SingnOutE;
		}                              
}

