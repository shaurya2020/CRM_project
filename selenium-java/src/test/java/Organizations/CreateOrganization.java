package Organizations;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import crm_reop.LoginPage;
import crm_reop.OrgPage;
import crm_reop.SignOut;
import crm_reop.VeryOrgPage;
import genric_utility.FileUtility;
import genric_utility.JavaUtility;
import genric_utility.WebDriverUtility;

public class CreateOrganization {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		json
		String browser = FileUtility.GetDataFJsonFile("bro");
		String url = FileUtility.GetDataFJsonFile("url");
		String username = FileUtility.GetDataFJsonFile("un");
		String password = FileUtility.GetDataFJsonFile("pwd");
		
//		java utility
		JavaUtility jd = new JavaUtility();
		int zs = jd.generateRandomNumber(1000);

//		fetch data from Excell
		
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
		
		LoginPage Lg = new LoginPage(driver);
		OrgPage Og = new OrgPage(driver);
		
//		driver.findElement(By.name("user_name")).sendKeys(username);
		WebElement userName = Lg.getusername();
		userName.sendKeys(username);
		
//		driver.findElement(By.name("user_password")).sendKeys(password);
		WebElement Password = Lg.getPassword();
		Password.sendKeys(password);
		
//		driver.findElement(By.cssSelector("[id='submitButton']")).click();
		WebElement button = Lg.getbutton();
		button.click();


		Thread.sleep(3000);
		
		
		
//		WebElement module = driver.findElement(By.linkText("Organizations"));
		WebElement module = Og.getLink();
		module.click();

//		WebElement mod = driver.findElement(By.cssSelector("[alt='Create Organization...']"));
		WebElement mod = Og.getCss();
		mod.click();

//		WebElement OrgNam = driver.findElement(By.name("accountname"));
		WebElement OrgNam = Og.getAccname();
		OrgNam.sendKeys(accountName);

//		Random r = new Random();
//		String Num = "9140050" + r.nextInt(1000);
		
		JavaUtility jds = new JavaUtility();
		int jz = jds.generateRandomNumber(1000);
		String Num = "9140050" + jz;
//		WebElement phone = driver.findElement(By.id("phone"));
		WebElement phone = Og.getPhone();
		phone.sendKeys(Num);

//		WebElement Email = driver.findElement(By.id("email1"));
		WebElement Email = Og.getEmail();
		Email.sendKeys(email);

//		WebElement Ind = driver.findElement(By.name("industry"));
		String sell ="Education";
		WebElement Ind = Og.getIndustry();
		WebDriverUtility sg = new WebDriverUtility(driver);
		sg.select(Ind, sell);
		
//		Select sel = new Select(Ind);
//		sell.selectByValue(sell);

//		WebElement Type = driver.findElement(By.name("accounttype"));
		String cs ="Customer";
		WebElement Type = Og.getAccounttype();
		WebDriverUtility Tys = new WebDriverUtility(driver);
		Tys.select(Type, cs);
//		Select Typ = new Select(Type);
//		Typ.selectByValue("Customer");

//		driver.findElement(By.name("button")).click();
		WebElement but = Og.getButton();
		but.click();
		
//Velidation
		VeryOrgPage os = new VeryOrgPage(driver);
//		String VOrgNam = driver.findElement(By.id("dtlview_Organization Name")).getText();
		String VOrgNam = os.getOrgname().getText();
//		String Vphone = driver.findElement(By.id("dtlview_Phone")).getText();;
		String Vphone = os.getPhone().getText();
//		String VEmail = driver.findElement(By.id("dtlview_Email")).getText();;
		String VEmail = os.getEmail().getText();;
//		String VInd = driver.findElement(By.id("dtlview_Industry")).getText();;
		String VInd = os.getIndustery().getText();;
//		String Vtype = driver.findElement(By.id("dtlview_Type")).getText();;
		String Vtype = os.getType().getText();

		if (VOrgNam.equals(accountName)) {
		    System.out.println("PASS: Organization Name is matched");
		} else {
		    System.out.println("FAIL: Organization Name is not matched");
		}

		if (Vphone.equals(Num)) {
		    System.out.println("PASS: Phone is matched");
		} else {
		    System.out.println("FAIL: Phone is not matched");
		}

		if (VEmail.equals(email)) {
		    System.out.println("PASS: Email is matched");
		} else {
		    System.out.println("FAIL: Email is not matched");
		}

		if (VInd.equals(sell)) {
		    System.out.println("PASS: Industry is matched");
		} else {
		    System.out.println("FAIL: Industry is not matched");
		}

		if (Vtype.equals(cs)) {
		    System.out.println("PASS: Type is matched");
		} else {
		    System.out.println("FAIL: Type is not matched");
		}
//		WebElement profile = driver.findElement(By.cssSelector("[src=\'themes/softed/images/user.PNG\']"));
		SignOut sn = new SignOut(driver);
		WebElement profile = sn.getPro();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.hover(profile);

//		driver.findElement(By.linkText("Sign Out")).click();
		WebElement Out = sn.getSingnOut();
		Out.click();

		driver.quit();
	}

}
