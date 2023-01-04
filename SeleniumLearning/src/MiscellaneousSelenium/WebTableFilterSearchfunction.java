package MiscellaneousSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableFilterSearchfunction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		List<String> items= new ArrayList();
		List<WebElement> columnElements = new ArrayList<WebElement>() ;

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//driver.findElement(By.xpath("//tr/th[1]")).click();
		WebElement next = driver.findElement(By.cssSelector("a[aria-label*='Next']"));
		while(true)
		{
			if(next.getAttribute("aria-disabled").equals("false"))
			{
				List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
				//System.out.println(rows);
				//columnElements.addAll(rows);
				//System.out.println(columnElements);
				List tempItems = rows.stream().map(s->s.getText()).collect(Collectors.toList());
				//System.out.println("collected items");
				items.addAll(tempItems);
				driver.findElement(By.cssSelector("a[aria-label*='Next']")).click();
			}
			else if(next.getAttribute("aria-disabled").equals("true")) 
			{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			//System.out.println(rows);
			//columnElements.addAll(rows);
			//System.out.println(columnElements);
			List tempItems = rows.stream().map(s->s.getText()).collect(Collectors.toList());
			//System.out.println("collected items");
			items.addAll(tempItems);
			break;
			}

		}
		System.out.println(items);
		System.out.println("Total items count: "+items.size());
		//System.out.println("all column elements : "+columnElements);
		//System.out.println("total column elements: "+columnElements.size());
		//System.out.println("Total count of items" +items.size());
		
		List expected = items.stream().filter(s->s.contains("an")).collect(Collectors.toList());
		//List<WebElement> expected = columnElements.stream().filter(s->s.getText().contains("Ri")).collect(Collectors.toList());
		//List<String> expected = new ArrayList();
		Thread.sleep(3000);
		//for(WebElement e : columnElements)
		/*
		 * { if(e.getText().contentEquals("Ri")) { expected.add(e.getText());
		 * 
		 * 
		 * } }
		 */
		System.out.println(expected);
		
		
	}

}
