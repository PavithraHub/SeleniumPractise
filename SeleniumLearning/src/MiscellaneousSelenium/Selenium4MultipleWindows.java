package MiscellaneousSelenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4MultipleWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		/* Switching to other window to get course name*/
		driver.switchTo().newWindow(WindowType.TAB);
		driver.getTitle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		String parent = itr.next();
		String Child = itr.next();
		
		driver.switchTo().window(Child);
		
		
		
		driver.get("https://rahulshettyacademy.com/");
		String course = driver.findElements(By.cssSelector("[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		//closing child window
		//driver.close();
		driver.switchTo().window(parent);
		/*Passing the course name in the name field of parent window*/
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
		
		name.sendKeys(course);
		
		
		/*getting screenshot of an element - name element*/
		File src = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\pgururaj\\OneDrive - Adobe\\Desktop\\Eclipse-Workspace\\SeleniumLearning\\Desktop\\nameScreenshot.png"));
		
		
		/*getting the height and width of an element - here name textbox*/
		
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getWidth());
	}

}
