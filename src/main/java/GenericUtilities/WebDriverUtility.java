package GenericUtilities;


	import java.io.File;
	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.google.common.io.Files;

	/** 
	 * 
	 * This class will have all the re usuable methods for webdriver actions
	 * @author Vishnu
	 *
	 */

	/**
	 * Will maximize the window
	 * @author Vishnu
	 *
	 */
	public class WebDriverUtility {
		

		public void maximizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		
		/**
		 * will minimize thw window
		 * @param driver
		 */
		public void minimizeWindow(WebDriver driver) {
			driver.manage().window().minimize();
		}
		
		/**
		 * will wait for all the findElement and findElements 
		 * operations to be performed
		 * 
		 * @param driver
		 */
		public void waitForWebElementsToLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		
		
		public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
		/**
		 * This method will handle drop down using index
		 * @param element
		 * @param index
		 */
		public void handleDropDown(WebElement element, int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		/**
		 * This method will handle drop down using value
		 * @param element
		 * @param index
		 */
		
		public void handleDropDown(WebElement element, String value) {
			Select sel = new Select(element);
			sel.selectByValue(value);
		}
		
		/**
		 * This method will handle drop down using visible text
		 * @param element
		 * @param index
		 */
		public void handleDropDown(String text ,WebElement element) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);;
		} 
		
		
		/**
		 * Actions class to perform mouseover action
		 * @param driver
		 * @param element
		 */
		public void mouseOverActions(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
			
		}
		/**
		 * Actions class to perform double click action
		 * @param driver
		 * @param element
		 */
		public void doubleClickAction(WebDriver driver) {
			Actions act = new Actions(driver);
			act.doubleClick().perform();
		}
		
		/**
		 * Actions class to perform double click on a particular element
		 * @param driver
		 * @param element
		 */
		
		public void doubleClickAction(WebDriver driver , WebElement element) {
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		
		/**
		 * Perform Right click anywhere on the page
		 * @param driver
		 */
		public void righClickAction(WebDriver driver) {
			Actions act = new Actions(driver);
			act.contextClick();
		}
		
		/**
		 * Perform Right click on the particular element on page
		 * @param driver
		 */
		public void righClickAction(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.contextClick(element);
		}
		
		public void dragAndDrop(WebDriver driver, WebElement srcElement , WebElement targetElement) {
			Actions act = new Actions(driver);
			act.dragAndDrop(srcElement, targetElement).perform();
			
		}
		public void moveAcrossWebPage(WebDriver driver, int xOFfset, int yOffset) {
			Actions act = new Actions(driver);
			act.moveByOffset(xOFfset, yOffset).click().perform();
		}
		public void scrollActions(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500);", "");
		}
		
		/**
		 * will scroll vertically until reference element
		 * 
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0, "+y+");", element);
		}
		/** 
		 * Accept the alert pop up
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		/**
		 * dismiss the alert
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		public void sendTextToAlert(WebDriver driver, String text) {
			driver.switchTo().alert().sendKeys(text);
		}
		
		public void getAlertText(WebDriver driver) {
			driver.switchTo().alert().getText();
			
		}
		
		/**
		 * handle frames with index value
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}
		/**
		 * handle frames with  id/name
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, String nameOrID) {
			driver.switchTo().frame(nameOrID);
		}
		/**
		 * handle frames with element
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
			
		}

		public void switchToWindow(WebDriver driver, String partialWinTitle) {
			//Step1. capture all the window ID's
			 Set<String> allWindowHandles = driver.getWindowHandles();
			 //Step 2:  iterate through individual ID's
			 for(String winID : allWindowHandles ) {
				 //step3: switch to eachID and capturing the title
				String  currentTitle =  driver.switchTo().window(winID).getTitle();
				//step4:compare the title with required reference
				if(currentTitle.contains(partialWinTitle)) {
					break;
				}
			 }
		}
		/**
		 * this method will take screemshot and return the absolute path name
		 * @param driver
		 * @param screenshotName
		 * @return
		 * @throws Throwable
		 */
		public String takeScreenShot(WebDriver driver, String screenshotName) throws Throwable {
			TakesScreenshot ts = (TakesScreenshot)driver;//takes the screenshot
			File src = ts.getScreenshotAs(OutputType.FILE);//screenshot will be stored in temp locn
			File dst = new File(".\\Screenshots\\"+screenshotName+".png");//screenshot to be saved in destination
		    Files.copy(src, dst);
		    return dst.getAbsolutePath();//to attach screenshot to extent reports - which doesmt understand . language.
			
		}
		
		public void mouseHoverAction(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.doubleClick().perform();
		}
		
		public void selectByValue(WebElement element , String value) {
			Select sel = new Select(element);
			sel.selectByValue(value);
		}
		
//		public void selectByIndex(WebElement element , String value) {
//			Select sel1 = new Select(element);
//			sel1.selectByIndex(value);
//		}
		
		public void selectByVisibleText(WebElement element , String value) {
			Select sel2 = new Select(element);
			sel2.selectByVisibleText(value);
		}

		
		
		
	}



