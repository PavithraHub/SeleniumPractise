package VegetableKart;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class LimitingWebDriver {
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		/***********printing no of links in footersection**********/
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		int totalFooterLink = footer.findElements(By.tagName("a")).size();
		System.out.println(totalFooterLink);
		
		/***********printing no of links in the first column of footersection**********/
		WebElement columnFooter = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		int totalColumnFooter= columnFooter.findElements(By.tagName("a")).size();
		System.out.println(totalColumnFooter);
		/***********Click on each link on column and see if pages are opening**********/
		
		for(int i=0;i<totalColumnFooter;i++)
		{
			String tabClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnFooter.findElements(By.tagName("a")).get(i).sendKeys(tabClick);
		}
		
		/*************Getting Title of each window opened in new tab***************/
		
		Set<String> s= driver.getWindowHandles();
		
		Iterator<String> itr = s.iterator();
		
		String parentWindow= driver.getWindowHandle();
		System.out.println("@@@@@@@@@");
		
		while(itr.hasNext())
		{
			String ChildWindow = itr.next();
			driver.switchTo().window(ChildWindow);
			System.out.println(driver.getTitle()); 
			
		}
				
		
		
}
}
