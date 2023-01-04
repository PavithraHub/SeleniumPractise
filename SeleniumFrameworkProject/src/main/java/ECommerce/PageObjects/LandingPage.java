package ECommerce.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ECommerce.ReusableComponents.ReusableComponentClass;

public class LandingPage extends ReusableComponentClass{
	
	WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//creating page objects
	
	//WebElement userName = driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut'")
	WebElement loginErrorMsg;



public ProductCatalog login(String emailId, String pwd) {
	
	userEmail.sendKeys(emailId);

	password.sendKeys(pwd);
	submit.click();
	ProductCatalog catalog = new ProductCatalog(driver);
	return catalog;
}

public void goToUrl()
{
	driver.get("https://rahulshettyacademy.com/client/");
	driver.manage().window().maximize();
}

public String loginError()
{
	waitForElementToAppear(loginErrorMsg);
	String loginError = loginErrorMsg.getText();
	return loginError;
}
}