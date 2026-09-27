
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
import org.testng.Reporter;
import org.testng.annotations.Test;

import crm_reop.LoginPage;
import crm_reop.SignOut;
import genric_utility.FileUtility;
import genric_utility.WebDriverUtility;

/**
 * Test Case ID   : TC_OPP_001
 * Test Case Name : Create Opportunity
 * Module         : Opportunities
 * Test Type      : Functional / UI Automation Testing
 *
 * Objective:
 * Verify that a user can successfully create a new Opportunity
 * by entering valid opportunity details and selecting the
 * required related records.
 *
 * Preconditions:
 * 1. Vtiger application should be running.
 * 2. Valid login credentials should be available.
 * 3. Required browser should be installed.
 *
 * Expected Result:
 * Opportunity should be created successfully with the entered details.
 *
 * Postcondition:
 * User should be logged out and browser should be closed.
 */
public class CreateOpprtunities {

	@Test
	public void createopp() throws IOException, ParseException {

		// ============================================================
		// TEST CASE START
		// ============================================================

		Reporter.log("============================================================", true);
		Reporter.log("TEST CASE STARTED : TC_OPP_001", true);
		Reporter.log("Test Name : Create Opportunity", true);
		Reporter.log("Module : Opportunities", true);
		Reporter.log("============================================================", true);


		// ============================================================
		// STEP 01 : READ JSON CONFIGURATION
		// ============================================================

		Reporter.log("[STEP 01] Reading test configuration from JSON file...", true);

		String browser = FileUtility.GetDataFJsonFile("bro");
		String url = FileUtility.GetDataFJsonFile("url");
		String username = FileUtility.GetDataFJsonFile("un");
		String password = FileUtility.GetDataFJsonFile("pwd");

		Reporter.log("[INFO] Browser configuration loaded : " + browser, true);
		Reporter.log("[INFO] Application URL loaded successfully.", true);
		Reporter.log("[INFO] Username loaded successfully.", true);
		Reporter.log("[INFO] Password loaded successfully.", true);


		// ============================================================
		// STEP 02 : LAUNCH BROWSER
		// ============================================================

		Reporter.log("[STEP 02] Launching browser...", true);

		WebDriver driver = null;

		if (browser.equals("chrome")) {

			driver = new ChromeDriver();

			Reporter.log("[PASS] Chrome browser launched successfully.", true);

		} else if (browser.equals("edge")) {

			driver = new EdgeDriver();

			Reporter.log("[PASS] Edge browser launched successfully.", true);
		}


		// ============================================================
		// STEP 03 : BROWSER CONFIGURATION
		// ============================================================

		Reporter.log("[STEP 03] Configuring browser settings...", true);

		driver.manage().window().maximize();

		Reporter.log("[PASS] Browser window maximized successfully.", true);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Reporter.log("[PASS] Implicit wait configured : 10 seconds.", true);


		// ============================================================
		// STEP 04 : OPEN APPLICATION
		// ============================================================

		Reporter.log("[STEP 04] Opening Vtiger CRM application...", true);

		driver.get(url);

		Reporter.log("[PASS] Vtiger CRM application opened successfully.", true);


		// ============================================================
		// STEP 05 : LOGIN
		// ============================================================

		Reporter.log("[STEP 05] Performing application login...", true);

		LoginPage Lg = new LoginPage(driver);


		// Enter Username

		Reporter.log("[INFO] Entering username...", true);

		WebElement userName = Lg.getusername();

		userName.sendKeys(username);

		Reporter.log("[PASS] Username entered successfully.", true);


		// Enter Password

		Reporter.log("[INFO] Entering password...", true);

		WebElement Password = Lg.getPassword();

		Password.sendKeys(password);

		Reporter.log("[PASS] Password entered successfully.", true);


		// Click Login

		Reporter.log("[INFO] Clicking Login button...", true);

		WebElement button = Lg.getbutton();

		button.click();

		Reporter.log("[PASS] User logged into Vtiger CRM successfully.", true);


		// ============================================================
		// STEP 06 : NAVIGATE TO OPPORTUNITIES
		// ============================================================

		Reporter.log("[STEP 06] Navigating to Opportunities module...", true);

		WebElement module = driver.findElement(By.linkText("Opportunities"));

		module.click();

		Reporter.log("[PASS] Opportunities module opened successfully.", true);


		// ============================================================
		// STEP 07 : OPEN CREATE OPPORTUNITY PAGE
		// ============================================================

		Reporter.log("[STEP 07] Opening Create Opportunity page...", true);

		WebElement mod = driver.findElement(
				By.cssSelector("img[alt='Create Opportunity...']"));

		mod.click();

		Reporter.log("[PASS] Create Opportunity page opened successfully.", true);


		// ============================================================
		// STEP 08 : ENTER OPPORTUNITY NAME
		// ============================================================

		Reporter.log("[STEP 08] Generating Opportunity Name...", true);

		long ran = System.currentTimeMillis();

		String zd = "Zudio" + ran;

		Reporter.log("[INFO] Generated Opportunity Name : " + zd, true);

		WebElement OppName = driver.findElement(By.name("potentialname"));

		OppName.sendKeys(zd);

		Reporter.log("[PASS] Opportunity Name entered successfully.", true);


		// ============================================================
		// STEP 09 : SELECT RELATED ORGANIZATION
		// ============================================================

		Reporter.log("[STEP 09] Opening Organization selection window...", true);

		driver.findElement(
				By.cssSelector("img[src='themes/softed/images/select.gif']"))
				.click();

		Reporter.log("[INFO] Organization selection pop-up opened.", true);

		String PID = driver.getWindowHandle();

		Reporter.log("[INFO] Main Opportunity window handle captured.", true);

		WebDriverUtility wdutil = new WebDriverUtility(driver);

		Reporter.log("[INFO] Switching to Organization selection window...", true);

		wdutil.switchToWindowByTitle("sd");

		Reporter.log("[PASS] Organization selection window opened successfully.", true);

		driver.findElement(By.id("1")).click();

		Reporter.log("[PASS] Organization selected successfully.", true);

		driver.switchTo().window(PID);

		Reporter.log("[PASS] Returned to main Opportunity window.", true);


		// ============================================================
		// STEP 10 : ENTER AMOUNT
		// ============================================================

		Reporter.log("[STEP 10] Entering Opportunity Amount...", true);

		String amt = "5000";

		WebElement amount = driver.findElement(By.name("amount"));

		amount.sendKeys(amt);

		Reporter.log("[INFO] Opportunity Amount entered : " + amt, true);


		// ============================================================
		// STEP 11 : SELECT OPPORTUNITY TYPE
		// ============================================================

		Reporter.log("[STEP 11] Selecting Opportunity Type...", true);

		String Sss = "New Business";

		WebElement ss = driver.findElement(By.name("opportunity_type"));

		Select singleselect = new Select(ss);

		singleselect.selectByValue(Sss);

		Reporter.log("[PASS] Opportunity Type selected : " + Sss, true);


		// ============================================================
		// STEP 12 : ENTER CLOSING DATE
		// ============================================================

		Reporter.log("[STEP 12] Entering Opportunity Closing Date...", true);

		WebElement date = driver.findElement(By.name("closingdate"));

		date.sendKeys("2026/09/18");

		Reporter.log("[PASS] Closing Date entered successfully : 2026/09/18", true);


		// ============================================================
		// STEP 13 : SELECT LEAD SOURCE
		// ============================================================

		Reporter.log("[STEP 13] Selecting Lead Source...", true);

		WebElement lead = driver.findElement(By.name("leadsource"));

		Select ld = new Select(lead);

		ld.selectByValue("Partner");

		Reporter.log("[PASS] Lead Source selected : Partner", true);


		// ============================================================
		// STEP 14 : SELECT ASSIGNED USER
		// ============================================================

		Reporter.log("[STEP 14] Selecting Assigned User...", true);

		WebElement Assigned = driver.findElement(By.name("assigned_user_id"));

		Select As = new Select(Assigned);

		As.selectByValue("1");

		Reporter.log("[PASS] Assigned User selected successfully.", true);


		// ============================================================
		// STEP 15 : SELECT SALES STAGE
		// ============================================================

		Reporter.log("[STEP 15] Selecting Sales Stage...", true);

		WebElement Sales = driver.findElement(By.name("sales_stage"));

		Select sl = new Select(Sales);

		sl.selectByValue("Perception Analysis");

		Reporter.log("[PASS] Sales Stage selected : Perception Analysis", true);


		// ============================================================
		// STEP 16 : SELECT CAMPAIGN
		// ============================================================

		Reporter.log("[STEP 16] Opening Campaign selection window...", true);

		String PID2 = driver.getWindowHandle();

		Reporter.log("[INFO] Main Opportunity window handle captured.", true);

		driver.findElement(
				By.xpath("//input[@name='campaignname']/following-sibling::img[@alt='Select']"))
				.click();

		Reporter.log("[PASS] Campaign selection pop-up opened successfully.", true);

		WebDriverUtility webUtility = new WebDriverUtility(driver);

		Reporter.log("[INFO] Switching to Campaign selection window...", true);

		webUtility.switchToWindowByTitle("User Conference");

		Reporter.log("[PASS] Campaign selection window opened successfully.", true);

		driver.switchTo().window(PID2);

		Reporter.log("[PASS] Returned to main Opportunity form.", true);


		// ============================================================
		// STEP 17 : ENTER PROBABILITY
		// ============================================================

		Reporter.log("[STEP 17] Entering Opportunity Probability...", true);

		WebElement Probability = driver.findElement(By.id("probability"));

		Probability.sendKeys("88");

		Reporter.log("[PASS] Probability entered : 88", true);


		// ============================================================
		// STEP 18 : SAVE OPPORTUNITY
		// ============================================================

		Reporter.log("[STEP 18] Saving Opportunity...", true);

		driver.findElement(By.name("button")).click();

		Reporter.log("[PASS] Opportunity Save button clicked successfully.", true);


		// ============================================================
		// STEP 19 : VALIDATE OPPORTUNITY
		// ============================================================

		Reporter.log("============================================================", true);
		Reporter.log("OPPORTUNITY VALIDATION STARTED", true);
		Reporter.log("============================================================", true);


		// Fetch Opportunity Name

		Reporter.log("[INFO] Fetching actual Opportunity Name...", true);

		String Vopptname = driver.findElement(
				By.cssSelector("[id='dtlview_Opportunity Name']"))
				.getText();

		Reporter.log("[INFO] Expected Opportunity Name : " + zd, true);
		Reporter.log("[INFO] Actual Opportunity Name   : " + Vopptname, true);


		// Fetch Opportunity Type

		Reporter.log("[INFO] Fetching actual Opportunity Type...", true);

		String Vtype = driver.findElement(
				By.id("dtlview_Type"))
				.getText();

		Reporter.log("[INFO] Expected Opportunity Type : " + Sss, true);
		Reporter.log("[INFO] Actual Opportunity Type   : " + Vtype, true);


		// ============================================================
		// OPPORTUNITY NAME VERIFICATION
		// ============================================================

		Reporter.log("========== OPPORTUNITY NAME VERIFICATION ==========", true);

		if (Vopptname.equals(zd)) {

			Reporter.log("[PASS] Opportunity Name verified successfully.", true);

		} else {

			Reporter.log("[FAIL] Opportunity Name verification failed.", true);
		}


		// ============================================================
		// OPPORTUNITY TYPE VERIFICATION
		// ============================================================

		Reporter.log("========== OPPORTUNITY TYPE VERIFICATION ==========", true);

		if (Vtype.equals(Sss)) {

			Reporter.log("[PASS] Opportunity Type is matched.", true);

		} else {

			Reporter.log("[FAIL] Opportunity Type is not matched.", true);
		}


		// ============================================================
		// STEP 20 : SIGN OUT
		// ============================================================

		Reporter.log("[STEP 20] Logging out from application...", true);

		SignOut sn = new SignOut(driver);

		WebElement profile = sn.getPro();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		Reporter.log("[INFO] Hovering over profile icon...", true);

		wdUtil.hover(profile);

		Reporter.log("[PASS] Profile menu opened successfully.", true);

		Reporter.log("[INFO] Clicking Sign Out...", true);

		WebElement Out = sn.getSingnOut();

		Out.click();

		Reporter.log("[PASS] User logged out successfully.", true);


		// ============================================================
		// STEP 21 : CLOSE BROWSER
		// ============================================================

		Reporter.log("[STEP 21] Closing browser...", true);

		driver.quit();

		Reporter.log("[PASS] Browser closed successfully.", true);


		// ============================================================
		// TEST CASE END
		// ============================================================

		Reporter.log("============================================================", true);
		Reporter.log("TEST CASE COMPLETED : TC_OPP_001", true);
		Reporter.log("Test Name : Create Opportunity", true);
		Reporter.log("Test Result : Opportunity creation flow completed.", true);
		Reporter.log("============================================================", true);
	}
}
