package VegetableKart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companion/");
		
driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		
		System.out.println("!!!!!!!!!");
		String month = driver.findElement(By.cssSelector(".cur-month")).getText();
		
		while(!month.equalsIgnoreCase("January"))
		{
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
		}
		
		
	}

}
