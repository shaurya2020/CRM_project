package crm_reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leadspage {
	public Leadspage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Leads")
	private WebElement module;
	
	public WebElement getModule() {
		return module;
	}

	public WebElement getMod() {
		return mod;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getLead() {
		return lead;
	}

	public WebElement getInd() {
		return lnd;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getButt() {
		return butt;
	}

	@FindBy(css="img[alt='Create Lead...']")
	private WebElement mod;
	
	@FindBy(name ="lastname")
	private WebElement lastname;
	
	@FindBy(name="company")
	private WebElement company;
	
	@FindBy(name="leadsource")
	private WebElement lead;
	
	@FindBy(name="industry")
	private WebElement lnd;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(name="button")
	private WebElement butt;

}
