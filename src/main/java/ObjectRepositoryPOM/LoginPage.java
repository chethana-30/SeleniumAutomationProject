package ObjectRepositoryPOM;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;
public class LoginPage extends WebDriverUtility{

				//Rule 1. Create a separate POM class for every web page.
				//Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAl
				@FindBy(name = "user_name")
				private WebElement userNameEdt;
				
				@FindBy(name = "user_password")
				private WebElement passwordEdt;
				
				@FindBy(id = "submitButton")
				private WebElement loginBtn;
				
				//Rule3 : Create constructor to initialize the web elements:
				
				public LoginPage(WebDriver driver) {
					PageFactory.initElements(driver, this);
				}
				
				//Rule 4: Provide getters to access the web elements

				public WebElement getUserNameEdt() {
					return userNameEdt;
				}

				public WebElement getPasswordEdt() {
					return passwordEdt;
				}

				public WebElement getLoginBtn() {
					return loginBtn;
				}
				/**
				 * This method will perform login credentials
				 * @param USERNAME
				 * @param PASSWORD
				 */
				//Business Library - project specific generic method
				public void loginToApp(String USERNAME, String PASSWORD) {
					userNameEdt.sendKeys(USERNAME);
					passwordEdt.sendKeys(PASSWORD);
					loginBtn.click();
				}
				
				
		}








