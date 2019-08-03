package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.searchClick;
import Extensions.update;
import PageObjects_WhiskeyBase.landingPage;
import Utilities.commonOps;

public class web_search extends commonOps
{
	public static void go(String searchValue) throws IOException, ParserConfigurationException, SAXException
	{
		update.text(landingPage.searchBox, searchValue);
		searchClick.go(landingPage.searchSubmit);

	}
}
