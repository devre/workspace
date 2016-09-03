package shreeAutomation.shreeAutomation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Authentication 
{
	public static WebDriver driver; 
	static String appURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	@BeforeClass
	public void shreeSetUp() {
		
		driver = new FirefoxDriver();
	}
	@Test
	public void verifyAuthenticateButton() throws Exception
	{
		try
		{
		driver.navigate().to(appURL);
		String strAuthenticateTitle = driver.getTitle();		
        System.out.println("Page title is " + strAuthenticateTitle + ", as expected");
        driver.findElement(By.id("email_create")).sendKeys("abc@a.com");
        String email_available = driver.findElement(By.id("email_create")).getText();
        System.out.println(" Create Submit " + email_available + ", as expected");
        String strCreateSubmit = driver.findElement(By.id("SubmitCreate")).getText();
		System.out.println(" Create Submit " + strCreateSubmit + ", as expected");
		driver.findElement(By.id("SubmitCreate")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		
		}
		catch (Exception e)
		{
			throw(e);
		}
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
