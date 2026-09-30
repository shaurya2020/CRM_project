package type_of_exe;

import org.testng.annotations.Test;

public class LeadTest {
	
	@Test(groups = {"reg","smoke"})
	public void createLead() {
		System.out.println("Create lead");
	}
	@Test(groups = "smoke")
	public void loadlead() {
		System.out.println("load lead");
	}
	@Test(groups = "smoke")
	public void verifyLead() {
		System.out.println("Verify Lead");
	}

}
