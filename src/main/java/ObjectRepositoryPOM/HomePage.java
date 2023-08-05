
package ObjectRepositoryPOM;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;
	public class HomePage extends WebDriverUtility {
		

				//Rule 1. Create a separate POM class for every web page.
			    //Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAl
			    @FindBy(linkText = "Organizations")
			    private WebElement Organisation;
			    
			    @FindBy(xpath = "//img[@title = \"Create Organization...\"]")
			    private WebElement AddNewORganization;
			//    
			    @FindBy(linkText = "Contacts")
			    private WebElement ContactsLink;
			    
			    @FindBy(linkText = "Opportunities")
			    private WebElement OppurtunityLink;
			    
			    @FindBy(linkText = "Products")
			    private WebElement ProductLink;
			    
			    
			    
			    @FindBy(xpath = "//img[@style = \"padding: 0px;padding-left:5px\"]")
				private WebElement LogOutButton;
				
				@FindBy(linkText = "Sign Out")
				private WebElement SignoutLink;
				
//			    @FindBy(name = "accountname")
//			    private WebElement UsernameEdt;
			//    
//			    @FindBy(name = "industry")
//			    private WebElement IndustryEdt;
			//    
//			    @FindBy(name = "button")
//			    private WebElement SaveButton;
			    
			    //Rule 3:Create constructors to initialize the WebElements
			    public HomePage(WebDriver driver) {
			    	PageFactory.initElements(driver, this);
			    }

			    //Rule 4: Provide getters to access the webelements
			    

				public WebElement getOrganisation() {
					return Organisation;
				}

				public WebElement getAddNewORganization() {
					return AddNewORganization;
				}

				public WebElement getContactsLink() {
					return ContactsLink;
				}

				public WebElement getOppurtunityLink() {
					return OppurtunityLink;
				}

				public WebElement getProductLink() {
					return ProductLink;
				}
//				
				public WebElement getLogOutButton() {
					return LogOutButton;
				}

				public WebElement getSignoutLink() {
					return SignoutLink;
					}

				
				

				
			    //Rule 5 : Business Library - project specific generic method
				public void getOrganizationPage() {
					Organisation.click();
				}
				public void addOrganization() {
					AddNewORganization.click();
				}
				
				public void addContact() {
					ContactsLink.click();
				}

				public void logOut(WebDriver driver) {
					LogOutButton.click();
				    SignoutLink.click();
					
				}
				
//	     		public void logOut(WebDriver driver) {
//					LogOutButton.click();
//	   			    SignoutLink.click();
//				}
				

				
				
				
				
				
				
				
				
				
				
				
			}






