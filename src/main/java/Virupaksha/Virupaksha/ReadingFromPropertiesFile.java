package Virupaksha.Virupaksha;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\S Vishnu\\eclipse-workspace\\Virupaksha\\src\\main\\java\\MyData\\data.properties");
		Properties p = new Properties();
		p.load(fis);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		driver.findElement(By.id("email")).sendKeys(p.getProperty("username"));
		driver.findElement(By.id("pass")).sendKeys(p.getProperty("password"));
		driver.findElement(By.name("login")).click();
		
	}

}
