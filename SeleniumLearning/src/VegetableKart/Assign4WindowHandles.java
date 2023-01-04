package VegetableKart;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign4WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> windows= driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();
		
		for (String currentWindow : windows)
		{
			//String childWindow = driver.switchTo().window(currentWindow).getWindowHandle();
			
			System.out.println("$$$$$$$$$$$");
			if (!parentWindow.equals(currentWindow))
			{
				System.out.println("##########");
				driver.switchTo().window(currentWindow);
				String childWindowText = driver.findElement(By.cssSelector("h3")).getText();
				System.out.println(childWindowText);
				break;
			}
			
		}
		
		/*while(itr.hasNext())
		{
			String childWindow = itr.next();
			if (!parentWindow.equals(childWindow))
			{
				System.out.println("##########");
				driver.switchTo().window(childWindow);
				String childWindowText = driver.findElement(By.cssSelector("h3")).getText();
				System.out.println(childWindowText);
				break;
			}
			
		}*/
		
		driver.switchTo().window(parentWindow);
		
		String parentWindowText = driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println(parentWindowText);
		
		

	}

}
