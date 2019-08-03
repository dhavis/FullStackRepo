package PageObjects_MortgageCalc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage 
{
	@FindBy(how = How.ID, using ="etAmount")
	public static WebElement amount;
	
	@FindBy(how = How.ID, using ="etTerm")
	public static WebElement term;
	
	@FindBy(how = How.ID, using ="etRate")
	public static WebElement rate;
	
	@FindBy(how = How.ID, using ="add_schedule_text")
	public static WebElement calculate;
	
	@FindBy(how = How.ID, using ="tvRepayment")
	public static WebElement repayment;
	
}
