package Tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.verify;
import PageObjects_MortgageCalc.mainPage;
import Utilities.commonOps;
import WorkFlows.mobile_mortgage;


public class MortgageApp extends commonOps{
  
	@Test
	public void test01_verifyRepayment() throws IOException, ParserConfigurationException, SAXException	// verify the calculation works as expected 
	{
		mobile_mortgage.calculate("1000", "3", "4");
		verify.TextInElement(mainPage.repayment, "£30.03");
	}
}
