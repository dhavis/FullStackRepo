package Tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import WorkFlows.api_actions;

public class studentsTests {
  @Test
  public void tes01_VerifyStudentCreated() throws ParserConfigurationException, SAXException, IOException 
  {
	  api_actions.postNewStudent();
  }
}
