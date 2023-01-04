package TMR.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TMR.ReusableComponents.ReusableClass;

public class TermsAndConditions extends ReusableClass{
	
	WebDriver driver;
	
	public TermsAndConditions(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[aria-label='No']")
	WebElement noChildProtectionOrder;
	
	@FindBy(css="button[aria-label='Accept']")
	WebElement acceptTermsAndConditions;
	
	
	
	
	By headingTxt=By.cssSelector(".guideStaticText h1");
	By noChildProtectionBy= By.cssSelector("input[aria-label='No']");
	By acceptBy = By.cssSelector("button[aria-label='Accept']");
	
	public void goToUrl() throws InterruptedException
	{
		driver.get("https://stage.stas.forms.tmr.qld.gov.au/content/forms/af/TranslinkForms/STASApplication/STASApplication.html");
		driver.getTitle();
		driver.manage().window().maximize();
		waitForElementToAppear(headingTxt);
		
	}
	
	public ResidentialAddress clickAccept() throws InterruptedException
	{
		
		/*Actions action= new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();*/
		//action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,1000)");
		waitForElementToAppear(noChildProtectionBy);
		System.out.println("In TERMS AND CONDITIONS PAGE");
		noChildProtectionOrder.click();
		System.out.println("In TERMS AND CONDITIONS PAGE - ACCEPT ");
		//action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		//action.sendKeys(Keys.PAGE_DOWN).build().perform();
JavascriptExecutor js1 = (JavascriptExecutor)driver;
		
		js1.executeScript("window.scroll(0,600)");
		waitForElementToAppear(acceptBy);
		acceptTermsAndConditions.click();
		ResidentialAddress addressPage = new ResidentialAddress(driver);
		return addressPage;
	}
}
