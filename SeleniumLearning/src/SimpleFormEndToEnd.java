import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleFormEndToEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		// opening the url
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		
		/*******Sending Name and Password***************/
		WebElement Name =driver.findElement(By.xpath("//input[@name='name']"));
		Name.sendKeys("Pavithra");
		
		WebElement Password =driver.findElement(By.id("exampleInputPassword1"));
		Password.sendKeys("12345");
		
		/****************selecting i love icecream checkbox**********/
		driver.findElement(By.id("exampleCheck1")).click();
		
		Thread.sleep(2000);
		
		/**************Selecting a option from gender dropdown***********/
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select genderOptions = new Select(dropdown);
		//genderOptions.selectByValue("Female");
		genderOptions.selectByVisibleText("Female");
		
		/***********Selecting Student CheckBox****************/
		driver.findElement(By.id("inlineRadio1")).click();
		
		/**************Passing value to date************/
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("20-02-2022");
		
		/**********clicking submit*************/
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		Thread.sleep(2000);
		
		String message = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible'] /strong")).getText();
		
		if(message.contains("The Form has been submitted successfully!."))
		{
			System.out.println("The submition is successful");
			
		}	
		else
			System.out.println("Submition is not successful");
		
		driver.close();
		
		
		
		
		
	}

}
