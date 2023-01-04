package MiscellaneousSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableFilterSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		List<String> items= new ArrayList();
		List<WebElement> columnElements = new ArrayList<WebElement>() ;

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//driver.findElement(By.xpath("//tr/th[1]")).click();
		WebElement next = driver.findElement(By.cssSelector("a[aria-label*='Next']"));
		do
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			System.out.println(rows);
			columnElements.addAll(rows);
			//System.out.println(columnElements);
			List tempItems = rows.stream().map(s->s.getText()).collect(Collectors.toList());
			//System.out.println("collected items");
			items.addAll(tempItems);
			
			
			driver.findElement(By.cssSelector("a[aria-label*='Next']")).click();
			
		}while(next.getAttribute("aria-disabled").equals("false"));
		System.out.println(items);
		System.out.println("Total items : "+items);
		System.out.println("all column elements : "+columnElements);
		System.out.println("total column elements: "+columnElements.size());
		//System.out.println("Total count of items" +items.size());
		
		List<WebElement> expected = columnElements.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		/*for(WebElement e : columnElements)
		{
			if(e.getText().contains("Ri"))
			{
				expected.addAll(e);
				
				
			}
		}*/
		System.out.println(expected);
	}

}
