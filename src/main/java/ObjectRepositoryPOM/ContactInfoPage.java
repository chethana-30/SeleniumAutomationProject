package ObjectRepositoryPOM;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

	public class ContactInfoPage extends WebDriverUtility{
		
		//Rule 1. Create a separate POM class for every web page.
	    //Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAl
		
		@FindBy(name = "lastname")
		private WebElement LastNameEdt;
		
		@FindBy(xpath = "//img[@title = \"Select\"]")
		private WebElement OrgNameButton;
		
		@FindBy(name = "button")
		private WebElement SaveButton;
		
		@FindBy(id = "search_txt")
		private WebElement SearchBar;
		
		@FindBy(name = "search")
		private WebElement SearchButton;
		
		
		
		

		


		//Rule 3 : Create Constructor:
		public ContactInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		
		//Rule 4:Create getters to access the elements
		
		
		public WebElement getLastNameEdt() {
			return LastNameEdt;
		}

		public WebElement getOrgNameButton() {
			return OrgNameButton;
		}

		public WebElement getSaveButton() {
			return SaveButton;
		}
		
		public WebElement getSearchBar() {
			return SearchBar;
		}
		public WebElement getSearchButton() {
			return SearchButton;
		}

		//Rule 5: Business Library
		public void creatingNewContact(String LASTNAME, WebDriver driver, String ORGNAME) {
			LastNameEdt.sendKeys(LASTNAME);
			OrgNameButton.click();
			switchToWindow(driver, "Accounts");
			SearchBar.sendKeys(ORGNAME);
			SearchButton.click();
			driver.findElement(By.xpath("//a[. = '"+ORGNAME+"']")).click();
			switchToWindow(driver, "Contacts");
			SaveButton.click();
			
			
			
			
		}
		


	}


