package ECommerce.Tests;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlonePageTemplate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		
		
		WebDriver driver = new ChromeDriver();
		
		String productName = null;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		/************ Login************/
		
		driver.findElement(By.id("userEmail")).sendKeys("pavi.govi@gmail.com");
		
		driver.findElement(By.id("userPassword")).sendKeys("Pavithra1!");
		driver.findElement(By.id("login")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		
		//System.out.println("###################"+products.get(0).getText());
		
		/*WebElement prod = products.stream().filter(product->
		product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();*/
		
		
		for(WebElement product : products)
		{
			productName = product.findElement(By.xpath("//div[@class='card-body']//b")).getText();
			System.out.println("$$$$$$$$$$$$"+productName);
			if (productName.equals("ZARA COAT 3"))
			{
				product.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
				
				break;
			}
			
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
	
		String productAddedSuccessMsg = driver.findElement(By.id("toast-container")).getText();
		
		System.out.println(productAddedSuccessMsg);
		
		
		/**********clicking cart and navigating to cart page*********/
		 

		driver.findElement(By.cssSelector("button[routerlink*='/dashboard/cart']")).click();
		
		List<WebElement> cartPageProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean flag = cartPageProducts.stream().
				anyMatch(product->product.getText().equals("ZARA COAT 3"));
				
		
		Assert.assertTrue(flag);
		
		/******** Navigating to billing page**********/
		
		driver.findElement(By.cssSelector(".cartSection.removeWrap .btn-primary")).click();
		
		
	}

}
