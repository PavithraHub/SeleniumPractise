import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FlightBookingEndToEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome" + ".driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		// opening the url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);

		/********** selecting one way **************/

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		/********** selecting from and to places ***************/

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']
		// //a[@value='JLR']"))

		Thread.sleep(2000);

		// driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		Thread.sleep(2000);
		
		//driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

		//driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
	
		if (driver.findElement(By.id("Div1")).getAttribute("Style").contains("opacity: 0.5;")) 
		{
			System.out.println("disabled");
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		
		Thread.sleep(2000);

		WebElement passengerList = driver.findElement(By.id("divpaxinfo"));

		passengerList.click();

		System.out.println(passengerList.getText());
		Thread.sleep(2000);

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();

		}
		System.out.println(passengerList.getText());

		driver.findElement(By.id("btnclosepaxoption")).click();
		// div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value="AIP"]
	}
}
