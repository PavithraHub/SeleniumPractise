package VegetableKart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentLoginandCheckout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		LoginPage(driver,wait);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-info")));
		System.out.println("waited");

		CheckOutPage(driver);
	}

	public static void LoginPage(WebDriver driver, WebDriverWait wait) {
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");

		/********* clicking user radio button - getting xpath from neighbour tag ******/

		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span[@class='checkmark']")).click();
		//driver.findElement(By.xpath("//input[@value='admin']/following-sibling::span[@class='checkmark']")).click();

		/***** handling alert window when user radio button is clicked *********/
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));

		// driver.switchTo().alert();
		// driver.switchTo().window("//div[@class='modal-content']");

		 driver.findElement(By.id("okayBtn")).click();

		// System.out.println(driver.switchTo().alert().getText());
		
		

		/******** static dropdown to choose consultant **********/

		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));

		Select options = new Select(dropdown);

		options.selectByVisibleText("Consultant");

		System.out.println(options.getFirstSelectedOption().getText());

		driver.findElement(By.id("terms")).click();

		if (driver.findElement(By.id("terms")).isSelected()) {
			Assert.assertTrue(true);
		}

		driver.findElement(By.id("signInBtn")).click();

	}

	public static void CheckOutPage(WebDriver driver) {
		driver.manage().window().maximize();

		System.out.println(
				driver.findElement(By.xpath("//div[@id='navbarResponsive']//a[@class='nav-link btn btn-primary']"))
						.getText());
		List<WebElement> addCart = driver.findElements(By.cssSelector("button.btn.btn-info"));

		for (WebElement option : addCart) {
			option.click();
		}
		System.out.println("all buttons clicked");
		System.out.println(
				driver.findElement(By.xpath("//div[@id='navbarResponsive']//a[@class='nav-link btn btn-primary']"))
						.getText());
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
	}

}
