package VegetableKart;

import java.awt.Window;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		//driver.switchTo().newWindow(WindowType.TAB);
		
		//System.out.println(driver.findElement(By.xpath("//span[@class='icon fa fa-envelope']")).getText()) ;
		
		
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> s= driver.getWindowHandles();
		
		System.out.println(s);  
		
		Iterator<String> itr = s.iterator();
		
				
		while(itr.hasNext())
		{
			System.out.println("###############");
			String childWindow= itr.next();
	
			if(!parentWindow.equals(childWindow))
			{
				System.out.println("entered if");
				driver.switchTo().window(childWindow);
				
				WebElement mailId = driver.findElement(By.xpath("//p[@class='im-para red'] //a"));
				System.out.println(mailId.getText());
				driver.close();
				//System.out.println(driver.findElement(By.xpath("//span[@class='icon fa fa-envelope']")).getText()) ;
			}
		}

	}

}
