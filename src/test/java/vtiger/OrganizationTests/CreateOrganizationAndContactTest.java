//package vtiger.OrganizationTests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import GenericUtilities.BaseClass;
//import GenericUtilities.ExcelFileUtility;
//import GenericUtilities.JavaUtility;
//import GenericUtilities.PropertyFileUtil;
//import GenericUtilities.WebDriverUtility;
////import ObjectRepositoryPOM.BaseClass;
//import ObjectRepositoryPOM.LoginPage;
//import ObjectRepositoryPOM.OrganizationPage;
//
//public class CreateOrganizationAndContactTest extends BaseClass {
//	
//	JavaUtility jUtil = new JavaUtility();
//	ExcelFileUtility eUtil = new ExcelFileUtility();
//	PropertyFileUtil pUtil = new PropertyFileUtil();
//	WebDriverUtility wUtil = new WebDriverUtility(); 
//	
//	WebDriver driver = null;
//
//	// Step 1: Read all the necessary data
//
//	/* Read data from property File - Common Data */
//	String BROWSER = pUtil.getDataFromPropertyFile("BROWSER");
//	String URL = pUtil.getDataFromPropertyFile("URL");
//	String USERNAME = pUtil.getDataFromPropertyFile("USERNAME");
//	String PASSWORD = pUtil.getDataFromPropertyFile("PASSWORD");
//	
//
//	/* Read Data from Excel sheet - Test data */
////	String ORGNAME = eUtil.getDataFromExcelFileUtility("contact", 4, 2)+jUtil.getRandomNumber();
////	String LASTNAME = eUtil.getDataFromExcelFileUtility("contact", 4, 2);
//
//	// Step 2: Launch the browser - driver is acting based runtime data - RunTime
//	// polymorphism
//	if (BROWSER.equalsIgnoreCase("Chrome")) {
////		WebDriver.chromedriver().setup();
//		driver = new ChromeDriver();
//		System.out.println(BROWSER + " --- Browser launched");
//
//	} else if (BROWSER.equalsIgnoreCase("firefox")) {
//		//WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//		System.out.println(BROWSER + " --- Browser launched");
//	} 
//	else if (BROWSER.equalsIgnoreCase("edge")) {
//		//WebDriverManager.firefoxdriver().setup();
//		driver = new EdgeDriver();
//		System.out.println(BROWSER + " --- Browser launched");
//	} 
//	else {
//		System.out.println("invalid Browser name");
//	}
//
//	wUtil.maximizeWindow(driver);
//	wUtil.waitForWebElementsToLoad(driver);
//
//	// Step 3: Load the URL
//	driver.get(URL);
//
//	
//	
//	
//
//}
//}
