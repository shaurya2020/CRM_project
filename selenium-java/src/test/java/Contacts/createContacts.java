package Contacts;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import crm_reop.ContactPage;
import crm_reop.LoginPage;
import crm_reop.SignOut;
import crm_reop.VeyContactPage;
import genric_utility.FileUtility;
import genric_utility.WebDriverUtility;

public class createContacts {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException, ParseException {
		
		
//		json
		String url = FileUtility.GetDataFJsonFile("url");
		String username = FileUtility.GetDataFJsonFile("un");
		String password = FileUtility.GetDataFJsonFile("pwd");
		
		
//		Excell data
		String LastName = FileUtility.GetDataExcellFile("Contact", 4, 0);
		String Email = FileUtility.GetDataExcellFile("Contact", 4, 4);
		String asi = FileUtility.GetDataExcellFile("Contact", 4, 2);
		
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//		String url = "http://localhost:8888/index.php";
		driver.get(url);
		
//		log in
		
		ContactPage ct = new ContactPage(driver);
		LoginPage lg = new LoginPage(driver);
		VeyContactPage vr = new VeyContactPage(driver);
//		WebElement user = driver.findElement(By.name("user_name"));
		WebElement user = lg.getusername();
		user.sendKeys(username);
		
//		WebElement pass = driver.findElement(By.name("user_password"));
		WebElement pass = lg.getPassword();		
		pass.sendKeys(password);
		
//		WebElement login = driver.findElement(By.id("submitButton"));
		WebElement login = lg.getbutton();
		login.click();
		
//		home
//		WebElement module = driver.findElement(By.linkText("Contacts"));
		WebElement module = ct.getLink();
		module.click();
		
//		WebElement addicon = driver.findElement(By.cssSelector("img[alt=\'Create Contact...\']"));
		WebElement addicon = ct.getAddicon();
		addicon.click();
		
		
//		WebElement lastname = driver.findElement(By.name("lastname"));
//		String LastName = "Khayu";
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
		
		String emp = "Employee";
//		WebElement ld = driver.findElement(By.name("leadsource"));
		WebElement ld = ct.getLead();
//		Selectsel nsel = new SelectSel
//		Select sel = new Select(ld);
//		sel.selectByValue("Employee");
		WebDriverUtility ns = new WebDriverUtility(driver);
		ns.select(ld, emp);

//		WebElement phone = driver.findElement(By.id("phone"));
		WebElement phone = ct.getPhone();
		phone.sendKeys("1234567892");

//		String Email ="ayush@gmail.com";
//		WebElement email = driver.findElement(By.id("email"));
		WebElement email = ct.getEmail();
		email.sendKeys(Email);
		
//		String asi = "Chota bhai";
//		WebElement assistant = driver.findElement(By.id("assistant"));
		WebElement assistant = ct.getAssitance();
		assistant.sendKeys(asi);
		
		String Dis ="its is done";
//		WebElement description = driver.findElement(By.name("description"));
		WebElement description = ct.getDescription();
		description.sendKeys(Dis);
		
		WebElement but = ct.getButton();
		but.click();
		
//		validation
		
//		String Vlastna = driver.findElement(By.id("dtlview_Last Name")).getText();
		String Vlastna = vr.getlastname().getText();
//		String VEmail = driver.findElement(By.id("dtlview_Email")).getText();
		String VEmail = vr.getEmail().getText();
//		String Vlead =driver.findElement(By.id("dtlview_Lead Source")).getText();
		String Vlead = vr.getLead().getText();
//		String VAssis = driver.findElement(By.id("dtlview_Assistant")).getText();
		String VAssis = vr.getAssis().getText();
//		String VDescrpt =driver.findElement(By.id("dtlview_Description")).getText();
		String VDescrpt =vr.getDiscript().getText();
		


		System.out.println("========== LAST NAME VERIFICATION ==========");
		System.out.println("Expected Result : " + LastName);
		System.out.println("Actual Result   : " + Vlastna);

		if (LastName.equals(Vlastna)) {
		    System.out.println("PASS : Last Name is matched");
		} else {
		    System.out.println("FAIL : Last Name is not matched");
		}

		System.out.println("\n========== EMAIL VERIFICATION ==========");
		System.out.println("Expected Result : " + Email);
		System.out.println("Actual Result   : " + VEmail);

		if (Email.equals(VEmail)) {
		    System.out.println("PASS : Email is matched");
		} else {
		    System.out.println("FAIL : Email is not matched");
		}

		System.out.println("\n========== LEAD SOURCE VERIFICATION ==========");
		System.out.println("Expected Result : " + emp);
		System.out.println("Actual Result   : " + Vlead);

		if (emp.equals(Vlead)) {
		    System.out.println("PASS : Lead Source is matched");
		} else {
		    System.out.println("FAIL : Lead Source is not matched");
		}

		System.out.println("\n========== ASSISTANT VERIFICATION ==========");
		System.out.println("Expected Result : " + asi);
		System.out.println("Actual Result   : " + VAssis);

		if (asi.equals(VAssis)) {
		    System.out.println("PASS : Assistant is matched");
		} else {
		    System.out.println("FAIL : Assistant is not matched");
		}


		System.out.println("\n========== DESCRIPTION VERIFICATION ==========");
		System.out.println("Expected Result : " + Dis);
		System.out.println("Actual Result   : " + VDescrpt);

		if (Dis.equals(VDescrpt)) {
		    System.out.println("PASS : Description is matched");
		} else {
		    System.out.println("FAIL : Description is not matched");
		}
		
//		WebElement profile = driver.findElement(By.cssSelector("[src=\'themes/softed/images/user.PNG\']"));
		SignOut sn = new SignOut(driver);
		WebElement profile = sn.getPro();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.hover(profile);

//		driver.findElement(By.linkText("Sign Out")).click();
		WebElement Out = sn.getSingnOut();
		Out.click();

		Thread.sleep(1000);
		driver.quit();

	}

}
