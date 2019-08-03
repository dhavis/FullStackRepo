package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.searchClick;
import Extensions.update;
import PageObjects_MortgageCalc.mainPage;
import Utilities.commonOps;

public class mobile_mortgage extends commonOps 
{
	public static void calculate (String amount, String term, String rate) throws IOException, ParserConfigurationException, SAXException
	{
		update.text(mainPage.amount, amount);
		update.text(mainPage.term, term);
		update.text(mainPage.rate, rate);
		searchClick.go(mainPage.calculate);
	}

}
