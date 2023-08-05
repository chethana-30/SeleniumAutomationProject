package vtiger.OrganizationTests;


	import java.io.FileInputStream;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Vtiger{
		public static void main(String[] args) throws Throwable  {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			FileInputStream fis = new FileInputStream("C:\\Users\\S Vishnu\\eclipse-workspace\\Virupaksha\\src\\main\\java\\MyData\\data.properties");
			Properties p = new Properties();
			p.load(fis);
			driver.get(p.getProperty("URL"));
			driver.findElement(By.name("user_name")).sendKeys(p.getProperty("USERNAME"));
			Thread.sleep(1000);
			driver.findElement(By.name("user_password")).sendKeys(p.getProperty("PASSWORD"));
			Thread.sleep(1000);
			driver.findElement(By.id("submitButton")).submit();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text() = \"Contacts\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//img[@title = \"Create Contact...\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("firstname")).sendKeys("chethana");
			Thread.sleep(1000);
			driver.findElement(By.name("lastname")).sendKeys("Sharaff");
//			driver.findElement(By.xpath("//img[@alt = \"Select\"]")).click();
//			driver.findElement(By.id("1")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("account_name")).sendKeys("VaccumTech");
			Thread.sleep(1000);
			driver.findElement(By.name("button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//img[@border=\"0\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text() = \"Contacts\"]")).click();
//			Thread.sleep(1000);
			driver.findElement(By.id("8")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			
			driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text() = \"Sign Out\"]")).click();
			
		}

	}


