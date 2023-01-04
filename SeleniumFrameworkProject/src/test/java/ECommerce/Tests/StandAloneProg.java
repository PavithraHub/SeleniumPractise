package ECommerce.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce.PageObjects.CartPage;
import ECommerce.PageObjects.LandingPage;
import ECommerce.PageObjects.ProductCatalog;
import ECommerce.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneProg extends BaseTest {
	
	@Test
	public void SubmitOrder() throws IOException {
		// TODO Auto-generated method stub
		
		String productName = null;
		
		/************ Login************/
		//driver.get("https://rahulshettyacademy.com/client/");
		
		/* Going to change this to LaunchTest--LandingPage loginPage = new LandingPage(driver);
		
		loginPage.goToUrl();*/
		
		
		ProductCatalog products=loginPage.login("pavi.govi@gmail.com","Pavithra1!");
		
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		  //ProductCatalog products=new ProductCatalog(driver);
		
		
		List<WebElement> productList = products.getProductList();
		
		products.addProductToCart("ZARA COAT 3");
		
		
		//System.out.println("###################"+products.get(0).getText());
		
		/*WebElement prod = products.stream().filter(product->
		product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();*/
		
		
		
//		wait.until(ExpectedConditions.invisibilityOfElementLocated());
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
	

		
		
		/**********clicking cart and navigating to cart page*********/
		 


//System.out.println("entering click cart");
//		driver.findElement(By.cssSelector("button[routerlink*='/dashboard/cart']")).click();
//		
//		Thread.sleep(2000);
		
		//List<WebElement> cartPageProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		CartPage cartpage = new CartPage(driver);
		
		CartPage cartpage = products.clickCart();
		cartpage.checkProductInCart("ZARA COAT 3");
		//System.out.println(cartPageProducts.size());
		
//		Boolean flag = cartPageProducts.stream().
//				anyMatch(product->product.getText().equals("ZARA COAT 3"));
				
		
		//Assert.assertTrue(flag);
		
		/******** Navigating to billing page**********/
		
/*		cartpage.clickCheckOut();
		
		Actions action = new Actions(driver);
		
		action.sendKeys(driver.findElement(By.cssSelector("input[placeholder = 'Select Country']")), "India")
		.click().build().perform();
		
		
		
		
		action.sendKeys(Keys.PAGE_DOWN);
		
		driver.findElement(By.cssSelector(".action__submit")).click();*/
	}
	//div[@aria-label='Incorrect email or password.']	
	
	
}
