package vtiger.OrganizationTests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtil;
import GenericUtilities.WebDriverUtility;
//import ObjectRepositoryPOM.BaseClass;

//import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateOrgWithIndustryUsingDDT_GU extends BaseClass {
     @Test(groups = "SmokeSuit")
	public  void createOrgWithIndustry() throws Throwable {
		
		//Create object of required Utilities
		//JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtil pUtil = new PropertyFileUtil();
		WebDriverUtility wUtil = new WebDriverUtility();
//
		WebDriver driver = null;
//
//		// Step 1: Read all the necessary data
//
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

		// Step 4: Login to the Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
//	
//		
		
		
		
	
		
		
		
		
		
		
		  
		

		// Step 5: Click on Organizations Link
		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 6: create Organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 7: Choose 'Chemicals' in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
//		wUtil.handleDropDown(industryDropDown, INDUSTRY);
		Select select = new Select(industryDropDown);
		select.selectByValue("Chemicals");
		

		// Step 8: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 9: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(OrgHeader);
		} else {
			System.out.println("Fail");
		}
		/**
		 * Creating Contact
		 */
		//Step:10  Creating contact
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step:11 Navigate to create contact look up image
		driver.findElement(By.xpath("//img[@alt = \"Create Contact...\"]")).click();
		
		//Step 12:Create a contact with mandatory information
		driver.findElement(By.xpath("//input[@name = \"lastname\"]")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		//Step 13: Switch to child window:
		wUtil.switchToWindow(driver, "ACCOUNTS");
		
		//Step 14: SEARCH FOR ORGANIZATION
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click(); // dynamic xpath
		
		//Step 15:Switch the control back to parent window
		wUtil.switchToWindow(driver, "Contacts");
		
		
		//Step 16: save the contact
		driver.findElement(By.name("button")).click();
		
		
		// Step 17: Validate for organization
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(ContactHeader);
		} else {
			System.out.println("Fail");
		}
		// Step 18: Logout of Application
		driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text() = \"Sign Out\"]")).click();
		
		/**
		 * not required
		 */
//		  WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		 wUtil.mouseHoverAction(driver, AdminImg);
// 		 driver.findElement(By.linkText("Sign Out")).click();
//		
//		driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[text() = \"Sign Out\"]")).click();
//		System.out.println("Logout successfull");

	}
     
     @Test(groups = "SmokeSuit")
     public void sample() {
    	 System.out.println("Sample");
     }

}



