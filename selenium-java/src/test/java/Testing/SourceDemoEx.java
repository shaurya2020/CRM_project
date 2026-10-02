package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SourceDemoEx {
	@Parameters({"browser","user","pass",})
	@Test
	public void login(String browser,String user,String Pass) throws InterruptedException {
		
	
		WebDriver driver;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else
			driver = new ChromeDriver();
		
		System.out.println("Create contact");



		driver.get("https://www.saucedemo.com/");
		
//		String user = "standard_user";
//		String Pass = "secret_sauce";
		
		driver.findElement(By.id("user-name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(Pass);;
		
		driver.findElement(By.id("login-button")).click();
		
//		verify
		boolean status =driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(status);
		
		driver.findElement(By.cssSelector("[id='react-burger-menu-btn']")).click();
//		driver.findElement(By.cssSelector("[id='logout_sidebar_link']")).click();
		Thread.sleep(1000);
		driver.quit();
	
}
}
