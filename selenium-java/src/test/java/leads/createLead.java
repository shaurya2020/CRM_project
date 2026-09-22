package leads;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import crm_reop.Leadspage;
import crm_reop.LoginPage;
import crm_reop.SignOut;
import crm_reop.VeryLeadPage;
import genric_utility.FileUtility;
import genric_utility.WebDriverUtility;


public class createLead {

	public static void main(String[] args) throws IOException, ParseException {   
		
//		json
		String url = FileUtility.GetDataFJsonFile("url");
		String username = FileUtility.GetDataFJsonFile("un");
		String password = FileUtility.GetDataFJsonFile("pwd");
		
//		fetch data from Excell
		
		String LastName = FileUtility.GetDataExcellFile("Lead", 4, 0);
		String CompanyName = FileUtility.GetDataExcellFile("Lead", 4, 1);
//		String Emp = FileUtility.GetDataExcellFile("Lead", 2, 3);
//		String IndSel = FileUtility.GetDataExcellFile("Lead", 2, 4);
		String Emp = "Employee";
		String IndSel = "Education";
		String Num = FileUtility.GetDataExcellFile("Lead", 4, 4);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);

//		log in
		
		LoginPage Lg = new LoginPage(driver);
		
		
//		driver.findElement(By.name("user_name")).sendKeys(username);
		WebElement userName = Lg.getusername();
		userName.sendKeys(username);
		
//		driver.findElement(By.name("user_password")).sendKeys(password);
		WebElement Password = Lg.getPassword();
		Password.sendKeys(password);
		
//		driver.findElement(By.cssSelector("[id='submitButton']")).click();
		WebElement button = Lg.getbutton();
		button.click();
		
//		main
		
		Leadspage lp = new Leadspage(driver);
//		WebElement module = driver.findElement(By.linkText("Leads"));
		WebElement module = lp.getModule();
		module.click();

//		WebElement mod = driver.findElement(By.cssSelector("img[alt='Create Lead...']"));
		WebElement mod = lp.getMod();
		mod.click();
		
//		String LastName = "Khayu";
//		WebElement lastname = driver.findElement(By.name("lastname"));
		WebElement lastname = lp.getLastname();
		lastname.sendKeys(LastName);
		
//		WebElement Company = driver.findElement(By.name("company"));
		WebElement Company = lp.getCompany();
		Company.sendKeys(CompanyName);
		
//		String Emp = "Employee";
//		WebElement lead = driver.findElement(By.name("leadsource"));
		WebElement lead = lp.getLead();
//		Select As = new Select(lead);
//		As.selectByValue("Employee");
		WebDriverUtility lsp = new WebDriverUtility(driver);
		lsp.select(lead, Emp);
		
//		String IndSel = "Communications";
//		WebElement Ind = driver.findElement(By.name("industry"));
		WebElement Ind = lp.getInd();
//		Select sel = new Select(Ind);
//		sel.selectByValue(IndSel);
		lsp.select(Ind, IndSel);
		
//		String Num = "91405056";
//		WebElement Phone = driver.findElement(By.id("phone"));
		WebElement Phone = lp.getPhone();
		Phone.sendKeys(Num);
		
		
//		driver.findElement(By.name("button")).click();
		WebElement butt = lp.getButt();
		butt.click();
		
//		Validation
		VeryLeadPage vlp = new VeryLeadPage(driver);
		
//		String VLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		String VLastName = vlp.getLastname().getText();
//		String Vcompaney = driver.findElement(By.id("dtlview_Company")).getText();
		String Vcompaney = vlp.getCompany().getText();
//		String VleadS = driver.findElement(By.id("dtlview_Lead Source")).getText();
		String VleadS = vlp.getLeads().getText();
//		String VInd = driver.findElement(By.id("dtlview_Industry")).getText();
		String VInd = vlp.getInd().getText();
//		String VNum = driver.findElement(By.id("dtlview_Phone")).getText();
		String VNum = vlp.getNum().getText();

		System.out.println("====================");
		System.out.println("Expected Result : " + LastName);
		System.out.println("Actual Result   : " + VLastName);

		if (LastName.equals(VLastName)) {
		    System.out.println("PASS : Last Name is matched");
		} else {
		    System.out.println("FAIL : Last Name is not matched");
		}

		System.out.println("\n====================");
		System.out.println("Expected Result : " + CompanyName);
		System.out.println("Actual Result   : " + Vcompaney);

		if (CompanyName.equals(Vcompaney)) {
		    System.out.println("PASS : companey is matched");
		} else {
		    System.out.println("FAIL : companey is not matched");
		}

		System.out.println("\n====================");
		System.out.println("Expected Result : " + Emp);
		System.out.println("Actual Result   : " + VleadS);

		if (Emp.equals(VleadS)) {
		    System.out.println("PASS : Lead Source is matched");
		} else {
		    System.out.println("FAIL : Lead Source is not matched");
		}

		System.out.println("\n====================");
		System.out.println("Expected Result : " + IndSel);
		System.out.println("Actual Result   : " + VInd);

		if (IndSel.equals(VInd)) {
		    System.out.println("PASS : Indstry is matched");
		} else {
		    System.out.println("FAIL : Indstry is not matched");
		}
		
		System.out.println("\n========== DESCRIPTION VERIFICATION ==========");
		System.out.println("Expected Result : " + Num);
		System.out.println("Actual Result   : " + VNum);

		if (Num.equals(VNum)) {
		    System.out.println("PASS : Num is matched");
		} else {
		    System.out.println("FAIL : Num is not matched");
		}
		
		SignOut sn = new SignOut(driver);
//		WebElement profile = driver.findElement(	By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"));
//		Actions act = new Actions(driver);
//		act.moveToElement(profile).build().perform();
		WebElement profile = sn.getPro();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.hover(profile);

//		driver.findElement(By.linkText("Sign Out")).click();
		WebElement Out = sn.getSingnOut();
		Out.click();

		driver.quit();
	}
	

}
    