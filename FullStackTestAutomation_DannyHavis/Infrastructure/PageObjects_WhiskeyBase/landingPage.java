package PageObjects_WhiskeyBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class landingPage 
{
	@FindBy(how = How.ID, using ="search-input")
	public static WebElement searchBox;
	
	@FindBy(how = How.CLASS_NAME, using ="icon-globe")
	public static WebElement selectLanguage;
	
	@FindBy(how = How.ID, using ="search-submit")
	public static WebElement searchSubmit;
	
}
