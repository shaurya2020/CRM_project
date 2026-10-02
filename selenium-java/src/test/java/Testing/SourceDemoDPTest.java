package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SourceDemoDPTest {

	@Test(dataProvider ="getData")
	public void login(String user,String Pass) throws InterruptedException {
	
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
//		String user = "standard_user";
//		String Pass = "secret_sauce";
		
		driver.findElement(By.id("user-name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(Pass);;
		
		driver.findElement(By.id("login-button")).click();
		
//		verify
		
		boolean status =driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(status);
		
		Thread.sleep(1000);
		driver.quit();
	
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] creds = new Object[6][2];
		
//		no of rows=>no of execution
//		no of columns=>no of perameter =>num of date at a time
		
		creds[0][0] ="standard_user";
		creds[0][1] ="secret_sauce";
		
		creds[1][0] ="locked_out_user";
		creds[1][1] ="secret_sauce";
		
		creds[2][0] ="problem_user";
		creds[2][1] ="secret_sauce";
		
		creds[3][0] ="performance_glitch_user";
		creds[3][1] ="secret_sauce";
		
		creds[4][0] ="error_user";
		creds[4][1] ="secret_sauce";
		
		creds[5][0] ="visual_user";
		creds[5][1] ="secret_sauce";
		
		return creds;
	
	}
}
