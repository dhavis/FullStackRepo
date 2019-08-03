package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.RestAssured;

public class commonOps extends base
{
	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File("./ConfigurationFiles/Config.xml");
		DocumentBuilderFactory dbFActory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFActory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();

	}

	public static void initBrowser(String browser) throws ParserConfigurationException, SAXException, IOException
	{
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", getData("ChromeDriverPath") );
			driver = new ChromeDriver();	
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", getData("FireFoxDriverPath") );
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", getData("IEDriverPath") );
			driver = new InternetExplorerDriver();	
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.get(getData("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screen = new Screen();
	}

	public static void initMobile() throws ParserConfigurationException, SAXException, IOException
	{
		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("App_Package"));
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("App_Activity"));
		driver = new AndroidDriver<>(new URL(getData("Appium_Server_Address")), dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void initAPI() throws ParserConfigurationException, SAXException, IOException
	{
		RestAssured.baseURI = getData("API_URL");
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type","application/json");


	}

	public static void instanceReport() throws ParserConfigurationException, SAXException, IOException
	{
		reportFolderName = getData("ReportsFilePath") +"/Report_"+getCurrentTimeStamp();
		extent = new ExtentReports(reportFolderName+"/"+getData("ReportsFileName")+".html");
	}

	public static void initReportTest(String testName, String testDescription)
	{
		test = extent.startTest(testName, testDescription); 
	}

	public static void finalizeReportTest()
	{
		extent.endTest(test);
	}

	public static void finalizeExtentReport()
	{
		extent.flush();
		extent.close();
	}

	public static String takeScreenShot() throws IOException, ParserConfigurationException, SAXException
	{
		String ScreenShotPath =reportFolderName +"/screenshots/"+"/screenshot"+getCurrentTimeStamp()+".png"; 
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(ScreenShotPath));
		return ScreenShotPath;
	}

	public static String getCurrentTimeStamp()
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
		return (formatter.format(date));  
	}


	@BeforeClass
	public void startSession() throws ParserConfigurationException, SAXException, IOException
	{		
		switch (getData("AutomationType").toLowerCase()) 
		{
		case "mobile":
			initMobile();
			break;
		case "web":
			initBrowser(getData("BrowserType"));
			break;
		case "api":
			initAPI();
		}
		managePages.init();
		instanceReport();

	}


	@AfterClass
	public void endSession() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		finalizeExtentReport();
	}

	@BeforeMethod
	public void beforeTest(Method method)
	{
		String testName = method.getName().split("_")[0];
		String testDescription = method.getName().split("_")[1] ;
		initReportTest(testName, testDescription);
	}

	@AfterMethod
	public void AfterTest()
	{
		finalizeReportTest();	
	}
}
