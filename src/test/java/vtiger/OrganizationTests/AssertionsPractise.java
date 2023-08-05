package vtiger.OrganizationTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractise {
	@Test
	public void sampleTest() {
		int a = 2;
		int b = 1;
		
		SoftAssert sa = new SoftAssert();
		System.out.println("Stat1");
		System.out.println("STat2");
		sa.assertEquals(a, b);
		System.out.println("Execution and validn completed");
		sa.assertAll();
	}

}
