package ECommerce.ReusableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ECommerce.PageObjects.CartPage;
import ECommerce.PageObjects.CheckOutPage;

public class ReusableComponentClass {
	
	
	WebDriver driver;
	

	public ReusableComponentClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="button[routerlink*='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(css=".totalRow .btn.btn-primary")
	WebElement checkOutBtn;
	
	public void waitForElementToAppear(By by)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitForElementToAppear(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToDisappear(By spinnerBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerBy));
	}
	
	public CartPage clickCart()
	{
		
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public CheckOutPage clickCheckOut() 
	{
		checkOutBtn.click();
		CheckOutPage checkout= new CheckOutPage(driver);
		return checkout;
	}
	

}
