package utility;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utility.ShreeReportListner.class)
public class ShreeRealReport 
{
    	@Test
	    public void testRealReportOne(){
	        Assert.assertTrue(true);
	    }
	    @Test
	    public void testRealReportTwo(){
	        Assert.assertTrue(false);
	    }
	    //Test case depends on failed testcase= testRealReportTwo
	    @Test(dependsOnMethods="testRealReportTwo")
	    public void testRealReportThree(){
	    }
}