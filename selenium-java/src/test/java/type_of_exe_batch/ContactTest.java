package type_of_exe_batch;

import org.testng.annotations.Test;

public class ContactTest {
	@Test(groups = "reg")
	public void createContact() {
		System.out.println("Create contact");
	}

	@Test(groups = { "reg", "smoke" })
	public void loadContact() {
		System.out.println("Load Contact");
	}

	@Test(groups = "reg")
	public void verifyContact() {
		System.out.println("Verify contact");
	}

}
