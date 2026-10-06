package learning_baseclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base_test {
	@BeforeClass
	public void setup() {
		System.out.println("Open browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("Login");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout");
	}
	@AfterClass
	public void teardown() {
		System.out.println("Tear Down");
	
	}

}
