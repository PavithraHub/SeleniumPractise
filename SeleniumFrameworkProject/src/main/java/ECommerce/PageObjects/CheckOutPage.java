package ECommerce.PageObjects;

import org.openqa.selenium.WebDriver;

import ECommerce.ReusableComponents.ReusableComponentClass;

public class CheckOutPage extends ReusableComponentClass{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	

}
