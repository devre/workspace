package utility;

import org.testng.Assert;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

//Add listener to listen report and write it when test case finished

@Listeners(value=ShreeIReporter.class)
public class ShreeForReporter 
{
	@Test(priority=0,description="testReporterOne")
    public void testReporterOne(){
        //Pass test case
        Assert.assertTrue(true);
    }
    @Test(priority=1,description="testReporterTwo")
    public void testReporterTwo(){
        //Fail test case
        Assert.assertTrue(false);
    }
}
