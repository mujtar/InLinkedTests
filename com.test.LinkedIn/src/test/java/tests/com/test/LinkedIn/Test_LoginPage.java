package tests.com.test.LinkedIn;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;


public class Test_LoginPage extends HelperPage{

	public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Test_LoginPage.class.getName());
	LoginPage LP;
	HomePage HP;
	
@BeforeSuite
@Parameters({"browser","url"})
	public void setUp(String browser, String url){
	
		init(browser,url);
		log.info("URL Navigated: " + url);
	}

@Test
@Parameters({"email", "pass"})
public void  LoginwithValidCredentials(String email, String pass){
	
	LP = new LoginPage(driver);
	LP.Login(email,pass);
	HP = new HomePage(driver);
	#waitForElement(HP.HomeBtn);
	Assert.assertTrue(HP.HomeBtn.isDisplayed());
	log.info("LinkedIn Home Page is displayed");
	HP.GeneratePublicPost("Yet Another post");
	HP.LogOut();
	waitForElement(LP.LoginEmailFld);
	getScreenShot(email);
}
}
