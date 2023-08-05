package ObjectRepositoryPOM;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

	public class ContactPage extends WebDriverUtility{
		//Rule 1. Create a separate POM class for every web page.
	    //Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAll
		
		@FindBy(xpath = "//img[@alt = \"Create Contact...\"]")
		private WebElement AddContact;
		
		//Rule 3 : Create constructor 
		public ContactPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		
		
		//Rule 4: Create getters to access the elements
		
		public WebElement getAddContact() {
			return AddContact;
		}
		
		//Business Library
		public void clickOnAddContactIcon() {
			AddContact.click();
		}
		
		

	}



