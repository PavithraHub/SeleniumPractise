package MiscellaneousSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class ChromeOption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		
		ChromeOptions co= new ChromeOptions();
		 co.setAcceptInsecureCerts(true);
		 
		 
		
	
		WebDriver driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		

	}

}
