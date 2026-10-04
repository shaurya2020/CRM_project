package Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SourceDemoEx {
	@Parameters({ "browser", "user", "pass", })
	@Test
	public void login(String browser, String user, String Pass) throws InterruptedException, Exception {
//	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else
			driver = new ChromeDriver();

//		WebDriver driver = new EdgeDriver();

		System.out.println("Create contact");
		String url = "https://www.saucedemo.com/";
		driver.get(url);

//		String user = "standard_user";
//		String Pass = "secret_sauce";

		driver.findElement(By.id("user-name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(Pass);
		;

		driver.findElement(By.id("login-button")).click();

//		verify
		boolean status = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(status);

		driver.findElement(By.cssSelector("[id='react-burger-menu-btn']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		logoutLink.click();
		Thread.sleep(5000);

		driver.quit();
	}
}
