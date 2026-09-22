package crm_reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VeryOrgPage {
	public VeryOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgname;


	@FindBy(id = "dtlview_Phone")
	private WebElement phone;
	
	@FindBy(id = "dtlview_Email")
	private WebElement email;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industery;
	
	@FindBy(id = "dtlview_Type")
	private WebElement Type;
	
	
	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getIndustery() {
		return industery;
	}

	public WebElement getType() {
		return Type;
	}

	
}
