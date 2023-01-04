package ECommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ECommerce.ReusableComponents.ReusableComponentClass;

public class CartPage extends ReusableComponentClass
{
	WebDriver driver;
	
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	By cartProductsBy = By.cssSelector(".cartSection h3");

	public void checkProductInCart(String productName)
	{
		//cartButton.click();
		waitForElementToAppear(cartProductsBy);
		Boolean flag = cartProducts.stream().
				anyMatch(product->product.getText().equals(productName));
		
		Assert.assertTrue(flag);
	}
	
	

}
