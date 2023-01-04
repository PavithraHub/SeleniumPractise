package VegetableKart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assign6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String label =driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
		
		System.out.println(label);
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select options = new Select(dropdown);
		
		options.selectByVisibleText(label);
		System.out.println("dropdown passed");
		
		driver.findElement(By.id("name")).sendKeys(label);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertMsg = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		System.out.println(alertMsg);
		
		if(alertMsg.contains(label))
		{
			System.out.println("passed");
		}
		else
			System.out.println("Failed");
		
	}

}
