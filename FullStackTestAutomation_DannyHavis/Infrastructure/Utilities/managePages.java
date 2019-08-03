package Utilities;

import org.openqa.selenium.support.PageFactory;

import PageObjects_MortgageCalc.mainPage;
import PageObjects_WhiskeyBase.landingPage;
import PageObjects_WhiskeyBase.searchResults;


public class managePages extends base
{
	public static void init()
	{
		WBLandingPage = PageFactory.initElements(driver, landingPage.class);
		WBResults= PageFactory.initElements(driver, searchResults.class);
		
		MortgageMain= PageFactory.initElements(driver, mainPage.class);
	}
}
