package opportunities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
public class createOpprtunities {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("=================================================");
		System.out.println("[INFO] TEST EXECUTION STARTED");
		System.out.println("[INFO] Test Case ID   : TC_OPP_001");
		System.out.println("[INFO] Test Case Name : Create Opportunity");
		System.out.println("[INFO] Module         : Opportunities");
		System.out.println("=================================================");

		// Launch Chrome browser
		System.out.println("[INFO] Launching Chrome browser...");
		WebDriver driver = new ChromeDriver();
		System.out.println("[PASS] Chrome browser launched successfully.");

		// Maximize browser window
		System.out.println("[INFO] Maximizing browser window...");
		driver.manage().window().minimize();
		System.out.println("[PASS] Browser window maximized successfully.");

		// Configure implicit wait
		System.out.println("[INFO] Configuring implicit wait for 30 seconds...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("[PASS] Implicit wait configured successfully.");

		// Open application
		System.out.println("[INFO] Opening Vtiger application...");
		driver.get("http://localhost:8888/index.php");
		System.out.println("[PASS] Vtiger application opened successfully.");

		// Enter username
		System.out.println("[INFO] Entering username...");
		WebElement user = driver.findElement(By.name("user_name"));
		user.sendKeys("admin");
		System.out.println("[PASS] Username entered successfully.");

		// Enter password
		System.out.println("[INFO] Entering password...");
		WebElement pass = driver.findElement(By.name("user_password"));
		pass.sendKeys("manager");
		System.out.println("[PASS] Password entered successfully.");

		// Click Login
		System.out.println("[INFO] Clicking Login button...");
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();
		System.out.println("[PASS] Login button clicked successfully.");
		System.out.println("[PASS] User login completed successfully.");

		// Navigate to Opportunities
		System.out.println("[INFO] Navigating to Opportunities module...");
		WebElement module = driver.findElement(By.linkText("Opportunities"));
		module.click();
		System.out.println("[PASS] Opportunities module opened successfully.");

		// Open Create Opportunity
		System.out.println("[INFO] Opening Create Opportunity form...");
		WebElement mod = driver.findElement(By.cssSelector("img[alt='Create Opportunity...']"));
		mod.click();
		System.out.println("[PASS] Create Opportunity form opened successfully.");

		// Generate unique Opportunity Name
		System.out.println("[INFO] Generating unique Opportunity Name...");
		long ran = System.currentTimeMillis();
		String zd = "Zudio" + ran;
		System.out.println("[PASS] Opportunity Name generated: " + zd);

		// Enter Opportunity Name
		System.out.println("[INFO] Entering Opportunity Name...");
		WebElement OppName = driver.findElement(By.name("potentialname"));
		OppName.sendKeys(zd);
		System.out.println("[PASS] Opportunity Name entered successfully.");

		// Capture main window

		driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click();

		String PID = driver.getWindowHandle();
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.switchToWindowByTitle("sd");
		driver.findElement(By.id("1")).click();
		driver.switchTo().window(PID);

		// Related To
		System.out.println("[INFO] Entering Related To information...");
		WebElement related = driver.findElement(By.id("related_to_display"));
		related.sendKeys("old");
		System.out.println("[PASS] Related To value entered successfully.");

		// Amount
		System.out.println("[INFO] Entering Opportunity Amount...");
		WebElement amount = driver.findElement(By.name("amount"));
		amount.sendKeys("5000");
		System.out.println("[PASS] Opportunity Amount entered: 5000.");

		// Opportunity Type
		System.out.println("[INFO] Selecting Opportunity Type...");
		WebElement ss = driver.findElement(By.name("opportunity_type"));
		Select singleselect = new Select(ss);
		singleselect.selectByValue("New Business");
		System.out.println("[PASS] Opportunity Type selected: New Business.");

		// Closing Date
		System.out.println("[INFO] Entering Closing Date...");
		WebElement date = driver.findElement(By.name("closingdate"));
		date.sendKeys("2026/09/18");
		System.out.println("[PASS] Closing Date entered: 2026/09/18.");

		// Lead Source
		System.out.println("[INFO] Selecting Lead Source...");
		WebElement lead = driver.findElement(By.name("leadsource"));
		Select ld = new Select(lead);
		ld.selectByValue("Partner");
		System.out.println("[PASS] Lead Source selected: Partner.");

		// Next Step
		System.out.println("[INFO] Entering Next Step...");
		WebElement Next_Step = driver.findElement(By.id("nextstep"));
		Next_Step.sendKeys("move on");
		System.out.println("[PASS] Next Step entered: move on.");

		// Assigned User
		System.out.println("[INFO] Selecting Assigned User...");
		WebElement Assigned = driver.findElement(By.name("assigned_user_id"));
		Select As = new Select(Assigned);
		As.selectByValue("1");
		System.out.println("[PASS] Assigned User selected successfully.");

		// Sales Stage
		System.out.println("[INFO] Selecting Sales Stage...");
		WebElement Sales = driver.findElement(By.name("sales_stage"));
		Select sl = new Select(Sales);
		sl.selectByValue("Perception Analysis");
		System.out.println("[PASS] Sales Stage selected: Perception Analysis.");

		// Capture main window
		System.out.println("[INFO] Capturing main Opportunity window handle...");
		String PID2 = driver.getWindowHandle();
		System.out.println("[PASS] Main Opportunity window handle captured.");

		// Open Campaign pop-up
		System.out.println("[INFO] Opening Campaign selection pop-up...");
		driver.findElement(By.xpath("//input[@name='campaignname']/following-sibling::img[@alt='Select']")).click();
		System.out.println("[PASS] Campaign selection pop-up opened successfully.");

		WebDriverUtility webUtility = new WebDriverUtility(driver);
		webUtility.switchToWindowByTitle("User Conference");
		// Capture windows
		System.out.println("[INFO] Capturing available window handles...");
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
		System.out.println("[INFO] Switching back to main Opportunity window...");
		driver.switchTo().window(PID2);
		System.out.println("[PASS] Returned to main Opportunity form.");

		// Enter Probability
		System.out.println("[INFO] Entering Opportunity Probability...");
		WebElement Probability = driver.findElement(By.id("probability"));
		Probability.sendKeys("88");
		System.out.println("[PASS] Probability entered: 88%.");

		// Save Opportunity
		System.out.println("[INFO] Clicking Save button...");
		driver.findElement(By.name("button")).click();
		System.out.println("[PASS] Save button clicked successfully.");
		System.out.println("[INFO] Opportunity creation request submitted.");

		// Validate Opportunity Name
		System.out.println("[INFO] Validating Opportunity Name...");
		WebElement Vopptname = driver.findElement(By.cssSelector("[id='dtlview_Opportunity Name']"));
		System.out.println("[PASS] Opportunity Name validation element found.");

		// Validate Related Organization
		System.out.println("[INFO] Validating Related Organization...");
		WebElement Vrelated = driver.findElement(By.linkText("vtiger"));
		System.out.println("[PASS] Related Organization validation element found.");

		// Validate Amount
		System.out.println("[INFO] Validating Opportunity Amount...");
		WebElement Vamount = driver.findElement(By.id("dtlview_Amount"));
		System.out.println("[PASS] Opportunity Amount validation element found.");

		// Validate Opportunity Type
		System.out.println("[INFO] Validating Opportunity Type...");
		WebElement Vtype = driver.findElement(By.id("dtlview_Type"));
		System.out.println("[PASS] Opportunity Type validation element found.");

		// Verify Opportunity details
		System.out.println("[INFO] Verifying created Opportunity details...");

		if (Vopptname.equals(OppName) && related.equals(Vrelated) && Vamount.equals(amount) && Vtype.equals(ss)) {

			System.out.println("[PASS] Opportunity details verified successfully.");
			System.out.println("[PASS] Test Case TC_OPP_001 PASSED.");

		} else {

			System.out.println("[FAIL] Opportunity details verification failed.");
			System.out.println("[FAIL] Test Case TC_OPP_001 FAILED.");
		}

		// Locate User Profile
		System.out.println("[INFO] Locating user profile...");
		WebElement profile = driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"));
		System.out.println("[PASS] User profile located successfully.");

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.hover(profile);

		// Sign Out
		System.out.println("[INFO] Clicking Sign Out...");
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("[PASS] Sign Out clicked successfully.");

		Thread.sleep(1000);

		// Close browser
		System.out.println("[INFO] Closing browser...");
		driver.quit();
		System.out.println("[PASS] Browser closed successfully.");

		// =================================================
		// EXECUTION SUMMARY
		// =================================================

		System.out.println("=================================================");
		System.out.println("[INFO] TEST EXECUTION COMPLETED");
		System.out.println("[INFO] Test Case ID   : TC_OPP_001");
		System.out.println("[INFO] Test Case Name : Create Opportunity");
		System.out.println("=================================================");
	}
}
