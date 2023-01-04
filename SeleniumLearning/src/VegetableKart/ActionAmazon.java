package VegetableKart;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionAmazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		Actions a = new Actions(driver);
		
		WebElement accountsAndLists= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		
		a.moveToElement(accountsAndLists).build().perform();
		
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
				
		a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("phone").build().perform();
		a.doubleClick().build().perform();
		a.sendKeys("apple").build().perform();
		

	}

}
