package appModule;
//import java.io.File;
//import java.io.FileInputStream;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import OpenQA.Selenium.Support.UI;

//import pageObjects.Home_Page;
import pageObjects.Login_Page;
import utility.ExcelUtils;
import utility.Log;

public class SignIn_Action 
{
	public static void Execute(WebDriver driverFF) throws Exception
	{
		//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
		String sUserName = ExcelUtils.getCellData(1, 1);
		String sPassword = ExcelUtils.getCellData(1, 2);
		Login_Page.txtbx_UserName(driverFF).sendKeys(sUserName);
		Log.info("Username entered in the Username text box");
		Login_Page.txtbx_Password(driverFF).sendKeys(sPassword);
		Log.info("Password entered in the Password text box");
		Login_Page.btn_LogIn(driverFF).click();
		Log.info("Click action performed on Submit button");
     }
}
