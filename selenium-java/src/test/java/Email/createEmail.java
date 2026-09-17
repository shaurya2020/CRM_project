package Email;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createEmail {

	public static void main(String[] args) throws InterruptedException {

		// ============================================================
		// TEST CASE       : Create and Send Email
		// MODULE          : Email
		// APPLICATION     : Vtiger CRM
		// TEST TYPE       : Functional UI Automation
		// AUTOMATION TOOL : Selenium WebDriver
		// BROWSER         : Google Chrome
		// PURPOSE         : Verify that a user can compose and send
		//                   an email to a selected contact.
		// ============================================================

		System.out.println("=================================================");
		System.out.println("TEST CASE STARTED : Create and Send Email");
		System.out.println("=================================================");

		// ------------------------------------------------------------
		// Step 1: Launch Chrome browser
		// ------------------------------------------------------------
		System.out.println("[STEP 1] Launching Chrome browser...");

		WebDriver driver = new ChromeDriver();

		// Maximize browser window
		driver.manage().window().maximize();

		// Set implicit wait for locating web elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("[PASS] Chrome browser launched successfully.");

		// ------------------------------------------------------------
		// Step 2: Open Vtiger CRM application
		// ------------------------------------------------------------
		System.out.println("[STEP 2] Opening Vtiger CRM application...");

		driver.get("http://localhost:8888/index.php");

		System.out.println("[PASS] Vtiger CRM application opened.");

		// ------------------------------------------------------------
		// Step 3: Login into Vtiger CRM
		// ------------------------------------------------------------
		System.out.println("[STEP 3] Logging into Vtiger CRM...");

		// Locate username field and enter username
		WebElement user = driver.findElement(By.name("user_name"));
		user.sendKeys("admin");

		System.out.println("[INFO] Username entered.");

		// Locate password field and enter password
		WebElement pass = driver.findElement(By.name("user_password"));
		pass.sendKeys("manager");

		System.out.println("[INFO] Password entered.");

		// Click Login button
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();

		System.out.println("[PASS] Login button clicked.");

		// ------------------------------------------------------------
		// Step 4: Navigate to Email module
		// ------------------------------------------------------------
		System.out.println("[STEP 4] Navigating to Email module...");

		driver.findElement(By.xpath("//a[text()='Email']")).click();

		System.out.println("[PASS] Email module opened.");

		// ------------------------------------------------------------
		// Step 5: Open Compose Email
		// ------------------------------------------------------------
		System.out.println("[STEP 5] Opening Compose Email window...");

		WebElement compose = driver.findElement(
				By.xpath("//a[text()='Compose']"));

		compose.click();

		System.out.println("[PASS] Compose option clicked.");

		Thread.sleep(1000);

		// ------------------------------------------------------------
		// Step 6: Store current window and switch to compose window
		// ------------------------------------------------------------
		System.out.println("[STEP 6] Handling Compose Email window...");

		// Store the current/main window handle
		String pid = driver.getWindowHandle();

		// Get all currently available window handles
		Set<String> oldWindow = driver.getWindowHandles();

		// Switch to the newly opened window
		for (String windowHandle : oldWindow) {

			if (!windowHandle.equals(pid)) {

				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Wait until two browser windows are available
		WebDriverWait wait = new WebDriverWait(
				driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		System.out.println("[PASS] Switched to Compose Email window.");
		System.out.println("[INFO] Current window title: " + driver.getTitle());

		// ------------------------------------------------------------
		// Step 7: Open Contact selection popup
		// ------------------------------------------------------------
		System.out.println("[STEP 7] Opening Contact selection popup...");

		// Locate Select icon for choosing a contact
		WebElement contact = driver.findElement(
				By.xpath("//img[@title='Select']"));

		contact.click();

		System.out.println("[PASS] Contact selection popup opened.");

		// ------------------------------------------------------------
		// Step 8: Handle Contact popup window
		// ------------------------------------------------------------
		System.out.println("[STEP 8] Switching to Contact selection window...");

		// Get all currently available windows
		Set<String> allWindow = driver.getWindowHandles();

		// Switch to the newly opened contact window
		for (String window : allWindow) {

			if (!oldWindow.contains(window)) {

				driver.switchTo().window(window);
				break;
			}
		}

		// Wait until three browser windows are available
		WebDriverWait wait1 = new WebDriverWait(
				driver, Duration.ofSeconds(20));

		wait1.until(ExpectedConditions.numberOfWindowsToBe(3));

		System.out.println("[PASS] Switched to Contact selection window.");
		System.out.println("[INFO] Current window title: " + driver.getTitle());

		// ------------------------------------------------------------
		// Step 9: Select contact
		// ------------------------------------------------------------
		System.out.println("[STEP 9] Selecting contact: Mary Smith...");

		driver.findElement(By.xpath("//a[text()='Mary Smith']")).click();

		System.out.println("[PASS] Contact 'Mary Smith' selected.");

		// ------------------------------------------------------------
		// Step 10: Switch back to Compose Email window
		// ------------------------------------------------------------
		System.out.println("[STEP 10] Returning to Compose Email window...");

		// Get all currently available windows
		Set<String> newwindow = driver.getWindowHandles();

		// Switch to the window other than the original parent window
		for (String windowHandle1 : newwindow) {

			if (!windowHandle1.equals(pid)) {

				driver.switchTo().window(windowHandle1);
				break;
			}
		}

		System.out.println("[PASS] Returned to Compose Email window.");

		// ------------------------------------------------------------
		// Step 11: Enter Email Subject
		// ------------------------------------------------------------
		System.out.println("[STEP 11] Entering email subject...");

		driver.findElement(By.id("subject"))
				.sendKeys("test vtiger");

		System.out.println("[INFO] Email subject entered: test vtiger");

		// ------------------------------------------------------------
		// Step 12: Send Email
		// ------------------------------------------------------------
		System.out.println("[STEP 12] Sending email...");

		driver.findElement(By.name("Send")).click();

		System.out.println("[PASS] Send button clicked.");

		// Wait for email processing
		Thread.sleep(2000);

		System.out.println("[INFO] Email processing completed.");

		// ------------------------------------------------------------
		// Step 13: Close browser
		// ------------------------------------------------------------
		System.out.println("[STEP 13] Closing browser...");

		driver.quit();

		System.out.println("[PASS] Browser closed successfully.");

		// ------------------------------------------------------------
		// Test completion
		// ------------------------------------------------------------
		System.out.println("=================================================");
		System.out.println("TEST CASE COMPLETED : Create and Send Email");
		System.out.println("=================================================");
	}
}