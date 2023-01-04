package VegetableKart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign5NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//getting count of frames
		
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		//driver.switchTo().frame(driver.findElement(By.cssSelector("frameset")));
		
		//System.out.println("!!!!!!!!!!!!!!!!");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_top']")));
		
		//System.out.println("###########");
		//driver.switchTo().frame(driver.findElement(By.cssSelector("frameset[name='frameset-middle']")));
		
		//System.out.println("$$$$$$$$$$$$$");
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		
		
	}

}
