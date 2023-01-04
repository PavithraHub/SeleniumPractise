package VegetableKart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		String[] veggiesToBeAdded = { "Brocolli", "Cucumber", "Cashews", "Mango" };

		WebDriver driver = new ChromeDriver();

//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// opening the url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addItems(driver, veggiesToBeAdded);
		checkOut(driver);

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

	public static void checkOut(WebDriver driver) {
		// clicking cart image
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();

		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("button.promoBtn")).click();

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

}
