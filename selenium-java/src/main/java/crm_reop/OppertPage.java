package crm_reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppertPage {
	public OppertPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy()
	private WebElement name;
	

}
