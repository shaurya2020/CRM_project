package genReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		report.setSystemInfo("Browser", "Edge");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("URL", "https://www.saucedemo.com/");

		// --- Driver Setup ---
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// ========== TEST 1: Login ==========
		ExtentTest loginTest = report.createTest("Login");
		
		driver.get("https://www.saucedemo.com/");
		loginTest.log(Status.INFO, "Navigated to SauceDemo login page");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		loginTest.log(Status.INFO, "Entered username");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		loginTest.log(Status.INFO, "Entered password");

		driver.findElement(By.id("login-button")).click();
		loginTest.log(Status.INFO, "Clicked login button");

		if (driver.getCurrentUrl().contains("inventory")) {
			loginTest.log(Status.PASS, "Login successful — redirected to inventory page");
		} else {
			loginTest.log(Status.FAIL, "Login failed — not on inventory page. URL: " + driver.getCurrentUrl());
		}
		loginTest.log(Status.INFO, "Now, We are on the Home Page");

		// ========== TEST 2: Logout ==========

		ExtentTest logoutTest = report.createTest("Logout");

		driver.findElement(By.id("react-burger-menu-btn")).click();
		logoutTest.log(Status.INFO, "Opened side menu");

		driver.findElement(By.id("logout_sidebar_link")).click();
		logoutTest.log(Status.INFO, "Clicked logout");

		if (driver.getCurrentUrl().contains("saucedemo.com")) {
			logoutTest.log(Status.PASS, "Logout successful — login page displayed");
		} else {
			logoutTest.log(Status.FAIL, "Logout failed — login page not displayed");
		}
		report.flush();

		driver.quit();
	}

}
