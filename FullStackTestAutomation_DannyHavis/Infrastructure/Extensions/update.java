package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class update extends commonOps
{
	public static void text(WebElement elem, String value) throws IOException, ParserConfigurationException, SAXException	//update the text of the selected element with the sent parameter 
	{
		try 
		{
			elem.sendKeys(value);
			test.log(LogStatus.PASS, "Text field updated succeeded");

		} 
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "Failed to update text, see details: "+e+ " See screenshot: " + test.addScreenCapture(takeScreenShot()));

			System.out.println();
			fail("text update failed");

		}
	}

	public static void dropDownText (WebElement elem, String value) throws IOException, ParserConfigurationException, SAXException	// update the value of the dropdown element selected
	{
		try 
		{
			Select selectable = new Select(elem);
			selectable.selectByVisibleText(value);
			test.log(LogStatus.PASS, "drop down updated succeeded");

		} 
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL,"Failed to update drop down, see details: "+e+ " See screenshot: " + test.addScreenCapture(takeScreenShot()));
			fail("dropdown update failed");
		}
	}

}
