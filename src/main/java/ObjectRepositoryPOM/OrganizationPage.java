package ObjectRepositoryPOM;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility {
	
			//Rule 1. Create a separate POM class for every web page.
		    //Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAl
			@FindBy(name = "accountname")
		    private WebElement UsernameEdt;
			
			@FindBy(linkText = "Organizations")
		    private WebElement Organisation;
		    
		    

			@FindBy(name = "industry")
		    private WebElement IndustryEdt;
		    
		    @FindBy(name = "button")
		    private WebElement SaveButton;
		    
		    
		   
			@FindBy(xpath = "//img[@style = \"width:16px;height:16px;\"]")
			private WebElement Homepage;
		  //Rule 3:Create constructors to initialize the WebElements
		    

			public OrganizationPage(WebDriver driver) {
		    	PageFactory.initElements(driver, this);
		    }
		   
		  //Rule 4:Provide getters to access the web elements
		    public WebElement getUsernameEdt() {
				return UsernameEdt;
			}
		    public WebElement getOrganisation() {
				return Organisation;
			}

			public WebElement getIndustryEdt() {
				return IndustryEdt;
			}

			public WebElement getSaveButton() {
				return SaveButton;
			}
//			public WebElement getLogOutButton() {
//				return LogOutButton;
//			}
//
//			public WebElement getSignoutLink() {
//				return SignoutLink;
//			}
			
			public WebElement getHomepage() {
				return Homepage;
			}
			
			
			//Rule 5:Buisness Library
			public void addNewOrganization(String ORGNAME ) {
				UsernameEdt.sendKeys(ORGNAME);
				SaveButton.click();
			}
			
			public void backToHomePage(WebDriver driver) {
				Organisation.click();
				Homepage.click();
			}
			
			
////			public void  logOut(WebDriver driver ) throws Throwable {
////				mouseHoverAction(driver, LogOutButton);
////				Thread.sleep(2000);
////				SignoutLink.click();
//				
//			}
			
			
		//    
		}




