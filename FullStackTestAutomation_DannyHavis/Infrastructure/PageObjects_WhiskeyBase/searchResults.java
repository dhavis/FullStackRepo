package PageObjects_WhiskeyBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class searchResults 
{
	@FindBy (how = How.CLASS_NAME, using = "empty-table")
	public static WebElement searchResultsString;

	
	
	
}
