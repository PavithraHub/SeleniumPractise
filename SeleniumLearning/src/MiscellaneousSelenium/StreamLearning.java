package MiscellaneousSelenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamLearning {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pgururaj\\Downloads\\chromedriver_win32\\chromeDriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[contains(@href,'offers')]")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String parent = driver.getWindowHandle();

		while (it.hasNext()) {
			String child = it.next();
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				System.out.println("switched window");
				break;
			}
		}
		
		/*sorting of the table and checking whether the table is sorted*/
		driver.findElement(By.xpath("//tr/th[1]")).click();
		System.out.println("switched to new window");
				List<WebElement> webElement = driver.findElements(By.xpath("//tr/td[1]"));
				System.out.println("got the web elements");

				List<String> tableList = webElement.stream().map(s -> s.getText()).collect(Collectors.toList());
				List<String> sortedList = webElement.stream().map(s -> s.getText()).distinct().collect(Collectors.toList());
				System.out.println("got the table text");

				//List<String> sortedList = webElement.stream().sorted().map(s -> s.getText()).collect(Collectors.toList());
				//List sortedList = tableList.stream().sorted().collect(Collectors.toList());
				if (tableList.equals(sortedList)) {
				 System.out.println("Passed");
				}
				 
					
				//Assert.assertEquals(tableList, sortedList);
			
		

//windows.stream().filter(s->s.hasNext()).

	}

}
