package vtiger.OrganizationTests;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtil;
import GenericUtilities.WebDriverUtility;

	public class CreateOpportunities {
        @Test(groups = "SmokeSuit")
		public void createOpportunities() throws Throwable {
			// TODO Auto-generated method stub
			//JavaUtility jUtil = new JavaUtility();
			ExcelFileUtility eUtil = new ExcelFileUtility();
			PropertyFileUtil pUtil = new PropertyFileUtil();
			WebDriverUtility wUtil = new WebDriverUtility(); 
			
			WebDriver driver = null;

			// Step 1: Read all the necessary data

			/* Read data from property File - Common Data */
			String BROWSER = pUtil.getDataFromPropertyFile("BROWSER");
			String URL = pUtil.getDataFromPropertyFile("URL");
			String USERNAME = pUtil.getDataFromPropertyFile("USERNAME");
			String PASSWORD = pUtil.getDataFromPropertyFile("PASSWORD");
			

			/* Read Data from Excel sheet - Test data */
			//String ORGNAME = eUtil.getDataFromExcelFileUtility("contact", 4, 2)+JavaUtility.getRandomNumber();
			String LASTNAME = eUtil.getDataFromExcelFileUtility("contact", 4, 2);

			// Step 2: Launch the browser - driver is acting based runtime data - RunTime
			// polymorphism
			if (BROWSER.equalsIgnoreCase("Chrome")) {
//				WebDriver.chromedriver().setup();
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
			Reporter.log("Application has been logged in ");
			
			//Step5:
			driver.findElement(By.linkText("Opportunities")).click();
			
			driver.findElement(By.xpath("//img[@title= \"Create Opportunity...\"]")).click();
			
			WebElement relatedTo = driver.findElement(By.name("related_to_type"));
			wUtil.selectByValue(relatedTo, "Contacts");
			
			driver.findElement(By.xpath("//img[@style = \"cursor:hand;cursor:pointer\"]")).click();
			
			driver.findElement(By.name("potentialname")).sendKeys(LASTNAME);
			
	        wUtil.switchToWindow(driver, "Contacts");
	        
			driver.findElement(By.name("search_text")).sendKeys(LASTNAME);
			
			WebElement inDropDown = driver.findElement(By.name("search_field"));
			wUtil.selectByValue(inDropDown, "account_id");
			
			driver.findElement(By.name("search")).click();
			
			driver.findElement(By.linkText("Chethana")).click();
			
			wUtil.switchToWindow(driver, "Potentials");
			
			 driver.findElement(By.name("button")).click();
			   Thread.sleep(2000);
			   driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]")).click();
			   Thread.sleep(1000);
			   driver.findElement(By.xpath("//a[text() = \"Sign Out\"]")).click();
			   
			   
		}
        
        @Test
        public void demoTest() {
        	System.out.println("demo");
        }

	}



