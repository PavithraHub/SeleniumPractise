package MiscellaneousSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4RelativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameLabel = driver.findElement(By.xpath("//label[text()='Name']"));
		driver.findElement(with(By.tagName("input")).below(nameLabel)).sendKeys("AdOBE");
		
		WebElement pwdLabel = driver.findElement(By.xpath("//label[text()='Password']"));
		driver.findElement(with(By.tagName("input")).above(pwdLabel)).sendKeys("ABCD@ADOBE.COM");
		
		WebElement iceCreamLabel = driver.findElement(By.xpath("//label[contains(text(),'IceCreams')]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
				
		
		WebElement studLabel = driver.findElement(By.xpath("//label[text()='Student']"));
		driver.findElement(with(By.tagName("input")).toRightOf(studLabel)).click();
		
		
		

	}

}
