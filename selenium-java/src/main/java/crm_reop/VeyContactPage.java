package crm_reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VeyContactPage {
	public VeyContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastname;
	
	
		@FindBy(id = "dtlview_Email")
		private WebElement Email;
		
		@FindBy(id = "dtlview_Lead Source")
		private WebElement lead;
		
		@FindBy(id = "dtlview_Assistant")
		private WebElement Assis;
		
		@FindBy(id = "dtlview_Description")
		private WebElement Discript;

		public WebElement getEmail() {
			return Email;
		}

		public WebElement getLead() {
			return lead;
		}

		public WebElement getAssis() {
			return Assis;
		}

		public WebElement getDiscript() {
			return Discript;
		}
		public WebElement getlastname() {
			return lastname;
			
	}
	
	
}
