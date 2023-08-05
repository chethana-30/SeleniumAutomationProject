package vtiger.OrganizationTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractise {
	
	@Test(retryAnalyzer = GenericUtilities.RetryAnalyserImplementation.class)
	public void sample() {
		Assert.fail();
		System.out.println("HI");
	}

}
