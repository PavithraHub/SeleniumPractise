import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//opening the url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropDown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropDown = new Select(staticDropDown);
		
		dropDown.selectByIndex(1);
		
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		dropDown.selectByVisibleText("AED");
		
		System.out.println(dropDown.getFirstSelectedOption().getText());
	}

}
