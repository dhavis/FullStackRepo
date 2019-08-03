package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class searchClick extends commonOps
{
	public static void go (WebElement elem) throws IOException, ParserConfigurationException, SAXException
	{
		try 
		{
			elem.click();
			test.log(LogStatus.PASS, "Click complete");
		} 
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "Failed to click, see details: " + e + " See screenshot: " + test.addScreenCapture(takeScreenShot()));
			fail("click on element failed");
		}
	}
}
