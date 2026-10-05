package genReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SourceDTest {
	public static void main(String[] args) {

		// --- Report Setup ---
		ExtentSparkReporter spark = new ExtentSparkReporter("./ad_report/rep.html");
		spark.config().setDocumentTitle("Sauce Demo Report");
		spark.config().setReportName("SauceDemo Test Suite");
		spark.config().setTheme(Theme.DARK);

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("URL", "https://www.saucedemo.com/");

		
		ExtentTest loginTest = report.createTest("Login");

		// --- Driver Setup ---
		WebDriver driver = new ChromeDriver();
		loginTest.log(Status.INFO, "Open the Chrome browser");
		driver.manage().window().maximize();
		loginTest.log(Status.INFO, "Chrome browser is maximize");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginTest.log(Status.INFO, "Wait for 15 Sec");

		// ========== TEST 1: Login ==========
		
		driver.get("https://www.saucedemo.com/");
		loginTest.log(Status.INFO, "Navigated to SauceDemo login page");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		loginTest.log(Status.INFO, "Entered username");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		loginTest.log(Status.INFO, "Entered password");

		driver.findElement(By.id("login-button")).click();
		loginTest.log(Status.INFO, "Clicked login button");

		if (driver.getCurrentUrl().contains("inventory")) {
			loginTest.log(Status.PASS, "Login successful");
		} else {
			loginTest.log(Status.FAIL, "Login failed");
		}
		report.flush();

		driver.quit();
	}

}
