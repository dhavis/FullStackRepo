package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class RESTAPI extends commonOps
{
	@SuppressWarnings("unchecked")
	public static void post(String[] personalDetails, List<String> courses) throws ParserConfigurationException, SAXException, IOException
	{
		try 
		{
			requestParams.put("firstName", personalDetails[0]);
			requestParams.put("lastName", personalDetails[1]);
			requestParams.put("email", personalDetails[2]);
			requestParams.put("programme", personalDetails[3]);
			requestParams.put("courses", courses);

			//httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			response = httpRequest.post(getData("API_Resource"));
			test.log(LogStatus.PASS,"Post Succeeded");
		} 
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL,"Post Failed, see details: "+e);
			fail("Post Failed, see details: "+e);
		}


	}
}
