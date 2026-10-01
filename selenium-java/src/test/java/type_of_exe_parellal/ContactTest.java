package type_of_exe_parellal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContactTest {
	@Parameters("browser")
	@Test
	public void createContact(String browser) {

		
		WebDriver driver;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else
			driver = new ChromeDriver();
		
			driver.quit();
		}

}

/*	@Test(groups = { "reg", "smoke" })
	public void loadContact() {
		System.out.println("Load Contact");
	}

	@Test(groups = "reg")
	public void verifyContact() {
		System.out.println("Verify contact");
	}

}
*/
