package WorkFlows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.RESTAPI;
import Utilities.commonOps;

public class api_actions extends commonOps
{
	private static String[] personalData= {"Danny","Havis","danny@havis.com", "science"};
	private static List<String> coursesList= new ArrayList<String>();
	
	
	public static void postNewStudent() throws ParserConfigurationException, SAXException, IOException
	{
		coursesList.add("Math");
		coursesList.add("English");
		coursesList.add("History");
		RESTAPI.post(personalData, coursesList);
	}
}
