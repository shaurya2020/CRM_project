package leads;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import crm_reop.Leadspage;
import crm_reop.LoginPage;
import crm_reop.SignOut;
import crm_reop.VeryLeadPage;
import genric_utility.FileUtility;
import genric_utility.WebDriverUtility;


/**
 * Test Script Name : createLead
 *
 * Test Case ID     : TC_LEAD_001
 *
 * Description:
 * This test script creates a new Lead in the Vtiger CRM application
 * using test data from JSON and Excel files.
 *
 * Test Flow:
 *
 * 1. Read application URL and login credentials from JSON file.
 * 2. Read Lead test data from Excel file.
 * 3. Launch Chrome browser.
 * 4. Maximize browser and configure implicit wait.
 * 5. Open Vtiger CRM application.
 * 6. Login into the application.
 * 7. Navigate to Leads module.
 * 8. Open Create Lead page.
 * 9. Enter Lead Last Name.
 * 10. Enter Company Name.
 * 11. Select Lead Source.
 * 12. Select Industry.
 * 13. Enter Phone Number.
 * 14. Save the Lead.
 * 15. Validate Lead details.
 * 16. Logout from the application.
 * 17. Close the browser.
 *
 * Test Data:
 *
 * Last Name       : Excel
 * Company Name    : Excel
 * Lead Source     : Employee
 * Industry        : Education
 * Phone Number    : Excel
 *
 * Expected Result:
 * Lead should be created successfully and all entered Lead
 * details should match the actual values displayed on the
 * Lead details page.
 */
public class createLead {

//	public static void main(String[] args) throws IOException, ParseException {
	
	public void createlead() throws IOException, ParseException {
		// ============================================================
		// TEST CASE START
		// ============================================================

		System.out.println("============================================================");
		System.out.println("              TEST CASE STARTED : TC_LEAD_001");
		System.out.println("              Test Name : Create Lead");
		System.out.println("============================================================");


		// ============================================================
		// STEP 01 : READ JSON TEST DATA
		// ============================================================

		System.out.println("\n[STEP 01] Reading login configuration from JSON file...");

		String url = FileUtility.GetDataFJsonFile("url");
		String username = FileUtility.GetDataFJsonFile("un");
		String password = FileUtility.GetDataFJsonFile("pwd");

		System.out.println("[INFO] Application URL loaded successfully.");
		System.out.println("[INFO] Username loaded successfully.");
		System.out.println("[INFO] Password loaded successfully.");


		// ============================================================
		// STEP 02 : READ EXCEL TEST DATA
		// ============================================================

		System.out.println("\n[STEP 02] Reading Lead test data from Excel file...");

		String LastName = FileUtility.GetDataExcellFile("Lead", 4, 0);
		String CompanyName = FileUtility.GetDataExcellFile("Lead", 4, 1);

		/*
		 * Lead Source and Industry are currently provided as
		 * static test data.
		 */
		String Emp = "Employee";
		String IndSel = "Education";

		String Num = FileUtility.GetDataExcellFile("Lead", 4, 4);

		System.out.println("[INFO] Last Name loaded : " + LastName);
		System.out.println("[INFO] Company Name loaded : " + CompanyName);
		System.out.println("[INFO] Lead Source selected : " + Emp);
		System.out.println("[INFO] Industry selected : " + IndSel);
		System.out.println("[INFO] Phone Number loaded successfully.");


		// ============================================================
		// STEP 03 : LAUNCH CHROME BROWSER
		// ============================================================

		System.out.println("\n[STEP 03] Launching Chrome browser...");

		WebDriver driver = new ChromeDriver();

		System.out.println("[PASS] Chrome browser launched successfully.");


		// ============================================================
		// BROWSER CONFIGURATION
		// ============================================================

		System.out.println("[INFO] Maximizing browser window...");

		driver.manage().window().maximize();

		System.out.println("[INFO] Browser window maximized.");

		System.out.println("[INFO] Configuring implicit wait : 10 seconds...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("[INFO] Implicit wait configured successfully.");


		// ============================================================
		// STEP 04 : OPEN APPLICATION
		// ============================================================

		System.out.println("\n[STEP 04] Opening Vtiger CRM application...");

		driver.get(url);

		System.out.println("[PASS] Vtiger CRM application opened successfully.");


		// ============================================================
		// STEP 05 : LOGIN
		// ============================================================

		System.out.println("\n[STEP 05] Performing application login...");

		LoginPage Lg = new LoginPage(driver);


		// Enter Username
		System.out.println("[INFO] Entering username...");

		WebElement userName = Lg.getusername();

		userName.sendKeys(username);

		System.out.println("[INFO] Username entered successfully.");


		// Enter Password
		System.out.println("[INFO] Entering password...");

		WebElement Password = Lg.getPassword();

		Password.sendKeys(password);

		System.out.println("[INFO] Password entered successfully.");


		// Click Login button
		System.out.println("[INFO] Clicking Login button...");

		WebElement button = Lg.getbutton();

		button.click();

		System.out.println("[PASS] User logged into Vtiger CRM successfully.");


		// ============================================================
		// STEP 06 : NAVIGATE TO LEADS MODULE
		// ============================================================

		System.out.println("\n[STEP 06] Navigating to Leads module...");

		Leadspage lp = new Leadspage(driver);

		WebElement module = lp.getModule();

		module.click();

		System.out.println("[PASS] Leads module opened successfully.");


		// ============================================================
		// STEP 07 : OPEN CREATE LEAD PAGE
		// ============================================================

		System.out.println("\n[STEP 07] Opening Create Lead page...");

		WebElement mod = lp.getMod();

		mod.click();

		System.out.println("[PASS] Create Lead page opened successfully.");


		// ============================================================
		// STEP 08 : ENTER LAST NAME
		// ============================================================

		System.out.println("\n[STEP 08] Entering Lead Last Name...");

		WebElement lastname = lp.getLastname();

		lastname.sendKeys(LastName);

		System.out.println("[INFO] Last Name entered : " + LastName);


		// ============================================================
		// STEP 09 : ENTER COMPANY NAME
		// ============================================================

		System.out.println("\n[STEP 09] Entering Company Name...");

		WebElement Company = lp.getCompany();

		Company.sendKeys(CompanyName);

		System.out.println("[INFO] Company Name entered : " + CompanyName);


		// ============================================================
		// STEP 10 : SELECT LEAD SOURCE
		// ============================================================

		System.out.println("\n[STEP 10] Selecting Lead Source...");

		WebElement lead = lp.getLead();

		WebDriverUtility lsp = new WebDriverUtility(driver);

		lsp.select(lead, Emp);

		System.out.println("[INFO] Lead Source selected : " + Emp);


		// ============================================================
		// STEP 11 : SELECT INDUSTRY
		// ============================================================

		System.out.println("\n[STEP 11] Selecting Industry...");

		WebElement Ind = lp.getInd();

		lsp.select(Ind, IndSel);

		System.out.println("[INFO] Industry selected : " + IndSel);


		// ============================================================
		// STEP 12 : ENTER PHONE NUMBER
		// ============================================================

		System.out.println("\n[STEP 12] Entering Lead Phone Number...");

		WebElement Phone = lp.getPhone();

		Phone.sendKeys(Num);

		System.out.println("[INFO] Phone Number entered successfully.");


		// ============================================================
		// STEP 13 : SAVE LEAD
		// ============================================================

		System.out.println("\n[STEP 13] Saving Lead...");

		WebElement butt = lp.getButt();

		butt.click();

		System.out.println("[PASS] Save button clicked successfully.");
		System.out.println("[INFO] Lead creation process completed.");


		// ============================================================
		// STEP 14 : LEAD VALIDATION
		// ============================================================

		System.out.println("\n============================================================");
		System.out.println("                    LEAD VALIDATION");
		System.out.println("============================================================");

		VeryLeadPage vlp = new VeryLeadPage(driver);


		// Fetch actual Last Name
		System.out.println("[INFO] Fetching actual Last Name...");

		String VLastName = vlp.getLastname().getText();


		// Fetch actual Company Name
		System.out.println("[INFO] Fetching actual Company Name...");

		String Vcompaney = vlp.getCompany().getText();


		// Fetch actual Lead Source
		System.out.println("[INFO] Fetching actual Lead Source...");

		String VleadS = vlp.getLeads().getText();


		// Fetch actual Industry
		System.out.println("[INFO] Fetching actual Industry...");

		String VInd = vlp.getInd().getText();


		// Fetch actual Phone Number
		System.out.println("[INFO] Fetching actual Phone Number...");

		String VNum = vlp.getNum().getText();


		// ============================================================
		// LAST NAME VERIFICATION
		// ============================================================

		System.out.println("\n========== LAST NAME VERIFICATION ==========");

		System.out.println("Expected Result : " + LastName);
		System.out.println("Actual Result   : " + VLastName);

		if (LastName.equals(VLastName)) {

			System.out.println("PASS : Last Name is matched");

		} else {

			System.out.println("FAIL : Last Name is not matched");
		}


		// ============================================================
		// COMPANY NAME VERIFICATION
		// ============================================================

		System.out.println("\n========== COMPANY NAME VERIFICATION ==========");

		System.out.println("Expected Result : " + CompanyName);
		System.out.println("Actual Result   : " + Vcompaney);

		if (CompanyName.equals(Vcompaney)) {

			System.out.println("PASS : Company Name is matched");

		} else {

			System.out.println("FAIL : Company Name is not matched");
		}


		// ============================================================
		// LEAD SOURCE VERIFICATION
		// ============================================================

		System.out.println("\n========== LEAD SOURCE VERIFICATION ==========");

		System.out.println("Expected Result : " + Emp);
		System.out.println("Actual Result   : " + VleadS);

		if (Emp.equals(VleadS)) {

			System.out.println("PASS : Lead Source is matched");

		} else {

			System.out.println("FAIL : Lead Source is not matched");
		}


		// ============================================================
		// INDUSTRY VERIFICATION
		// ============================================================

		System.out.println("\n========== INDUSTRY VERIFICATION ==========");

		System.out.println("Expected Result : " + IndSel);
		System.out.println("Actual Result   : " + VInd);

		if (IndSel.equals(VInd)) {

			System.out.println("PASS : Industry is matched");

		} else {

			System.out.println("FAIL : Industry is not matched");
		}


		// ============================================================
		// PHONE NUMBER VERIFICATION
		// ============================================================

		System.out.println("\n========== PHONE NUMBER VERIFICATION ==========");

		System.out.println("Expected Result : " + Num);
		System.out.println("Actual Result   : " + VNum);

		if (Num.equals(VNum)) {

			System.out.println("PASS : Phone Number is matched");

		} else {

			System.out.println("FAIL : Phone Number is not matched");
		}


		// ============================================================
		// STEP 15 : SIGN OUT
		// ============================================================

		System.out.println("\n[STEP 15] Logging out from application...");

		SignOut sn = new SignOut(driver);

		WebElement profile = sn.getPro();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		System.out.println("[INFO] Hovering over profile icon...");

		wdUtil.hover(profile);

		System.out.println("[INFO] Profile menu opened.");


		System.out.println("[INFO] Clicking Sign Out...");

		WebElement Out = sn.getSingnOut();

		Out.click();

		System.out.println("[PASS] User logged out successfully.");


		// ============================================================
		// STEP 16 : CLOSE BROWSER
		// ============================================================

		System.out.println("\n[STEP 16] Closing browser...");

		driver.quit();

		System.out.println("[PASS] Browser closed successfully.");


		// ============================================================
		// TEST CASE END
		// ============================================================

		System.out.println("\n============================================================");
		System.out.println("              TEST CASE COMPLETED : TC_LEAD_001");
		System.out.println("              Test Name : Create Lead");
		System.out.println("============================================================");

	}

}