package tests.com.test.LinkedIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LoginPage.class.getName());
	private WebDriver driver;
	@FindBy(id="login-submit") WebElement SignInBtn;
	@FindBy(id="login-email") WebElement LoginEmailFld;
	@FindBy(id="login-password") WebElement LoginPasswordFld;
	
	LoginPage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterLoginEmail(String email){
		
		LoginEmailFld.sendKeys(email);
		log.info("Email entered: " + email);
	}
	
	public void EnterLoginPassword(String pwd){
		
		LoginPasswordFld.sendKeys(pwd);
		log.info("Password entered");
	}
	
	public void ClickSignIn(){
		
		SignInBtn.click();
		log.info("SignIn Button Clicked");
	}
	
	public HomePage Login(String text, String pass){
		
		EnterLoginEmail(text);
		EnterLoginPassword(pass);
		ClickSignIn();
		return new HomePage(driver);
	}
	
	public String GetPageTitle(){
		
		return driver.getTitle();
	}
}
