package crm_reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VeryLeadPage {
	public VeryLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastname;
	
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCompany() {
		return Company;
	}

	public WebElement getLeads() {
		return leads;
	}

	public WebElement getInd() {
		return Ind;
	}

	public WebElement getNum() {
		return Num;
	}

	@FindBy(id="dtlview_Company")
	private WebElement Company;
	
	@FindBy(id="dtlview_Lead Source")
	private WebElement leads;
	
	@FindBy(id="dtlview_Industry")
	private WebElement Ind;
	
	@FindBy(id="dtlview_Phone")
	private WebElement Num;
	

}
