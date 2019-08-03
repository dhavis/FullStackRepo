package Extensions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class verify extends commonOps
{
	public static void TextInElement(WebElement elem, String expectedValue) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			assertEquals(elem.getText(), expectedValue);
			test.log(LogStatus.PASS,"text found in element");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL,"error in finding text, see details: " + e + " See screenshot: " + test.addScreenCapture(takeScreenShot()));
			fail("Erorr with finding text");
		}
		catch (AssertionError e)
		{
			test.log(LogStatus.FAIL,"Text not found, see details: " + e + " See screenshot: " + test.addScreenCapture(takeScreenShot()));
			fail("Text not found");
		}
	}
	
	public static void image (String imagePath) throws IOException, ParserConfigurationException, SAXException
	{
		try {
			screen.find(imagePath);
			test.log(LogStatus.PASS,"Image found");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,"error in finding image, see details: " + e + " See screenshot: " + test.addScreenCapture(takeScreenShot()));
			fail("Erorr with finding image");
		}
		
	}
	
}
