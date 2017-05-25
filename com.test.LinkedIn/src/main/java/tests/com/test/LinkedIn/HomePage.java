package tests.com.test.LinkedIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomePage.class.getName());
	@FindBy(id="feed-nav-item") WebElement HomeBtn;
	@FindBy(id="mynetwork-nav-item") WebElement MyNetworkBtn;
	@FindBy(id="jobs-nav-item") WebElement JobsBtn;
	@FindBy(id="messaging-nav-item") WebElement MessagingBtn;
	@FindBy(id="notifications-nav-item") WebElement NotificationBtn;
	@FindBy(id="nav-settings__dropdown-trigger") WebElement AccountBtn;
	@FindBy(id="nav-app-launcher__dropdown-trigger") WebElement AppsLauncherBtn;
	@FindBy(xpath=".//form[@id='extended-nav-search']/descendant::input[1]") WebElement SearchTxtField;
	@FindBy(xpath=".//div[@class='core-rail']/descendant::button[1]/parent::div") WebElement PostTxtField;
	@FindBy(xpath=".//div[@class='core-rail']/descendant::textarea") WebElement PostTxtArea;
	@FindBy(xpath=".//button[text()='Post']") WebElement PostBtn;
	@FindBy(xpath=".//div[@class='sharing-posting-options  rounded-button-theme']/descendant::button[1]") WebElement PostAccessBtn;
	@FindBy(xpath=".//strong[text()='Connections']") WebElement PostAccessConnections;
	@FindBy(xpath=".//*[@id='nav-settings__dropdown-trigger']/following-sibling::ul/descendant::a[text()='Sign out']") WebElement SignOutBtn;
	
	
	HomePage (WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void HomeButtonPresent(){
		HomeBtn.isDisplayed();
	}
	
	public void MyNetworkButtonPresent(){
		MyNetworkBtn.isDisplayed();
	}
	
	public void JobsButtonPresent(){
		JobsBtn.isDisplayed();
	}
	
	public void MessagingButtonPresent(){
		MessagingBtn.isDisplayed();
	}
	
	public void NotificationButtonPresent(){
		NotificationBtn.isDisplayed();
	}
	
	public void AccountButtonPresent(){
		AccountBtn.isDisplayed();
	}
	
	public void AppsLauncherButtonPresent(){
		AppsLauncherBtn.isDisplayed();
	}
	
	public void SearchFieldPresent(){
		SearchTxtField.isDisplayed();
	}
	
	public void GeneratePublicPost(String text){
		PostTxtField.click();
		PostTxtArea.sendKeys(text);
		log.info("Message has been entered: " + text);
		SetPostAccessLevel();
		PostBtn.click();
		log.info("Post Button has been clicked");
	}
	
	public void SetPostAccessLevel(){
		PostAccessBtn.click();
		log.info("Post Access Level Button clicked");
		PostAccessConnections.click();
		log.info("Post Access Level Selected: Connections");
	}
	
	public void clickNavigationSettings(){
		AccountBtn.click();
		log.info("Navigation Settings Clicked");
		
	}
	
	public void LogOut(){
		clickNavigationSettings();
		SignOutBtn.click();
		log.info("SignOut Button Clicked");
	}
}