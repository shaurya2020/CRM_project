package Organizations;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import crm_reop.LoginPage;
import crm_reop.OrgPage;
import crm_reop.SignOut;
import crm_reop.VeryOrgPage;
import genric_utility.FileUtility;
import genric_utility.JavaUtility;
import genric_utility.WebDriverUtility;

/**
 * Test Script Name : CreateOrganization
 *
 * Test Case ID     : TC_ORG_001
 *
 * Description:
 * This test script creates a new Organization in the Vtiger CRM
 * application using test data from JSON and Excel files.
 *
 * Test Flow:
 *
 * 1. Read browser, URL and login credentials from JSON file.
 * 2. Generate random number for Organization Name.
 * 3. Read Organization test data from Excel file.
 * 4. Launch the selected browser.
 * 5. Open Vtiger CRM application.
 * 6. Login into the application.
 * 7. Navigate to Organizations module.
 * 8. Open Create Organization page.
 * 9. Enter Organization Name.
 * 10. Enter Phone Number.
 * 11. Enter Email.
 * 12. Select Industry.
 * 13. Select Organization Type.
 * 14. Save the Organization.
 * 15. Validate Organization details.
 * 16. Logout from the application.
 * 17. Close the browser.
 *
 * Expected Result:
 * Organization should be created successfully and all entered
 * Organization details should match the actual values.
 */
public class CreateOrganization {

	@Test
	public void createOrg() throws IOException, ParseException {

		// ============================================================
		// TEST CASE START
		// ============================================================

		Reporter.log("============================================================", true);
		Reporter.log("TEST CASE STARTED : TC_ORG_001", true);
		Reporter.log("Test Name : Create Organization", true);
		Reporter.log("============================================================", true);


		// ============================================================
		// STEP 01 : READ JSON TEST DATA
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
		// STEP 02 : GENERATE RANDOM ORGANIZATION NUMBER
		// ============================================================

		Reporter.log("[STEP 02] Generating random number for Organization Name...", true);

		JavaUtility jd = new JavaUtility();

		int zs = jd.generateRandomNumber(1000);

		Reporter.log("[INFO] Random number generated : " + zs, true);


		// ============================================================
		// STEP 03 : READ EXCEL TEST DATA
		// ============================================================

		Reporter.log("[STEP 03] Reading Organization test data from Excel...", true);

		String accountName = FileUtility.GetDataExcellFile("ORGname", 4, 0) + zs;
		String email = FileUtility.GetDataExcellFile("ORGname", 5, 4);

		Reporter.log("[INFO] Organization Name loaded : " + accountName, true);
		Reporter.log("[INFO] Email test data loaded : " + email, true);


		// ============================================================
		// STEP 04 : LAUNCH BROWSER
		// ============================================================

		Reporter.log("[STEP 04] Launching browser...", true);

		WebDriver driver = null;

		if (browser.equals("chrome")) {

			driver = new ChromeDriver();

			Reporter.log("[PASS] Chrome browser launched successfully.", true);

		} else if (browser.equals("edge")) {

			driver = new EdgeDriver();

			Reporter.log("[PASS] Edge browser launched successfully.", true);
		}


		// ============================================================
		// BROWSER CONFIGURATION
		// ============================================================

		Reporter.log("[INFO] Maximizing browser window...", true);

		driver.manage().window().maximize();

		Reporter.log("[PASS] Browser window maximized.", true);

		Reporter.log("[INFO] Configuring implicit wait : 10 seconds...", true);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Reporter.log("[PASS] Implicit wait configured successfully.", true);


		// ============================================================
		// STEP 05 : OPEN APPLICATION
		// ============================================================

		Reporter.log("[STEP 05] Opening Vtiger CRM application...", true);

		driver.get(url);

		Reporter.log("[PASS] Vtiger CRM application opened successfully.", true);


		// ============================================================
		// STEP 06 : LOGIN
		// ============================================================

		Reporter.log("[STEP 06] Performing application login...", true);

		LoginPage Lg = new LoginPage(driver);
		OrgPage Og = new OrgPage(driver);


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


		// Click Login Button

		Reporter.log("[INFO] Clicking Login button...", true);

		WebElement button = Lg.getbutton();

		button.click();

		Reporter.log("[PASS] User logged into Vtiger CRM successfully.", true);


		// ============================================================
		// STEP 07 : NAVIGATE TO ORGANIZATIONS MODULE
		// ============================================================

		Reporter.log("[STEP 07] Navigating to Organizations module...", true);

		WebElement module = Og.getLink();

		module.click();

		Reporter.log("[PASS] Organizations module opened successfully.", true);


		// ============================================================
		// STEP 08 : OPEN CREATE ORGANIZATION PAGE
		// ============================================================

		Reporter.log("[STEP 08] Opening Create Organization page...", true);

		WebElement mod = Og.getCss();

		mod.click();

		Reporter.log("[PASS] Create Organization page opened successfully.", true);


		// ============================================================
		// STEP 09 : ENTER ORGANIZATION NAME
		// ============================================================

		Reporter.log("[STEP 09] Entering Organization Name...", true);

		WebElement OrgNam = Og.getAccname();

		OrgNam.sendKeys(accountName);

		Reporter.log("[INFO] Organization Name entered : " + accountName, true);


		// ============================================================
		// STEP 10 : GENERATE AND ENTER PHONE NUMBER
		// ============================================================

		Reporter.log("[STEP 10] Generating and entering Phone Number...", true);

		JavaUtility jds = new JavaUtility();

		int jz = jds.generateRandomNumber(1000);

		String Num = "9140050" + jz;

		Reporter.log("[INFO] Generated Phone Number : " + Num, true);

		WebElement phone = Og.getPhone();

		phone.sendKeys(Num);

		Reporter.log("[PASS] Phone Number entered successfully.", true);


		// ============================================================
		// STEP 11 : ENTER EMAIL
		// ============================================================

		Reporter.log("[STEP 11] Entering Organization Email...", true);

		WebElement Email = Og.getEmail();

		Email.sendKeys(email);

		Reporter.log("[INFO] Email entered : " + email, true);


		// ============================================================
		// STEP 12 : SELECT INDUSTRY
		// ============================================================

		Reporter.log("[STEP 12] Selecting Organization Industry...", true);

		String sell = "Education";

		WebElement Ind = Og.getIndustry();

		WebDriverUtility sg = new WebDriverUtility(driver);

		sg.select(Ind, sell);

		Reporter.log("[PASS] Industry selected : " + sell, true);


		// ============================================================
		// STEP 13 : SELECT ORGANIZATION TYPE
		// ============================================================

		Reporter.log("[STEP 13] Selecting Organization Type...", true);

		String cs = "Customer";

		WebElement Type = Og.getAccounttype();

		WebDriverUtility Tys = new WebDriverUtility(driver);

		Tys.select(Type, cs);

		Reporter.log("[PASS] Organization Type selected : " + cs, true);


		// ============================================================
		// STEP 14 : SAVE ORGANIZATION
		// ============================================================

		Reporter.log("[STEP 14] Saving Organization...", true);

		WebElement but = Og.getButton();

		but.click();

		Reporter.log("[PASS] Save button clicked successfully.", true);
		Reporter.log("[INFO] Organization creation process completed.", true);


		// ============================================================
		// STEP 15 : ORGANIZATION VALIDATION
		// ============================================================

		Reporter.log("============================================================", true);
		Reporter.log("ORGANIZATION VALIDATION STARTED", true);
		Reporter.log("============================================================", true);

		VeryOrgPage os = new VeryOrgPage(driver);


		// Fetch actual Organization Name

		Reporter.log("[INFO] Fetching actual Organization Name...", true);

		String VOrgNam = os.getOrgname().getText();


		// Fetch actual Phone

		Reporter.log("[INFO] Fetching actual Phone Number...", true);

		String Vphone = os.getPhone().getText();


		// Fetch actual Email

		Reporter.log("[INFO] Fetching actual Email...", true);

		String VEmail = os.getEmail().getText();


		// Fetch actual Industry

		Reporter.log("[INFO] Fetching actual Industry...", true);

		String VInd = os.getIndustery().getText();


		// Fetch actual Type

		Reporter.log("[INFO] Fetching actual Organization Type...", true);

		String Vtype = os.getType().getText();


		// ============================================================
		// ORGANIZATION NAME VERIFICATION
		// ============================================================

		Reporter.log("========== ORGANIZATION NAME VERIFICATION ==========", true);

		Reporter.log("Expected Result : " + accountName, true);
		Reporter.log("Actual Result   : " + VOrgNam, true);

		if (VOrgNam.equals(accountName)) {

			Reporter.log("[PASS] Organization Name is matched.", true);

		} else {

			Reporter.log("[FAIL] Organization Name is not matched.", true);
		}


		// ============================================================
		// PHONE VERIFICATION
		// ============================================================

		Reporter.log("========== PHONE VERIFICATION ==========", true);

		Reporter.log("Expected Result : " + Num, true);
		Reporter.log("Actual Result   : " + Vphone, true);

		if (Vphone.equals(Num)) {

			Reporter.log("[PASS] Phone is matched.", true);

		} else {

			Reporter.log("[FAIL] Phone is not matched.", true);
		}


		// ============================================================
		// EMAIL VERIFICATION
		// ============================================================

		Reporter.log("========== EMAIL VERIFICATION ==========", true);

		Reporter.log("Expected Result : " + email, true);
		Reporter.log("Actual Result   : " + VEmail, true);

		if (VEmail.equals(email)) {

			Reporter.log("[PASS] Email is matched.", true);

		} else {

			Reporter.log("[FAIL] Email is not matched.", true);
		}


		// ============================================================
		// INDUSTRY VERIFICATION
		// ============================================================

		Reporter.log("========== INDUSTRY VERIFICATION ==========", true);

		Reporter.log("Expected Result : " + sell, true);
		Reporter.log("Actual Result   : " + VInd, true);

		if (VInd.equals(sell)) {

			Reporter.log("[PASS] Industry is matched.", true);

		} else {

			Reporter.log("[FAIL] Industry is not matched.", true);
		}


		// ============================================================
		// TYPE VERIFICATION
		// ============================================================

		Reporter.log("========== ORGANIZATION TYPE VERIFICATION ==========", true);

		Reporter.log("Expected Result : " + cs, true);
		Reporter.log("Actual Result   : " + Vtype, true);

		if (Vtype.equals(cs)) {

			Reporter.log("[PASS] Organization Type is matched.", true);

		} else {

			Reporter.log("[FAIL] Organization Type is not matched.", true);
		}


		// ============================================================
		// STEP 16 : SIGN OUT
		// ============================================================

		Reporter.log("[STEP 16] Logging out from application...", true);

		SignOut sn = new SignOut(driver);

		WebElement profile = sn.getPro();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		Reporter.log("[INFO] Hovering over profile icon...", true);

		wdUtil.hover(profile);

		Reporter.log("[PASS] Profile menu opened.", true);

		Reporter.log("[INFO] Clicking Sign Out...", true);

		WebElement Out = sn.getSingnOut();

		Out.click();

		Reporter.log("[PASS] User logged out successfully.", true);


		// ============================================================
		// STEP 17 : CLOSE BROWSER
		// ============================================================

		Reporter.log("[STEP 17] Closing browser...", true);

		driver.quit();

		Reporter.log("[PASS] Browser closed successfully.", true);


		// ============================================================
		// TEST CASE END
		// ============================================================

		Reporter.log("============================================================", true);
		Reporter.log("TEST CASE COMPLETED : TC_ORG_001", true);
		Reporter.log("Test Name : Create Organization", true);
		Reporter.log("============================================================", true);
	}
}
