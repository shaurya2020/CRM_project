package type_of_exe_parellal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeadTest {
	
	@Parameters("browser")
	@Test
	public void createLead(String browser) {
		

			WebDriver driver;

			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equals("edge")) {
				driver = new EdgeDriver();
			} else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			}else
				driver = new ChromeDriver();
			
			
			System.out.println("Create lead");
			
			driver.quit();
	}
	}
/*
	@Test(groups = "smoke")
	public void loadlead() {
		System.out.println("load lead");
	}
	@Test(groups = "smoke")
	public void verifyLead() {
		System.out.println("Verify Lead");
	}

}
*/
