package Pom_Extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import Object_repo.SauceDemoPage;

public class SacueDemoTest {
	
	public static void main(String[] args) {
		
		String url = "https://www.saucedemo.com/";
		String username = "standard_user";
		String password = "secret_sauce";

		String firstName = "Riya";
		String lastName = "Singh";
		String postalCode = "201301";

		WebDriver driver = null;
		
		driver = new EdgeDriver();
		

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
		
		SauceDemoPage sdp = new SauceDemoPage(driver);
		
		WebElement usernameField = sdp.getUsernameField();
		WebElement Passwordfield = sdp.getPasswordField();
		WebElement Button = sdp.getloginButton();
		
		
		usernameField.sendKeys(username);
		Passwordfield.sendKeys(password);
		Button.click();
		
		
		String inventoryUrl = driver.getCurrentUrl();
		
		if (inventoryUrl.contains("inventory.html"))
		{
		System.out.println("login pass");
		}else 
		{
			System.out.println("login Fail");
		}
		
		WebElement addtocart = sdp.getAddTocartButton();
		addtocart.click();
		
		
		String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
		
		if (cartCount.equals("1")) {
			System.out.println("[PASS] Cart contains 1 product.");
		} else {
			System.out.println("[FAIL] Product count verification failed.");
			throw new RuntimeException("Cart count is not 1.");
		}

		
		driver.findElement(By.className("shopping_cart_link")).click();

		if (driver.getCurrentUrl().contains("cart.html")) {
			System.out.println("[PASS] Cart page URL verified.");
		} else {
			System.out.println("[FAIL] Cart page verification failed.");

		}
		
		String productName = driver.findElement(By.className("inventory_item_name")).getText();
		
		if (productName.equals("Sauce Labs Backpack")) {
			System.out.println("[PASS] Product verified in cart: " + productName);
		} else {
			System.out.println("[FAIL] Expected product not found in cart.");
			throw new RuntimeException("Product verification failed.");
		}
		
		driver.findElement(By.id("checkout")).click();
		
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		driver.findElement(By.id("postal-code")).sendKeys(postalCode);
		driver.findElement(By.id("continue")).click();
		
		String checkoutProduct = driver.findElement(By.className("inventory_item_name")).getText();

		if (checkoutProduct.equals("Sauce Labs Backpack")) {
			System.out.println("[PASS] Product verified on checkout overview.");
		} else {
			System.out.println("[FAIL] Product verification failed.");
			throw new RuntimeException("Product missing from checkout overview.");
		}
		

		driver.findElement(By.id("finish")).click();
		
		String confirmationMessage = driver.findElement(By.className("complete-header")).getText();

		if (confirmationMessage.equals("Thank you for your order!")) {

			System.out.println("[PASS] Order placed successfully.");

		} else {

			System.out.println("[FAIL] Order confirmation verification failed.");
		}
		
		driver.findElement(By.id("react-burger-menu-btn")).click();

		driver.findElement(By.id("logout_sidebar_link")).click();

		if (driver.getCurrentUrl().equals(url)) {

			System.out.println("[PASS] Logout successful.");
			System.out.println("[INFO] User returned to Login page.");

		} else {

			System.out.println("[FAIL] Logout verification failed.");

			throw new RuntimeException("User was not redirected to Login page.");
		}
		driver.quit();
		}
	}


