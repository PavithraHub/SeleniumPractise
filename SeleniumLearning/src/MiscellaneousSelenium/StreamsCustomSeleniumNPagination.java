package MiscellaneousSelenium;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsCustomSeleniumNPagination {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List Price;
		
		// get the list of elements in first page
		// filter it for strawberry
		// get the price value of that strawberry(using following sibling)-- done in custom method
		// do the same for other pages - looping
		
		
		
		do {
		List<WebElement> column = driver.findElements(By.xpath("//tr/td[1]"));

		Price = column.stream().filter(s -> s.getText().equals("Strawberry"))
				.map(s -> getPrice(s)).collect(Collectors.toList());
		
		
		if(Price.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label*='Next']")).click();	
		}
		
		
		}
				
		while(Price.size()<1);//this is to ensure that if the match is not found in 1st page, go to next page
		
		Price.forEach(a->System.out.println(a));
		System.out.println(Price);

	}

	public static String getPrice(WebElement s) {
		
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;

	}

}
