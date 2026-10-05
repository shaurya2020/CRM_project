package genReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Vtiger_login {

	public static void main(String[] args) {

		// --- Report Setup ---
		ExtentSparkReporter spark = new ExtentSparkReporter("./ad_report/repvtiger.html");
		spark.config().setDocumentTitle("Vtiger Test Report");
		spark.config().setReportName("Vtiger Test Suite");
//				spark.config().setTheme(Theme.DARK);

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("URL", "http://localhost:8888/index.php");

		ExtentTest loginTest = report.createTest("Login with valid credentials");

		// --- Driver Setup ---
		  // Launch Edge browser
        WebDriver driver = new ChromeDriver();
        loginTest.log(Status.INFO, "Chrome Browser launched successfully");
        System.out.println("[INFO] Chrome Browser launched.");

        // Maximize browser window for full visibility
        driver.manage().window().maximize();
        loginTest.log(Status.INFO, "Browser window maximized");
        System.out.println("[INFO] Browser window maximized.");

        // Set implicit wait to handle element loading delays
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginTest.log(Status.INFO, "Implicit wait 10 seconds");
        System.out.println("[INFO] Implicit wait set to 10 seconds.");

        // ========== TEST 1: Login to Vtiger CRM ==========

        // Navigate to Vtiger login page
        driver.get("http://localhost:8888/index.php");
        loginTest.log(Status.INFO, "Navigated to Vtiger login page");
        System.out.println("[INFO] Navigated to Vtiger login page.");

        // Enter username in the login form
        driver.findElement(By.name("user_name")).sendKeys("admin");
        loginTest.log(Status.INFO, "Username entered");
        System.out.println("[INFO] Username entered.");

        // Enter password in the login form
        driver.findElement(By.name("user_password")).sendKeys("manager");
        loginTest.log(Status.INFO, "Password entered");
        System.out.println("[INFO] Password entered.");

        // Submit the login form
        driver.findElement(By.id("submitButton")).click();
        loginTest.log(Status.INFO, "Submit Button clicked");
        System.out.println("[INFO] Submit Button clicked.");

        // Verify login by checking if URL redirected to dashboard
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("dashboard") || currentUrl.contains("index")) {
            loginTest.log(Status.PASS, "Login successful");
            System.out.println("[PASS] Login successful.");
        } else {
            loginTest.log(Status.FAIL, "Login failed");
            System.out.println("[FAIL] Login failed.");
        }
		
        	report.flush();
		driver.quit();
	}
}
