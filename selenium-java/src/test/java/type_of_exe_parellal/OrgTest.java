package type_of_exe_parellal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrgTest {
		
		@Parameters("browser")
		@Test(groups = "reg")
	public void createOrg(String browser) {
			
				WebDriver driver;

				if (browser.equals("chrome")) {
					driver = new ChromeDriver();
				} else if (browser.equals("edge")) {
					driver = new EdgeDriver();
				} else if (browser.equals("firefox")) {
					driver = new FirefoxDriver();
				}else
					driver = new ChromeDriver();
				
				System.out.println("create Org");

				driver.quit();
				}
		}
	
//	}
	/*
	@Test(groups = "smoke")
	public void LoadOrg() {
		System.out.println("Load Org");
	}
	@Test(groups = "reg")
	public void VerifyOrg() {
		System.out.println("Load Org");
	}
}
*/