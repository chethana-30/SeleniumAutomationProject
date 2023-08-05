package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for IRetryAnalyser interface
 * @author Vishnu
 *
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	
	int count = 1;
	int retryCount = 3;
	

	@Override
	/**
	 * will not retry until we ask it to, so return is false
	 * if the result is pass this doesnt work, else it works
	 */
	public boolean retry(ITestResult result) {
		
		while(count<=retryCount) {
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
