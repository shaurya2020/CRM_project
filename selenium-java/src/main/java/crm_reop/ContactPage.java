package crm_reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	public ContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	public WebElement getLink() {
		return link;
	}

	public WebElement getAddicon() {
		return Addicon;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getLead() {
		return lead;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getAssitance() {
		return assitance;
	}

	public WebElement getDescription() {
		return description;
	}
	@FindBy(linkText = "Contacts")
	private WebElement link;
	
	@FindBy(css= "img[alt='Create Contact...']")
	private WebElement Addicon;
	
	@FindBy(name = "lastname")
	private WebElement lastname;
	
	@FindBy(name = "leadsource")
	private WebElement lead;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "assistant")
	private WebElement assitance;
	
	@FindBy(name = "description")
	private WebElement description;
	
	@FindBy(name = "button")
	private WebElement button;

	public WebElement getButton() {
		return button;
	}
	
	
	
	

}
