package tests.com.test.LinkedIn;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class HelperPage {

public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HelperPage.class.getName());
public WebDriver driver;
public WebDriverWait wait;

	public void setBrowser(String browser){
		if (browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\QA_Learning\\Automation Files\\geckodriver-v0.16.1-win64\\geckodriver.exe");
			log.info("Opening Browser: " + browser);
			driver= new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\QA_Learning\\Automation Files\\chromedriver_wwin32\\chromedriver.exe");	
			log.info("Opening Browser: " + browser);
			driver = new ChromeDriver();
		}
		else
			System.out.println("Invalid Browser Entry");
	}
	
	public void getURL(String URL){
		log.info("Navigating to: " + URL);
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	public void init(String browser,String url){
		setBrowser(browser);
		getURL(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

   public void waitForElement(WebElement wElem){
	   wait = new WebDriverWait(driver,30);
	   wait.until(ExpectedConditions.elementToBeClickable(wElem));
   }	
  
   public void getScreenShot(String name){
  	 
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\test_screenshot\\";
				File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(scrFile, destFile);
				// This will help us to link the screen shot in testNG report
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			} catch (IOException e) {
						e.printStackTrace();
				}
   }
@AfterSuite
public void tearDown(){
	driver.quit();
}
}
