package VegetableKart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		String[] veggiesToBeAdded = { "Brocolli", "Cucumber", "Cashews", "Mango" };

		WebDriver driver = new ChromeDriver();

//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		
		// opening the url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addItems(driver, veggiesToBeAdded);
		checkOut(driver,wait);

	}

	public static void addItems(WebDriver driver, String[] veggies) {
		List<WebElement> result = driver.findElements(By.cssSelector(".product-name"));

		List veggiesToBeAddedArrList = Arrays.asList(veggies);

		for (int i = 0; i < result.size(); i++) {
			String[] vegName = result.get(i).getText().split("-");
			String trimmedVegName = vegName[0].trim();
			System.out.println(trimmedVegName);
			int j = 0;
			if (veggiesToBeAddedArrList.contains(trimmedVegName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == veggiesToBeAddedArrList.size()) {
					break;
				}
			}
		}
	}

	public static void checkOut(WebDriver driver, WebDriverWait wait) {
		// clicking cart image
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();

		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//wait till promocode text box is loaded
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}


	

}
