package GenericUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepositoryPOM.HomePage;
import ObjectRepositoryPOM.LoginPage;


public class BaseClass {
	

	/**
	 * This class consists of all the basic configuration annotations for 
	 * all the common actions
	 * @author Chaitra M
	 *
	 */
		
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtil pUtil = new PropertyFileUtil();
		WebDriverUtility wUtil = new WebDriverUtility();

		public WebDriver driver = null;
		
		/**creating static webdriver which will be used only for listener to take screenshot. making it static so that it can be called
		without creation of object or extending. it can be directly called with the help of class name**/
		
		
		public static WebDriver sdriver;

		// Step 1: Read all the necessary data

		
		@BeforeSuite(groups = "SmokeSuit")
		public void bsConfig() {
			System.out.println("====== db connection successful ======");
		}
		
		
		/* Read data from property File - Common Data */
		@Parameters("Browser")//holds a value
		@BeforeTest
		//@BeforeClass(alwaysRun = true)
		public void bcConfig(String BROWSER) throws Throwable {
//			String BROWSER = pUtil.getDataFromPropertyFile("BROWSER");
			String URL = pUtil.getDataFromPropertyFile("URL");
			
			
			
			// Step 2: Launch the browser - driver is acting based runtime data - RunTime
			// polymorphism
			if (BROWSER.equalsIgnoreCase("Chrome")) {
				//WebDriver.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println(BROWSER + " --- Browser launched");

			} else if (BROWSER.equalsIgnoreCase("firefox")) {
				//WebDriver.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println(BROWSER + " --- Browser launched");
			} 
			else if (BROWSER.equalsIgnoreCase("edge")) {
				//WebDriverManager.firefoxdriver().setup();
				driver = new EdgeDriver();
				System.out.println(BROWSER + " --- Browser launched");
			} 
			else {
				System.out.println("invalid Browser name");
			}

			wUtil.maximizeWindow(driver);
			wUtil.waitForWebElementsToLoad(driver);
			
			
			sdriver = driver;
			//used only for listener to take screenshot.

			// Step 3: Load the URL
			driver.get(URL);
		}
		
		@BeforeMethod
		public void bmConfig() throws Throwable {
			String USERNAME = pUtil.getDataFromPropertyFile("USERNAME");
			String PASSWORD = pUtil.getDataFromPropertyFile("PASSWORD");
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			System.out.println("==== Login Successful ====");
		}
		
		
		
		
		@AfterMethod(alwaysRun = true)
		public void amConfig() throws Throwable
		{
			HomePage hp = new HomePage(driver);
			hp.logOut(driver);
			
			System.out.println("==== Logout Successful ====");
		}
		
		
			
		//@AfterTest
		@AfterClass(alwaysRun = true)
		public void acConfig()
		{
			//driver.quit();
			System.out.println(" ========== Browser Closed ========");
		}
			
		
		@AfterSuite(alwaysRun = true)
		public void asConfig()
		{
			System.out.println("====== db connection closed ======");
		}
		
		

		
		
		
	}

		





