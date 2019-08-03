package Utilities;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PageObjects_MortgageCalc.mainPage;
import PageObjects_WhiskeyBase.landingPage;
import PageObjects_WhiskeyBase.searchResults;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class base 
{
	public static WebDriver driver;
	public static Screen screen;
	static DesiredCapabilities dc;

	// for the website 
	public static landingPage WBLandingPage;
	public static searchResults WBResults;

	// for the mobile app  
	public static mainPage MortgageMain;

	// for API 
	public static RequestSpecification  httpRequest;
	public static Response response; 
	public static JSONObject requestParams = new JSONObject();

	
	// extent reports related 
	public static ExtentReports extent;
	public static ExtentTest test;

	// 	report output location
	public static String reportFolderName;

}
