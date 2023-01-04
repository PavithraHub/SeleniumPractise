import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome" + ".driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		// opening the url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type=\'checkbox\']"));

		/************** count of checkboxes ******************/
		int Size = checkBoxes.size();

		System.out.println(Size);
		/***********
		 * to see whether first checkbox is un selected and selected
		 **********/

		WebElement FirstCheckBox = driver.findElement(By.id("checkBoxOption1"));
		Assert.assertFalse(FirstCheckBox.isSelected());
		FirstCheckBox.click();
		Assert.assertTrue(FirstCheckBox.isSelected());
		FirstCheckBox.click();
		Assert.assertFalse(FirstCheckBox.isSelected());
	}

}
