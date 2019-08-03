package Tests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.verify;
import PageObjects_WhiskeyBase.searchResults;
import Utilities.commonOps;
import WorkFlows.web_search;

public class WhiskeyBaseTests extends commonOps
{

	@Test
	public void test01_searchValue() throws IOException, ParserConfigurationException, SAXException	// to verify that the search phrase does not exist with a relevant message in the results page. 
	{
		
		web_search.go("Danny Havis");
		verify.TextInElement(searchResults.searchResultsString,"Sorry, nothing found"); 
		verify.image("./Images/logo.png");
	}

}
