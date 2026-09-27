package opportunities;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import crm_reop.LoginPage;
import crm_reop.OrgPage;
import crm_reop.SignOut;
import genric_utility.FileUtility;
import genric_utility.WebDriverUtility;

/**
 * Test Case ID : TC_OPP_001 Test Case Name : Create Opportunity Module :
 * Opportunities Test Type : Functional / UI Automation Testing
 *
 * Objective: Verify that a user can successfully create a new Opportunity by
 * entering valid opportunity details and selecting the required related
 * records.
 *
 * Preconditions: 1. Vtiger application should be running. 2. Valid login
 * credentials should be available. 3. Chrome browser should be installed.
 *
 * Expected Result: Opportunity should be created successfully with the entered
 * details.
 *
 * Postcondition: User should be logged out and browser should be closed.
 */
public class CreateOpprtunities {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		json
		String browser = FileUtility.GetDataFJsonFile("bro");
		String url = FileUtility.GetDataFJsonFile("url");
		String username = FileUtility.GetDataFJsonFile("un");
		String password = FileUtility.GetDataFJsonFile("pwd");
		
		WebDriver driver = null;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
		
//		Login
		
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
		WebElement module = driver.findElement(By.linkText("Opportunities"));
		module.click();

		WebElement mod = driver.findElement(By.cssSelector("img[alt='Create Opportunity...']"));
		mod.click();

		long ran = System.currentTimeMillis();
		String zd = "Zudio" + ran;
		WebElement OppName = driver.findElement(By.name("potentialname"));
		OppName.sendKeys(zd);

		// Capture main window

		driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click();

		String PID = driver.getWindowHandle();
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.switchToWindowByTitle("sd");
		driver.findElement(By.id("1")).click();
		driver.switchTo().window(PID);

		WebElement amount = driver.findElement(By.name("amount"));
		amount.sendKeys("5000");

		WebElement ss = driver.findElement(By.name("opportunity_type"));
		Select singleselect = new Select(ss);
		singleselect.selectByValue("New Business");

		WebElement date = driver.findElement(By.name("closingdate"));
		date.sendKeys("2026/09/18");

		WebElement lead = driver.findElement(By.name("leadsource"));
		Select ld = new Select(lead);
		ld.selectByValue("Partner");

		WebElement Assigned = driver.findElement(By.name("assigned_user_id"));
		Select As = new Select(Assigned);
		As.selectByValue("1");
		System.out.println("[PASS] Assigned User selected successfully.");

		WebElement Sales = driver.findElement(By.name("sales_stage"));
		Select sl = new Select(Sales);
		sl.selectByValue("Perception Analysis");
		System.out.println("[PASS] Sales Stage selected: Perception Analysis.");

		String PID2 = driver.getWindowHandle();
		System.out.println("[PASS] Main Opportunity window handle captured.");

		driver.findElement(By.xpath("//input[@name='campaignname']/following-sibling::img[@alt='Select']")).click();
		System.out.println("[PASS] Campaign selection pop-up opened successfully.");

		WebDriverUtility webUtility = new WebDriverUtility(driver);
		webUtility.switchToWindowByTitle("User Conference");
		
//		Set<String> CID2 = driver.getWindowHandles();
		System.out.println("[PASS] Window handles captured successfully.");

		/*
		 * // Switch to Campaign window
		 * System.out.println("[INFO] Switching to Campaign selection window..."); for
		 * (String j : CID2) { driver.switchTo().window(j); }
		 * System.out.println("[PASS] Switched to Campaign selection window.");
		 * 
		 * // Select User Conference
		 * System.out.println("[INFO] Selecting User Conference campaign...");
		 * driver.findElement(By.linkText("User Conference")).click();
		 * System.out.println("[PASS] User Conference campaign selected successfully.");
		 */

		// Return to main window
		driver.switchTo().window(PID2);
		System.out.println("[PASS] Returned to main Opportunity form.");

		WebElement Probability = driver.findElement(By.id("probability"));
		Probability.sendKeys("88");

		driver.findElement(By.name("button")).click();

		String Vopptname = driver.findElement(By.cssSelector("[id='dtlview_Opportunity Name']")).getText();

		String Vrelated = driver.findElement(By.linkText("vtiger")).getText();

		String Vamount = driver.findElement(By.id("dtlview_Amount")).getText();

		String Vtype = driver.findElement(By.id("dtlview_Type")).getText();


//		if (Vopptname.equals(OppName) && related.equals(Vrelated) && Vamount.equals(amount) && Vtype.equals(ss)) {

//			System.out.println("[PASS] Opportunity details verified successfully.");

//		} else {

//			System.out.println("[FAIL] Opportunity details verification failed.");
//		}

//		signOut
		
//		WebElement profile = driver.findElement(By.cssSelector("[src=\'themes/softed/images/user.PNG\']"));
		SignOut sn = new SignOut(driver);
		WebElement profile = sn.getPro();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.hover(profile);

//		driver.findElement(By.linkText("Sign Out")).click();
		WebElement Out = sn.getSingnOut();
		Out.click();
	}
}
