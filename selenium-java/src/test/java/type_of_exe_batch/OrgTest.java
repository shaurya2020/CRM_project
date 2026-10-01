package type_of_exe_batch;

import org.testng.annotations.Test;

public class OrgTest {
	@Test(groups = {"reg","smoke"})
	public void createOrg() {
		System.out.println("create Org");
	}
	
	@Test(groups = "smoke")
	public void LoadOrg() {
		System.out.println("Load Org");
	}
	@Test(groups = "reg")
	public void VerifyOrg() {
		System.out.println("Load Org");
	}
}
