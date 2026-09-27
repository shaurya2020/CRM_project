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

/**
 * Test Script Name : createContacts
 *
 * Test Case ID     : TC_CON_001
 *
 * Description:
 * This test script creates a new Contact in the Vtiger CRM application
 * using test data from JSON and Excel files.
 *
 * Test Flow:
 * 1. Read application URL and login credentials from JSON file.
 * 2. Read Contact test data from Excel file.
 * 3. Launch Chrome browser.
 * 4. Open Vtiger CRM application.
 * 5. Login into the application.
 * 6. Navigate to Contacts module.
 * 7. Create a new Contact.
 * 8. Select an Organization from popup window.
 * 9. Enter Contact details.
 * 10. Save the Contact.
 * 11. Validate created Contact details.
 * 12. Logout from the application.
 * 13. Close the browser.
 *
 * Test Data:
 * - Last Name       : Excel
 * - Email           : Excel
 * - Assistant       : Excel
 * - Lead Source     : Static value - Employee
 * - Phone           : Static value
 * - Description     : Static value
 *
 * Expected Result:
 * Contact should be created successfully and all entered
 * Contact details should match the actual displayed values.
 */
public class createContacts {

//	public static void main(String[] args)			throws InterruptedException, EncryptedDocumentException, IOException, ParseException {

	public void cratecontact() throws IOException, ParseException, InterruptedException {
		// ============================================================
		// TEST CASE START
		// ============================================================

		System.out.println("==================================================");
		System.out.println("          TEST CASE STARTED : TC_CON_001");
		System.out.println("          Test Name : Create Contact");
		System.out.println("==================================================");


//		JSON TEST DATA
		/*
		 * Reading application URL, username and password
		 * from JSON configuration file.
		 */
		System.out.println("[STEP 01] Reading login data from JSON file...");

		String url = FileUtility.GetDataFJsonFile("url");
		String username = FileUtility.GetDataFJsonFile("un");
		String password = FileUtility.GetDataFJsonFile("pwd");

		System.out.println("[INFO] Application URL loaded successfully.");
		System.out.println("[INFO] Username loaded successfully.");
		System.out.println("[INFO] Password loaded successfully.");


		
//		EXCEL TEST DATA
		/*
		 * Reading Contact test data from Excel file.
		 */
		System.out.println("[STEP 02] Reading Contact test data from Excel file...");

		String LastName = FileUtility.GetDataExcellFile("Contact", 4, 0);
		String Email = FileUtility.GetDataExcellFile("Contact", 4, 4);
		String asi = FileUtility.GetDataExcellFile("Contact", 4, 2);

		System.out.println("[INFO] Last Name test data loaded.");
		System.out.println("[INFO] Email test data loaded.");
		System.out.println("[INFO] Assistant test data loaded.");



		// ============================================================
		// BROWSER SETUP
		// ============================================================

		System.out.println("[STEP 03] Launching Chrome browser...");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		System.out.println("[INFO] Chrome browser launched successfully.");
		System.out.println("[INFO] Browser window maximized.");
		System.out.println("[INFO] Implicit wait configured : 15 seconds.");


//		OPEN APPLICATION

		System.out.println("[STEP 04] Opening Vtiger CRM application...");

		driver.get(url);

		System.out.println("[PASS] Vtiger CRM application opened successfully.");



		// ============================================================
		// LOGIN
		// ============================================================

		System.out.println("[STEP 05] Performing application login...");

		LoginPage lg = new LoginPage(driver);
		VeyContactPage vr = new VeyContactPage(driver);

		// Locate username field using Page Object Model
		WebElement user = lg.getusername();

		user.sendKeys(username);

		System.out.println("[INFO] Username entered successfully.");

		// Locate password field using Page Object Model
		WebElement pass = lg.getPassword();

		pass.sendKeys(password);

		System.out.println("[INFO] Password entered successfully.");

		// Locate Login button
		WebElement login = lg.getbutton();

		login.click();

		System.out.println("[PASS] Login button clicked.");
		System.out.println("[PASS] User logged into the application.");



		// ============================================================
		// NAVIGATE TO CONTACT MODULE
		// ============================================================

		System.out.println("[STEP 06] Navigating to Contacts module...");

		ContactPage ct = new ContactPage(driver);

		// Locate Contacts module link
		WebElement module = ct.getLink();

		module.click();

		System.out.println("[PASS] Contacts module opened successfully.");



		// ============================================================
		// CREATE NEW CONTACT
		// ============================================================

		System.out.println("[STEP 07] Opening Create Contact page...");

		// Locate Create Contact icon
		WebElement addicon = ct.getAddicon();

		addicon.click();

		System.out.println("[PASS] Create Contact page opened successfully.");



		// ============================================================
		// ENTER CONTACT LAST NAME
		// ============================================================

		System.out.println("[STEP 08] Entering Contact Last Name...");

		WebElement lastname = ct.getLastname();

		lastname.sendKeys(LastName);

		System.out.println("[INFO] Last Name entered : " + LastName);



		// ============================================================
		// ORGANIZATION POPUP
		// ============================================================

		System.out.println("[STEP 09] Selecting Organization from popup...");

		/*
		 * Store the current/main window handle before opening
		 * the Organization selection popup.
		 */
		String PID2 = driver.getWindowHandle();

		System.out.println("[INFO] Parent window handle stored.");

		/*
		 * Click Organization Select button.
		 */
		driver.findElement(
				By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']"))
				.click();

		System.out.println("[INFO] Organization selection popup opened.");

		/*
		 * Capture all available window handles.
		 */
		Set<String> CID2 = driver.getWindowHandles();

		/*
		 * Switch to the popup window.
		 */
		for (String i : CID2) {

			driver.switchTo().window(i);

		}

		System.out.println("[INFO] Switched to Organization popup window.");

		/*
		 * Select Organization.
		 */
		driver.findElement(By.id("3")).click();

		System.out.println("[INFO] Organization selected successfully.");

		Thread.sleep(2000);

		/*
		 * Switch back to the parent Contact window.
		 */
		driver.switchTo().window(PID2);

		System.out.println("[INFO] Returned to Contact creation window.");



		// ============================================================
		// SELECT LEAD SOURCE
		// ============================================================

		System.out.println("[STEP 10] Selecting Lead Source...");

		String emp = "Employee";

		WebElement ld = ct.getLead();

		/*
		 * Select Lead Source using WebDriverUtility.
		 */
		WebDriverUtility ns = new WebDriverUtility(driver);

		ns.select(ld, emp);

		System.out.println("[INFO] Lead Source selected : " + emp);



		// ============================================================
		// ENTER PHONE NUMBER
		// ============================================================

		System.out.println("[STEP 11] Entering Contact Phone Number...");

		WebElement phone = ct.getPhone();

		phone.sendKeys("1234567892");

		System.out.println("[INFO] Phone number entered successfully.");



		// ============================================================
		// ENTER EMAIL
		// ============================================================

		System.out.println("[STEP 12] Entering Contact Email...");

		WebElement email = ct.getEmail();

		email.sendKeys(Email);

		System.out.println("[INFO] Email entered : " + Email);



		// ============================================================
		// ENTER ASSISTANT
		// ============================================================

		System.out.println("[STEP 13] Entering Assistant name...");

		WebElement assistant = ct.getAssitance();

		assistant.sendKeys(asi);

		System.out.println("[INFO] Assistant entered : " + asi);



		// ============================================================
		// ENTER DESCRIPTION
		// ============================================================

		System.out.println("[STEP 14] Entering Contact Description...");

		String Dis = "its is done";

		WebElement description = ct.getDescription();

		description.sendKeys(Dis);

		System.out.println("[INFO] Description entered : " + Dis);



		// ============================================================
		// SAVE CONTACT
		// ============================================================

		System.out.println("[STEP 15] Saving Contact...");

		WebElement but = ct.getButton();

		but.click();

		System.out.println("[PASS] Contact Save button clicked.");
		System.out.println("[INFO] Contact creation process completed.");



		// ============================================================
		// VALIDATION
		// ============================================================

		System.out.println("==================================================");
		System.out.println("              CONTACT VALIDATION");
		System.out.println("==================================================");

		/*
		 * Fetch actual values displayed on Contact details page.
		 */
		String Vlastna = vr.getlastname().getText();

		String VEmail = vr.getEmail().getText();

		String Vlead = vr.getLead().getText();

		String VAssis = vr.getAssis().getText();

		String VDescrpt = vr.getDiscript().getText();



		// ============================================================
		// LAST NAME VERIFICATION
		// ============================================================

		System.out.println("\n========== LAST NAME VERIFICATION ==========");

		System.out.println("Expected Result : " + LastName);
		System.out.println("Actual Result   : " + Vlastna);

		if (LastName.equals(Vlastna)) {

			System.out.println("PASS : Last Name is matched");

		} else {

			System.out.println("FAIL : Last Name is not matched");
		}



		// ============================================================
		// EMAIL VERIFICATION
		// ============================================================

		System.out.println("\n========== EMAIL VERIFICATION ==========");

		System.out.println("Expected Result : " + Email);
		System.out.println("Actual Result   : " + VEmail);

		if (Email.equals(VEmail)) {

			System.out.println("PASS : Email is matched");

		} else {

			System.out.println("FAIL : Email is not matched");
		}



		// ============================================================
		// LEAD SOURCE VERIFICATION
		// ============================================================

		System.out.println("\n========== LEAD SOURCE VERIFICATION ==========");

		System.out.println("Expected Result : " + emp);
		System.out.println("Actual Result   : " + Vlead);

		if (emp.equals(Vlead)) {

			System.out.println("PASS : Lead Source is matched");

		} else {

			System.out.println("FAIL : Lead Source is not matched");
		}



		// ============================================================
		// ASSISTANT VERIFICATION
		// ============================================================

		System.out.println("\n========== ASSISTANT VERIFICATION ==========");

		System.out.println("Expected Result : " + asi);
		System.out.println("Actual Result   : " + VAssis);

		if (asi.equals(VAssis)) {

			System.out.println("PASS : Assistant is matched");

		} else {

			System.out.println("FAIL : Assistant is not matched");
		}



		// ============================================================
		// DESCRIPTION VERIFICATION
		// ============================================================

		System.out.println("\n========== DESCRIPTION VERIFICATION ==========");

		System.out.println("Expected Result : " + Dis);
		System.out.println("Actual Result   : " + VDescrpt);

		if (Dis.equals(VDescrpt)) {

			System.out.println("PASS : Description is matched");

		} else {

			System.out.println("FAIL : Description is not matched");
		}



		// ============================================================
		// LOGOUT
		// ============================================================

		System.out.println("\n[STEP 16] Logging out from application...");

		SignOut sn = new SignOut(driver);

		WebElement profile = sn.getPro();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		/*
		 * Move mouse pointer to Profile/User icon.
		 */
		wdUtil.hover(profile);

		System.out.println("[INFO] Profile menu opened.");

		/*
		 * Click Sign Out.
		 */
		WebElement Out = sn.getSingnOut();

		Out.click();

		System.out.println("[PASS] User logged out successfully.");



		// ============================================================
		// CLOSE BROWSER
		// ============================================================

		Thread.sleep(1000);

		System.out.println("[STEP 17] Closing browser...");

		driver.quit();

		System.out.println("[PASS] Browser closed successfully.");



		// ============================================================
		// TEST CASE END
		// ============================================================

		System.out.println("\n==================================================");
		System.out.println("          TEST CASE COMPLETED : TC_CON_001");
		System.out.println("          Test Name : Create Contact");
		System.out.println("==================================================");

	}
}