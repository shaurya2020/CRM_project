package crm_reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy(linkText = "Organizations")
	private WebElement link;
	
	@FindBy(css = "[alt='Create Organization...']")
	private WebElement Css;
	
	@FindBy(name = "accountname")
	private WebElement accname;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "email1")
	private WebElement email;
	
	@FindBy(name = "industry")
	private WebElement Industry;
	
	@FindBy(name  = "accounttype")
	private WebElement accounttype;
	
	@FindBy(name = "button")
	private WebElement button;
	
	@FindBy( css = "img[src='themes/softed/images/user.PNG']")
	private WebElement pro;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SingnOut;
	
	
	
	public WebElement getSingnOut() {
		return SingnOut;
	}

	public WebElement getPro() {
		return pro;
	}

	public WebElement getLink() {
		return link;
	}

	public WebElement getCss() {
		return Css;
	}

	public WebElement getAccname() {
		return accname;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getIndustry() {
		return Industry;
	}

	public WebElement getAccounttype() {
		return accounttype;
	}

	public WebElement getButton() {
		return button;
	}
	

}
