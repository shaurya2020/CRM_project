package Contacts;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
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
		
		String FirstName = "Ayuu";
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys(FirstName);
		
		String LastName = "Khayu";
		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.sendKeys(LastName);
		
		WebElement lead = driver.findElement(By.name("leadsource"));
		Select As = new Select(lead);
		As.selectByValue("Employee");
		
//		long ran = System.currentTimeMillis();
		Random Sr = new Random();
		String Email = "ayush" + Sr.nextInt(1000)+ "@gmail.com";
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(Email);
		
		WebElement Date = driver.findElement(By.id("jscal_trigger_birthday"));
		Date.click();
		
		driver.findElement(By.xpath("//td[@class='day' and text()='10']")).click();
		
		WebElement assistant = driver.findElement(By.id("assistant"));
		assistant.sendKeys("Chota bhai");
		
		WebElement assistphone = driver.findElement(By.id("assistantphone"));
		assistphone.sendKeys("9191919191");
		
		
		driver.findElement(By.name("button")).click();
		
//		velidation
		
		String actfirstName = driver.findElement(By.id("dtlview_First Name")).getText();
		String actlastName = driver.findElement(By.id("dtlview_Last Name")).getText();
//		String actlead = driver.findElement(By.id("dtlview_Lead Source")).getText();
//		String actEmail = driver.findElement(By.id("dtlview_Email")).getText();
//		String actDate = driver.findElement(By.id("dtlview_Birthdate")).getText();
//		String actAssist = driver.findElement(By.id("dtlview_Assistant")).getText();
//		String actAssisPhone = driver.findElement(By.id("dtlview_Assistant Phone")).getText();
		
		if(actfirstName.equals(FirstName)) {
			System.out.println("fist name is okey");
		} else
		{
			System.out.println("fist name is not print");
		}
		
		
		if(actlastName.equals(LastName)){
			System.out.println("lastname is okey");
		} else
		{
			System.out.println("lastname is not print");
		}
		driver.quit();
		
	}
	

}
