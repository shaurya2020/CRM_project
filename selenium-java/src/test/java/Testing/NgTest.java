package Testing;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class NgTest {

	public static void main(String[] args) {
			System.out.println("hi there is ....");
	}
	@Test
	public void createOrg() {
		Reporter.log("hi there ...., true");	
	}
	
	@Test
	public void cratecontact() {
		Reporter.log("this is pass");
	}
	
	@Test
	public void createlead() {
		Reporter.log("this is pass");
	}
	
	@Test
	public void createopp() {
		Reporter.log("this is pass");
	}

}
