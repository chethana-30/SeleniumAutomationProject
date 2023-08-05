package vtiger.OrganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtil;
import GenericUtilities.WebDriverUtility;
//import ObjectRepositoryPOM.BaseClass;
import ObjectRepositoryPOM.ContactInfoPage;
import ObjectRepositoryPOM.ContactPage;
import ObjectRepositoryPOM.HomePage;
import ObjectRepositoryPOM.LoginPage;
import ObjectRepositoryPOM.OrganizationPage;
@Listeners(GenericUtilities.ListenerImplementationClass.class)//when listener interface is used for implemenation class,even in the script listener annotation must be used
public class CreateContactWithOrganizationTest{
	
	@Test
	public  void createContactWithOrganization() throws Throwable {
		//Create object of required Utilities
		//JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtil pUtil = new PropertyFileUtil();
		WebDriverUtility wUtil = new WebDriverUtility();

		WebDriver driver = null;
//
		// Step 1: Read all the necessary data

		/* Read data from property File - Common Data */
		String BROWSER = pUtil.getDataFromPropertyFile("BROWSER");
		String URL = pUtil.getDataFromPropertyFile("URL");
		String USERNAME = pUtil.getDataFromPropertyFile("USERNAME");
		String PASSWORD = pUtil.getDataFromPropertyFile("PASSWORD");
		
		

		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eUtil.getDataFromExcelFileUtility("contact", 4, 2)+JavaUtility.getRandomNumber();
		String LASTNAME = eUtil.getDataFromExcelFileUtility("contact", 4, 2);

		// Step 2: Launch the browser - driver is acting based runtime data - RunTime
		// polymorphism
		if (BROWSER.equalsIgnoreCase("Chrome")) {
//			WebDriver.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " --- Browser launched");

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
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

		// Step 3: Load the URL
		driver.get(URL);
		
		
		//Step4: Login
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("Logged into Application");
//		
//		

		// Step 5: Click on Organizations Link and Create Organization look up image
		  HomePage hp = new HomePage(driver);
		  hp.getOrganizationPage();
		  hp.addOrganization();
		  Reporter.log("HomePageClicked");
		  

	
		// Step 6: create Organization
		  OrganizationPage op = new OrganizationPage(driver);
		  
		  op.addNewOrganization(ORGNAME);
		  
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//img[@style = \"width:16px;height:16px;\"]")).click();
		  
		  Reporter.log("Adding the organization");
		  
		  //Step 7: Add Contacts
		  hp.addContact();
		  
		  //Step 8: Click on Add Contact icon
		  ContactPage cp = new ContactPage(driver);
		  cp.clickOnAddContactIcon();
		  
		  //Step 9: Add contact details
		  ContactInfoPage cip = new ContactInfoPage(driver);
		  cip.creatingNewContact(LASTNAME, driver, ORGNAME);
		  
		  Reporter.log("Contact details added");
		  
		  Thread.sleep(3000);
		  
		  //Step10: Logout
		  hp.logOut(driver);
//
//		  op.backToHomePage(driver);
//		  hp.logOut(driver);
//		  WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		      wUtil.mouseHoverAction(driver, AdminImg);
// 		  driver.findElement(By.linkText("Sign Out")).click();
//	
		  
		  
	
	
	
	

	
	

}
	
	@Test
	public void demoTest() {
		//Assert.fail();
		System.out.println("demo");
	}
}
