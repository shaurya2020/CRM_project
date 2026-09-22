package vtigers;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import genric_utility.FileUtility;

public class Opportunities {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		// TODO Auto-generated method stubs
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String url = FileUtility.GetDataFJsonFile("url");
		driver.get(url);
		
//		log in
		
		WebElement user = driver.findElement(By.name("user_name"));
		user.sendKeys("admin");
		
		WebElement pass = driver.findElement(By.name("user_password"));
		pass.sendKeys("manager");
		
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();
		
		
		WebElement module = driver.findElement(By.linkText("Opportunities"));
		
		module.click();
		
		WebElement mod = driver.findElement(By.cssSelector("img[alt='Create Opportunity...']"));
		mod.click();
		
//		form
		
		WebElement OppName = driver.findElement(By.name("potentialname"));
		OppName.sendKeys("Zudio");
		
/*	String PID = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//*[@id=\"basicTab\"]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/img")).click();
		
		Set<String> CIDs = driver.getWindowHandles();
		
		for (String i : CIDs) {
			driver.switchTo().window(i);
		}
		driver.findElement(By.id("1")).click();
		
		
		Thread.sleep(1000);
		driver.close();
		
	*/	
		WebElement related = driver.findElement(By.id("related_to_display"));
		related.sendKeys("old");
		
		WebElement amount = driver.findElement(By.name("amount"));
		amount.sendKeys("5000");
		
		WebElement ss = driver.findElement(By.name("opportunity_type"));
		Select singleselect = new Select(ss);
		singleselect.selectByValue("New Business");
		
		
		WebElement date = driver.findElement(By.name("closingdate"));
		date.sendKeys("2026/09/18");

		WebElement lead = driver.findElement(By.name("leadsource"));
		
		Select ld = new Select(lead);
		ld.selectByValue("Partner");
		
		WebElement Next_Step = driver.findElement(By.id("nextstep"));
		Next_Step.sendKeys("move on");
		
		
		WebElement Assigned = driver.findElement(By.name("assigned_user_id"));
		Select As = new Select(Assigned);
		As.selectByValue("1");
		
		WebElement Sales = driver.findElement(By.name("sales_stage"));
		Select sl = new Select(Sales);
		sl.selectByValue("Perception Analysis");
		
		WebElement Probability = driver.findElement(By.id("probability"));
		Probability.sendKeys("88%");
		
		
		Thread.sleep(20000);
		
		driver.quit();

	}

}
