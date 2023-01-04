package TMR.PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TMR.ReusableComponents.ReusableClass;

public class ResidentialAddress extends ReusableClass{
	
	WebDriver driver;
	
	public ResidentialAddress(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="guideContainer-rootPanel-panel1500024346403-panel1500016930830-panel-ResidentialPropertyAddressDetails1491281571364-principalplaceofresi___widget")
	WebElement residentialAddressDropdown;
	
	@FindBy(id="guideContainer-rootPanel-panel1500024346403-toolbar-Continue___widget")
	WebElement continueButton;	
	
	@FindBy(id="guideContainer-rootPanel-panel1500024346403-toolbar-Previous___widget")
	WebElement previousButton;	
	
	@FindBy(id="ui-id-1")
	List<WebElement> dropDownValues;


public void selectResidentialAddress(String address)
{
	Actions action= new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN);
	residentialAddressDropdown.click();
	residentialAddressDropdown.sendKeys(address);
	
	List addressList = dropDownValues;
	
	dropDownValues.get(0).click();
	
	continueButton.click();
}
}