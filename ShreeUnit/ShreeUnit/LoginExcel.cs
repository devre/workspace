using System;
using System.IO;
using System.Text;
using System.Threading;

//using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.By;

using OpenQA.Selenium.Firefox;
using NUnit.Framework;
using OpenQA.Selenium.Support.UI;

namespace ShreeUnit
{    
    public class LoginExcel
    {
        IWebDriver driverFF;
        [SetUp]
        public void Initialize()
        {
            driverFF = new FirefoxDriver();
            var capabilitiesInternet = new OpenQA.Selenium.Remote.DesiredCapabilities();
            capabilitiesInternet.SetCapability("ignoreProtectedModeSettings", true);
            driverFF = new FirefoxDriver(capabilitiesInternet);
        }

        [Test]
        public void TestLoginDDT()
        {         
            
            //Goto the Target website
            driverFF.Navigate().GoToUrl("http://shree365.com/Login_Shree");

            // Read Data
            String [][] LoginData = ReadDataFrmXL.readData("C:\\testData.xls",0);

            for (int i=0; i< ReadDataFrmXL.xRows; i++)
            {
            String vUser = LoginData[i][0];
            String vPassword = LoginData[i][1];
            driverFF.FindElement(By.Id("txtLogin").clear();
            driverFF.FindElement(By.Id("txtLogin").sendKeys(vUser);

            }
            
      //      Thread.Sleep(900);//Not a good practise to use Sleep
                  //      SaveScreenShot(driverFF.Title);
         //   Assert.AreEqual(expectedValue, currencyValue.Trim());
       }
        public class ReadDataFrmXL 
        {
            static int intxRows;
            static int intxCols;
            public static String[][] readData(String fPath, intsheetNum) throws Exception
            {
                File file = new File(fPath);
                FileInputStreamfIP = new FileInputStream(file);
                HSSFWorkbookwb = new HSSFWorkbook(fIP);
                HSSFSheet sheet = wb.getSheetAt(sheetNum);
                xRows = sheet.getLastRowNum()+1;
                System.out.println("Rows are :"+ xRows);
                xCols = sheet.getRow(0).getLastCellNum();
                    System.out.println("Columns are : " + xCols);
                String[][] xData = new String[xRows][xCols];
                for(inti=0; i<xRows; i++){
                HSSFRow row = sheet.getRow(i);
                for(int j=0; j<xCols; j++){
                HSSFCell cell = row.getCell(j);
                String value= CellToString(cell);
                xData[i][j] = value;
                System.out.println(value);
                //System.out.print("##");
            }
            //System.out.println("@");
        }
        return xData;     }
    public static String CellToString(HSSFCell cell) 
    {
        int type = cell.getCellType();
        Object result = null;
        switch(type){
        case HSSFCell.CELL_TYPE_BLANK:
        result = "";
        //System.out.println("Blank Value");
        break;
        case HSSFCell.CELL_TYPE_BOOLEAN:
        result = cell.getBooleanCellValue();
        //System.out.println(result);
        break;
        case HSSFCell.CELL_TYPE_ERROR:
        //System.out.println("There is some error.");
        throw new RuntimeException("Error");
        case HSSFCell.CELL_TYPE_FORMULA:
        throw new RuntimeException("Formula can not be eveluated.");
        case HSSFCell.CELL_TYPE_NUMERIC:
        result = cell.getNumericCellValue();
        //System.out.println(result);
        break;
        case HSSFCell.CELL_TYPE_STRING:
        System.out.println(result);
        result = cell.getStringCellValue();
        //System.out.println(result);
        break;
        default:
        System.out.println("Out of world.");
                throw new RuntimeException("Out of world.");
    }
        return result.toString();
        
}
    }        
}
}
