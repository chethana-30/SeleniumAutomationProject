package vtiger.OrganizationTests;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtil;
import GenericUtilities.WebDriverUtility;

	
	public class CreateNewOrganizationwithSelect {
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
			//String LASTNAME = eUtil.getDataFromExcelFileUtility("contact", 4, 2);

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
			
			
			//Step5: 
			// Step 5: Click on Organizations Link
				driver.findElement(By.linkText("Organizations")).click();
			  

					// Step 6: click on Create Organization look up image
					driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	              
			   
//					// Step 6: create Organization
				    driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
					
					//Step7: 
					WebElement industry = driver.findElement(By.name("industry"));
					wUtil.selectByValue(industry, "Energy");
					
					//Step 8:
				   WebElement type = driver.findElement(By.name("accounttype"));
				   wUtil.selectByValue(type, "Customer");
//				   
//				   //Step9:Save
			       driver.findElement(By.name("button")).click();
				   Thread.sleep(2000);
				   
				   //Step10.Logout
				   WebElement admin = driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]"));
				   wUtil.mouseHoverAction(driver, admin);
//				   
				   WebElement signOut = driver.findElement(By.linkText("Sign Out"));
	         	   wUtil.mouseHoverAction(driver, signOut);
				   signOut.click();
				   
				   driver.findElement(By.linkText("Organizations")).click();
				   
				  
				   driver.findElement(By.id("27")).click();
				   driver.findElement(By.xpath("//input[@onclick=\"return massDelete('Accounts')\"]")).click();
				   Thread.sleep(1000);
			   
				   
				   driver.findElement(By.id("28")).click();
				   driver.findElement(By.xpath("//input[@onclick=\"return massDelete('Accounts')\"]")).click();
				   
				   driver.findElement(By.id("29")).click();
				   driver.findElement(By.xpath("//input[@onclick=\"return massDelete('Accounts')\"]")).click();
				   
				   
				   
				   driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]")).click();
				   Thread.sleep(1000);
				   driver.findElement(By.xpath("//a[text() = \"Sign Out\"]")).click();
				   
				   
				   driver.close();
				
				   
				  
					


			
		}
		
		

	}



