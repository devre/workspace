using System;
using NUnit.Framework;
using OpenQA.Selenium;
//using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;

namespace ShreeUnit
{
    
    public class LoginPage
    {
        IWebDriver driverFF;
        [SetUp]
        public void Initialize()
        {
            driverFF = new FirefoxDriver();
        }

        [Test]
        public void TestLogin()
        {
            driverFF.Navigate().GoToUrl("http://www.shree365.com/Login_Shree");
            driverFF.FindElement(By.Id("MiddleSection_txtLogin")).SendKeys("QA@QA.COM");
            driverFF.FindElement(By.Id("MiddleSection_txtPassword")).SendKeys("qa");
            driverFF.FindElement(By.Id("MiddleSection_btnCheckLogin")).Click();
        }

        [TearDown]
        public void EndTest()
        {
        //  driverFF.Close();
        //    driverFF.Quit();
        }

    }
}
