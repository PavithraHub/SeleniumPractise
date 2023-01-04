import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropdown {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome"
				+ ".driver", "C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//opening the url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		/*****************************DYNAMIC DEPENDENT DROPDOWNS*********************/
		
		/*driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] "
				+ "//a[@value='JLR']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='glsctl00"
				+ "_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();*/
		
		
		/***********************AUTOSUGGESTIVE DROPDOWN****************************/
		driver.findElement(By.id("autosuggest")).sendKeys("au");
		Thread.sleep(3000);
		
		List<WebElement> optionList = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		System.out.println(optionList);
		
		for(WebElement oneOption : optionList)
		{
			if(oneOption.getText().equalsIgnoreCase("PaLAu"))
			{
				oneOption.click();
				break;
			}
		}
		
		/**************************PASSENGER LIST ADD**************************/
		
		/*WebElement passengerList = driver.findElement(By.id("divpaxinfo"));
		
		passengerList.click();
		
		System.out.println(passengerList.getText());
		Thread.sleep(2000);
		
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
		System.out.println(passengerList.getText());
		
		driver.findElement(By.id("btnclosepaxoption")).click();*/
		
		
	}
}
