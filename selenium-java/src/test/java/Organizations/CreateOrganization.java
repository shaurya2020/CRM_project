package Organizations;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genric_utility.FileUtility;
import genric_utility.JavaUtility;
import genric_utility.WebDriverUtility;

public class CreateOrganization {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		String browser = FileUtility.GetDataFJsonFile("bro");
		String url = FileUtility.GetDataFJsonFile("url");
		String username = FileUtility.GetDataFJsonFile("un");
		String password = FileUtility.GetDataFJsonFile("pwd");
		
		JavaUtility jd = new JavaUtility();
		int zs = jd.generateRandomNumber(1000);
		
		String accountName = FileUtility.GetDataExcellFile("ORGname", 4, 0)+ zs;
		String email = FileUtility.GetDataExcellFile("ORGname", 5, 4);

		WebDriver driver = null;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(url);

		Thread.sleep(1000);

		driver.findElement(By.name("user_name")).sendKeys(username);

		driver.findElement(By.name("user_password")).sendKeys(password);

		driver.findElement(By.cssSelector("[id='submitButton']")).click();

		Thread.sleep(3000);

		WebElement module = driver.findElement(By.linkText("Organizations"));
		module.click();

		WebElement mod = driver.findElement(
				By.cssSelector("[alt='Create Organization...']"));
		mod.click();

		WebElement OrgNam = driver.findElement(By.name("accountname"));
		OrgNam.sendKeys(accountName);

		Random r = new Random();
		String Num = "9140050" + r.nextInt(1000);

		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys(Num);

		WebElement Email = driver.findElement(By.id("email1"));
		Email.sendKeys(email);

		WebElement Ind = driver.findElement(By.name("industry"));

		Select sel = new Select(Ind);
		sel.selectByValue("Communications");

		WebElement Type = driver.findElement(By.name("accounttype"));

		Select Typ = new Select(Type);
		Typ.selectByValue("Customer");

		driver.findElement(By.name("button")).click();

		WebElement VOrgNam = driver.findElement(
				By.cssSelector("[id='dtlview_Organization Name']"));

		WebElement Vphone = driver.findElement(
				By.id("dtlview_Phone"));

		WebElement VEmail = driver.findElement(
				By.id("dtlview_Email"));

		WebElement VInd = driver.findElement(
				By.id("dtlview_Industry"));

		WebElement Vtype = driver.findElement(
				By.id("dtlview_Type"));

		if (VOrgNam.equals(OrgNam) &&
				Vphone.equals(phone) &&
				VEmail.equals(Email) &&
				VInd.equals(Ind) &&
				Vtype.equals(Type)) {

			// Organization creation successful

		} else {

			// Organization creation failed

		}

		WebElement profile = driver.findElement(
				By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"));

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.hover(profile);

		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}


}
