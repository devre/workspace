package shreeAutomation.shreeAutomation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.testng.annotations.Test;
 
import org.testng.annotations.BeforeMethod;
 
import org.testng.annotations.AfterMethod;
 
//import pageObjects.Login_Page;
 
import appModule.SignIn_Action;
 
import utility.Constant;
 
import utility.ExcelUtils;
 
import utility.Log;

public class TestNG_Framework
{
	public WebDriver driver;
	 
	@BeforeMethod
 
  public void beforeMethod() throws Exception {
 
	  	DOMConfigurator.configure("log4j.xml");
 
		Log.startTestCase("Selenium_Test_001");
 
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
 
		Log.info(" Excel sheet opened");
 
		driver = new FirefoxDriver();
 
		Log.info("New driver instantiated");
 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
		Log.info("Implicit wait applied on the driver for 10 seconds");
 
		driver.get(Constant.URL);
 
        }
 
	@Test
 
  public void main() throws Exception {
 
	    SignIn_Action.Execute(driver);
 
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
 
	//	Home_Page.lnk_LogOut(driver).click(); 
 
		Log.info("Click action is perfomred on Log Out link");
 
        }
 
   @AfterMethod
 
  public void afterMethod() {
 
	    driver.quit();
 
        }
 
}
