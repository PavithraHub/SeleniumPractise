package MiscellaneousSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableAssignment7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scroll(0,600)");
		Thread.sleep(5000);

		// driver.findElement(By.className("tableFixHead"));

		// js.executeScript(null, args)

		//js.executeScript("document.querySelector('.product').scrollTop=5000");
		
		int rowSize = driver.findElements(By.xpath("//table[@name='courses'] //tr")).size();
		
		int columnSize = driver.findElements(By.xpath("//table[@name='courses'] //tr[1]/th")).size();

		List<WebElement> column = driver.findElements(By.xpath("//table[@name='courses'] //td[3]"));
		int sum = 0;
		for (int i = 0; i < column.size(); i++) {
			int val = Integer.parseInt(column.get(i).getText());
			
			
			System.out.println(val);
			sum = sum + val;

		}
		
		//no of column =//table[@name='courses'] //tr[2]/td
		//no of rows = //table[@name='courses'] //tr
		
		System.out.println("Row Size is :"+rowSize);
		System.out.println("Column Size is :" +columnSize);
		System.out.println(sum);
		//String AmountText = driver.findElement(By.cssSelector(".totalAmount")).getText();

		//String[] Amount = AmountText.split(":");
		//int Amt = Integer.parseInt(Amount[1].trim());

		

	}

}
