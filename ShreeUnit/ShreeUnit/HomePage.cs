using System;
//using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
//using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using NUnit.Framework;


namespace ShreeUnit
{
    
    public class HomePage
    {
        IWebDriver driverFF;
        [SetUp]
        public void Initialize()
        { 
         driverFF = new FirefoxDriver();
        }
     

        [Test]
        public void TestHomePage()
        {
            driverFF.Navigate().GoToUrl("http://www.shree365.com");
            driverFF.FindElement(By.Id("homepage"));
        }
        [TearDown]
        public void EndTest()
        {
            driverFF.Close();
        }
    }
}
