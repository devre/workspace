package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import utility.Log;

public class Login_Page 
{

    private static WebElement element = null;

public static WebElement txtbx_UserName(WebDriver driver){

     element = driver.findElement(By.id("MiddleSection_txtLogin"));
     Log.info("Username text box found");

     return element;

     }

 public static WebElement txtbx_Password(WebDriver driver){

     element = driver.findElement(By.id("MiddleSection_txtPassword"));
     Log.info("Password text box found");
     return element;

     }

 public static WebElement btn_LogIn(WebDriver driver){

     element = driver.findElement(By.id("MiddleSection_btnCheckLogin"));
     Log.info("Submit button found");
     return element;

     }
}
