package Contacts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import crm_reop.ContactPage;
import crm_reop.LoginPage;
import genric_utility.WebDriverUtility;

public class createContacts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String url = "http://localhost:8888/index.php";
		driver.get(url);
		
//		log in
		
		ContactPage ct = new ContactPage(driver);
		LoginPage lg = new LoginPage(driver);
//		WebElement user = driver.findElement(By.name("user_name"));
		WebElement user = lg.getusername();
		user.sendKeys("admin");
		
//		WebElement pass = driver.findElement(By.name("user_password"));
		WebElement pass = lg.getPassword();		
		pass.sendKeys("manager");
		
//		WebElement login = driver.findElement(By.id("submitButton"));
		WebElement login = lg.getbutton();
		login.click();
		
		
//		WebElement module = driver.findElement(By.linkText("Contacts"));
		WebElement module = ct.getLink();
		module.click();
		
//		WebElement addicon = driver.findElement(By.cssSelector("img[alt=\'Create Contact...\']"));
		WebElement addicon = ct.getAddicon();
		addicon.click();
		
		
//		WebElement lastname = driver.findElement(By.name("lastname"));
		String LastName = "Khayu";
		WebElement lastname = ct.getLastname();
		lastname.sendKeys(LastName);
		
//		PPopups
		String PID2 = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
		
		Set<String> CID2 = driver.getWindowHandles();
		
		for (String i : CID2) {
			driver.switchTo().window(i);
		}
		
		driver.findElement(By.id("3")).click();
		Thread.sleep(2000);
		
		driver.switchTo().window(PID2);
		
		
//		WebElement ld = driver.findElement(By.name("leadsource"));
		WebElement ld = ct.getLead();
		WebDriverUtility ns = new WebDriverUtility(driver);
		ns.select(ld, "Employee");
//		Selectsel nsel = new SelectSel
//		Select sel = new Select(ld);
//		sel.selectByValue("Employee");

//		WebElement phone = driver.findElement(By.id("phone"));
		WebElement phone = ct.getPhone();
		phone.sendKeys("1234567892");

		String Email ="ayush@gmail.com";
//		WebElement email = driver.findElement(By.id("email"));
		WebElement email = ct.getEmail();
		email.sendKeys(Email);
		
		
//		WebElement assistant = driver.findElement(By.id("assistant"));
		WebElement assistant = ct.getAssitance();
		assistant.sendKeys("Chota bhai");
	
//		WebElement description = driver.findElement(By.name("description"));
		WebElement description = ct.getDescription();
		description.sendKeys("its is done");
		
		WebElement but = ct.getButton();
		but.click();
		

		Thread.sleep(12000);
//		driver.quit();

	}

}
