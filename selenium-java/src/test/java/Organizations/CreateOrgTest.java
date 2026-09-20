package Organizations;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
//		get the data from json file
		FileReader fr = new FileReader("./src/test/resources/cd.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject jObj = (JSONObject) obj;
		String browser = jObj.get("bro").toString();
		String url = jObj.get("url").toString();
		String username = jObj.get("un").toString();
		String password = jObj.get("pwd").toString();
	
		
		// get the data from Excel file
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("ORGname");
		Row row = sh.getRow(2);
		Cell cell = row.getCell(0);
		String orgName = cell.getStringCellValue();
	
//		open browser
		WebDriver driver = null;
		if (browser.equals("chrome")) {
		driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
			
//			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get(url);
			WebElement un = driver.findElement(By.name("user_name"));
			WebElement pwd = driver.findElement(By.name("user_password"));
			WebElement loginButton = driver.findElement(By.id("submitButton"));
			un.sendKeys(username);
			pwd.sendKeys(password);
			loginButton.click();
			
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
			
			WebElement orgField = driver.findElement(By.name("accountname"));
			orgField.sendKeys(orgName);
			
			
//			String Num = "9140050" ;
			
			driver.findElement(By.className("save")).click();
			
			String actOrgName = driver.findElement(By.id("dtlview_OrganizationName")).getText();
					if (actOrgName.equals(orgName)) {
					System.out.println("org created successfullyyyy !!!");
					} else {
					System.out.println("Could not create organization");
					
					
					
					WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
					Actions act = new Actions(driver);
					act.moveToElement(profile).build().perform();	
					driver.findElement(By.linkText("Sign Out")).click();
					Thread.sleep(3000);
					
					driver.quit();
					}
		}

}
