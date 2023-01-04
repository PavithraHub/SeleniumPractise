package MiscellaneousSelenium;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		SoftAssert s= new SoftAssert();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		int totalLinkCount =0;
		int failedLinkCount=0;
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			totalLinkCount++;
			
			s.assertTrue(responseCode<400, "Broken Link identified:"+link.getText()+"With Error code: "+responseCode);
			
			
			/*wrapping up this if with assertTrue with condition
			 * if (responseCode>400)
			 *
			{
				failedLinkCount++;
				System.out.println(link.getText());
				Assert.assertTrue(false);
			}*/
							
		}
		System.out.println("Total Link Count"+totalLinkCount);
		//System.out.println("Broken Link Count"+failedLinkCount);
		/*String url = driver.findElement(By.xpath("//a[contains(@href,'soapui')]")).getAttribute("href");
		
		//setting up http connecting to get the status code response
		
		HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		
		int responseCode = conn.getResponseCode();*/
		
		s.assertAll();
		
		
	}

}
