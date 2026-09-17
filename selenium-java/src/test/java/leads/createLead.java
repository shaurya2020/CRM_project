package leads;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class createLead {

	public static void main(String[] args) {   
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/index.php");

//		log in

		WebElement user = driver.findElement(By.name("user_name"));
		user.sendKeys("admin");

		WebElement pass = driver.findElement(By.name("user_password"));
		pass.sendKeys("manager");

		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();

		WebElement module = driver.findElement(By.linkText("Leads"));

		module.click();

		WebElement mod = driver.findElement(By.cssSelector("img[alt='Create Lead...']"));
		mod.click();
		
		String LastName = "Khayu";
		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.sendKeys(LastName);
		
		WebElement Company = driver.findElement(By.name("company"));
		Company.sendKeys("Zudio");
		
		WebElement lead = driver.findElement(By.name("leadsource"));
		Select As = new Select(lead);
		As.selectByValue("Employee");
		
		WebElement Ind = driver.findElement(By.name("industry"));
		Select sel = new Select(Ind);
		sel.selectByValue("Communications");
		
		WebElement Phone = driver.findElement(By.id("phone"));
		Phone.sendKeys("91405056");
		
		driver.findElement(By.name("button")).click();
		
		WebElement profile = driver.findElement(
				By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
	}
	

}
    