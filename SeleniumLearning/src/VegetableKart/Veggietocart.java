package VegetableKart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Veggietocart {
	
	/**************Array to ArrayList code********************/
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//opening the url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] veggiesToBeAdded= {"Brocolli","Cucumber","Cashews","Mango"};
		Thread.sleep(3000);
		
	
		List<WebElement> result= driver.findElements(By.cssSelector(".product-name"));
		
		List veggiesToBeAddedArrList = Arrays.asList(veggiesToBeAdded);
		
		for(int i=0;i<result.size();i++)
		{
			String[] vegName= result.get(i).getText().split("-");
			String trimmedVegName = vegName[0].trim();
			System.out.println(trimmedVegName);
			int j=0;
			if (veggiesToBeAddedArrList.contains(trimmedVegName))
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if(j==veggiesToBeAddedArrList.size())
				{
					break;
				}
			}
		}
		
		
		
		
	}

	
}
