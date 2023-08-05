package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



/**
 * This class provides implementation to ITestListener interface of testng
 * @author Vishnu
 *
 */

public class ListenerImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//helps us get the name of the method, ull get to know what methos we are executing
		System.out.println("====Execution Started===="+methodName);
		
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("===Pass==="+methodName);
		
		test.log(Status.PASS, "===Pass==="+methodName);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("===Fail==="+methodName);
		
		System.out.println(result.getThrowable());//helps us print the exception for current script failure
		test.log(Status.INFO, result.getThrowable());
		
		test.log(Status.FAIL, "===Fail==="+methodName);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("===Skipped==="+methodName);
		System.out.println(result.getThrowable());
		
		/**
		 * take screenshot for failed test scripts- to attach with bug raising.
		 */
		
		WebDriverUtility wU = new WebDriverUtility();
		//JavaUtility jU = new JavaUtility();
		
		String screenShotName = methodName;
		/**
		 * driver should always come from baseclass because driver is present in baseclass and gets launched there itself.
		 */
		try {
			String path = wU.takeScreenShot(BaseClass.sdriver , screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("===Failed but success==="+methodName);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		//start of suite tag  --@Beforesuite
		System.out.println("====Suite execution started====");
		new JavaUtility();
		//Configure the extent report at the start of execution   
		/**should be system date from java utility**/
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+ JavaUtility.getRandomNumber()+".html");
		htmlreport.config().setDocumentTitle("Vtiger ExecutionReport");
		htmlreport.config().setReportName("Build 1 Vtiger execution report");
		htmlreport.config().setTheme(Theme.DARK);
		
		
		//Report generation
		 report = new ExtentReports();
		 report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base Platform", "Testing-env");
		report.setSystemInfo("Base BrowsURL", "http://localhost:888");
		report.setSystemInfo("Base OS", "windows");
		report.setSystemInfo(" Reporter", "Chethana");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//end of suite tag --@Aftersuite
		System.out.println("===Suite execution ended===");
		
		
		//Report generation, if flush is not used report wont be generated thinking there are classes or methods which are still supposed to be executed
		report.flush();
		
	}
	

}
