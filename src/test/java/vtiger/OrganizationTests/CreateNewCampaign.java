package vtiger.OrganizationTests;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtil;
import GenericUtilities.WebDriverUtility;

	public class CreateNewCampaign {

		public static void main(String[] args) throws Throwable {
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
			String ORGNAME = eUtil.getDataFromExcelFileUtility("contact", 4, 2)+JavaUtility.getRandomNumber();
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
			
			//Step 5: Creating new campaign
			
			WebElement campaign = driver.findElement(By.id("qccombo"));
			campaign.click();
			Thread.sleep(1000);
			
			//step 6 : selecting new campaign
			Select sel = new Select(campaign);
			sel.selectByValue("Campaigns");
			Thread.sleep(1000);
			
			
			
			//step 7: sending the data
			driver.findElement(By.name("campaignname")).sendKeys(LASTNAME);
			Thread.sleep(1000);
			//
			WebElement campaignStatus = driver.findElement(By.name("campaignstatus"));
			Select sel1 = new Select(campaignStatus);
			sel1.selectByValue("Active");
			Thread.sleep(1000);
			
			
			driver.findElement(By.xpath("//img[@style=\"cursor:hand;cursor:pointer\"]")).click();
			
			driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.id("1")).click();
			
			WebElement campaignType = driver.findElement(By.name("campaigntype"));
			Select sel2 = new Select(campaignType);
			sel2.selectByValue("Webinar");
			Thread.sleep(1000);
			
			
			driver.findElement(By.name("button")).click();

		}

	}



