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

	public class CreateProduct {

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
			
			
			//Step 5: Click on Product
			driver.findElement(By.linkText("Products")).click();
			
			//step6 : Click on add product
			driver.findElement(By.xpath("//img[@alt = \"Create Product...\"]")).click();
			
			//step 7 : Give the product name
			driver.findElement(By.name("productname")).sendKeys(ORGNAME);
			
			//steep 8 : Use the element from Select drop down
			WebElement GLaccount = driver.findElement(By.name("glacct")) ;
			Select select = new Select(GLaccount);
			select.selectByValue("303-Interest-Income");
			
			//step 9 : Save
			driver.findElement(By.name("button")).click();


		}

	}



