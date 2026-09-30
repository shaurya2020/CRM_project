package type_of_exe;

import org.testng.annotations.Test;

public class OpptTest {
	@Test
	public void createOpp() {
		System.out.println("Create Opprtunity");
	}

	@Test(groups = {"reg","smoke"})
	public void loadOpp() {
		System.out.println("Load Opprtunity");
	}

	@Test(groups = "smoke")
	public void VerifyOpp() {
		System.out.println("Verify Opprtunity");
	}
}
