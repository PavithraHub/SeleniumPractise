package ECommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ECommerce.ReusableComponents.ReusableComponentClass;

public class ProductCatalog extends ReusableComponentClass{
	
	WebDriver driver;

	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//creating page objects
	
	//WebElement userName = driver.findElement(By.id("userEmail"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	

	
	By productsBy = By.cssSelector(".mb-3");
	By addToCartBtn =By.xpath("//button[@class='btn w-10 rounded']");
	By spinnerBy = By.xpath("//ngx-spinner");
	By toastContainerBy = By.id("toast-container");
	
	
	public List<WebElement> getProductList()
	{
	
	waitForElementToAppear(productsBy);
	products = driver.findElements(productsBy);
		return products;
	}
	
	
//	for(WebElement product : products)
//	{
//		productName = product.findElement(By.xpath("//div[@class='card-body']//b")).getText();
//		System.out.println("$$$$$$$$$$$$"+productName);
//		if (productName.equals(name))
//		{
//			product.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
//			
//			break;
//		}
//		
//	}
	
	public WebElement getProductName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String ProductName)
	{
		
		WebElement prodEle=getProductName(ProductName);
		
		prodEle.findElement(addToCartBtn).click();
		waitForElementToDisappear(spinnerBy);
		waitForElementToAppear(toastContainerBy);
		
		
	}

	


}