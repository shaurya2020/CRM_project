package Contacts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class createContacts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		driver.get("http://localhost:8888/index.php");
		
//		log in
		
		WebElement user = driver.findElement(By.name("user_name"));
		user.sendKeys("admin");
		
		WebElement pass = driver.findElement(By.name("user_password"));
		pass.sendKeys("manager");
		
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();
		
		
		WebElement module = driver.findElement(By.linkText("Contacts"));
		module.click();
		
		WebElement addicon = driver.findElement(By.cssSelector("img[alt=\'Create Contact...\']"));
		addicon.click();
		
//		main
		
		
		WebElement firstname = driver.findElement(By.name("firstname"));
		
		String LastName = "Khayu";
		WebElement lastname = driver.findElement(By.name("lastname"));
		firstname.sendKeys("Ayuu");
		lastname.sendKeys(LastName);
		
//		PPopups
		String PID2 = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
		
		Set<String> CID2 = driver.getWindowHandles();
		
		for (String i : CID2) {
			driver.switchTo().window(i);
		}
		
		driver.findElement(By.id("3")).click();
		Thread.sleep(2000);
		
		driver.switchTo().window(PID2);
		
		
		WebElement ld = driver.findElement(By.name("leadsource"));
		Select sel = new Select(ld);
		sel.selectByValue("Employee");
		
		
		
		
//		then
		
		WebElement phone = driver.findElement(By.id("phone"));
		WebElement mobile = driver.findElement(By.id("mobile"));
		WebElement homephone = driver.findElement(By.id("homephone"));
		WebElement otherphone = driver.findElement(By.id("otherphone"));
		phone.sendKeys("1234567892");
		mobile.sendKeys("1234567893");
		homephone.sendKeys("1234567894");
		otherphone.sendKeys("1234567895");
		
		
		WebElement title = driver.findElement(By.id("title"));
		title.sendKeys("New Tile");
		WebElement department = driver.findElement(By.id("department"));
		department.sendKeys("Main");
		
		String Email ="ayush@gmail.com";
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(Email);
		
		WebElement assistant = driver.findElement(By.id("assistant"));
		assistant.sendKeys("Chota bhai");
		WebElement assistantphone = driver.findElement(By.id("assistantphone"));
		assistantphone.sendKeys("9191919191");
		
		
	
		
		WebElement mailingstreet= driver.findElement(By.name("mailingstreet"));
		mailingstreet.sendKeys("ag");
		WebElement otherstreet = driver.findElement(By.name("otherstreet"));
		otherstreet.sendKeys("he");
		WebElement mailingpobox = driver.findElement(By.name("mailingpobox"));
		mailingpobox.sendKeys("hee");
		WebElement otherpobox = driver.findElement(By.name("otherpobox"));
		otherpobox.sendKeys("ag");
		WebElement mailingcity = driver.findElement(By.name("mailingcity"));
		mailingcity.sendKeys("ag");
		WebElement othercity = driver.findElement(By.name("othercity"));
		othercity.sendKeys("ag");
		WebElement mailingstate = driver.findElement(By.name("mailingstate"));
		mailingstate.sendKeys("ag");
		WebElement otherstate = driver.findElement(By.name("otherstate"));
		otherstate.sendKeys("new");
		WebElement mailingzip = driver.findElement(By.name("mailingzip"));
		mailingzip.sendKeys("ag");
		WebElement otherzip = driver.findElement(By.name("otherzip"));
		otherzip.sendKeys("ag");
		WebElement mailingcountry = driver.findElement(By.name("mailingcountry"));
		mailingcountry.sendKeys("hew");
		WebElement othercountry = driver.findElement(By.name("othercountry"));
		othercountry.sendKeys("ag");

	
		
		WebElement description = driver.findElement(By.name("description"));
		description.sendKeys("its is done");
		
		
//		save
																
		
		
		
//		Verification
		WebElement Vassistant = driver.findElement(By.id("assistant"));
		if(Vassistant.equals(assistant))
		{
			System.out.println("Vassistant is okey");
		}else {
			System.out.println("Vassistant is not okey");
		}
		

		WebElement Vassistantphone = driver.findElement(By.id("dtlview_Assistant Phone"));
		if(Vassistantphone.equals(assistantphone))
		{
			System.out.println("Vassistantphoneis okey");
		}else {
			System.out.println("Vassistantphone is not okey");
		}
		
		WebElement Vmailingstreet= driver.findElement(By.name("mailingstreet"));
		if (mailingstreet.equals(Vmailingstreet))
		{
			System.out.println("Vmailingstreet is okey");
		}else {
			System.out.println("Vmailingstreet is not okey");
		}
		
		WebElement Votherstreet = driver.findElement(By.name("otherstreet"));
		if(otherstreet.equals(Votherstreet))
		{
			System.out.println("Votherstreet is okey");
		}else {
			System.out.println("Votherstreet is not okey");
		}
		
		WebElement Vmailingpobox = driver.findElement(By.name("mailingpobox"));
		if(mailingpobox.equals(Vmailingpobox))
		{
			System.out.println("Vmailingpobox is okey");
		}else {
			System.out.println("Vmailingpobox is not okey");
		}
		WebElement Votherpobox = driver.findElement(By.name("otherpobox"));
		if(otherpobox.equals(Votherpobox))
		{
			System.out.println("Vmailingpobox is okey");
		}else {
			System.out.println("Vmailingpobox is not okey");
		}
		WebElement Vmailingcity = driver.findElement(By.name("mailingcity"));
		if (mailingcity.equals(Vmailingcity))
		{
			System.out.println("Vmailingpobox is okey");
		}else {
			System.out.println("Vmailingpobox is not okey");
		}
		
		WebElement Vothercity = driver.findElement(By.name("othercity"));
		if(othercity.equals(Vothercity))
		{
			System.out.println("Vmailingpobox is okey");
		}else {
			System.out.println("Vmailingpobox is not okey");
		}
		WebElement Vmailingstate = driver.findElement(By.name("mailingstate"));
		if(mailingstate.equals(Vmailingstate))
		{
			System.out.println("Vmailingpobox is okey");
		}else {
			System.out.println("Vmailingpobox is not okey");
		}
		WebElement Votherstate = driver.findElement(By.name("otherstate"));
		if(otherstate.equals(Votherstate))
		{
			System.out.println("Vmailingpobox is okey");
		}else {
			System.out.println("Vmailingpobox is not okey");
		}
		WebElement Vmailingzip = driver.findElement(By.name("mailingzip"));
		if(mailingzip.equals(Vmailingzip))
		{
			System.out.println("Vmailingpobox is okey");
		}else {
			System.out.println("Vmailingpobox is not okey");
		}
		WebElement Votherzip = driver.findElement(By.name("otherzip"));
		if(otherzip.equals(Votherzip))
		{
			System.out.println("Vmailingpobox is okey");
		}else {
			System.out.println("Vmailingpobox is not okey");
		}
		WebElement Vmailingcountry = driver.findElement(By.name("mailingcountry"));
		if(mailingcountry.equals(Vmailingcountry))
		{
			System.out.println("Vmailingpobox is okey");
		}else {
			System.out.println("Vmailingpobox is not okey");
		}
		
		WebElement Vothercountry = driver.findElement(By.name("othercountry"));
		if(othercountry.equals(Vothercountry))
		{
			System.out.println("Vothercountry is okey");
		}else {
			System.out.println("Vothercountry is not okey");
		}
		
		
		
		
		Thread.sleep(12000);
		
		driver.quit();

	}

}
