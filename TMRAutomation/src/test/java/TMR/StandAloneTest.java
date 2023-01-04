package TMR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TMR.PageObjects.ResidentialAddress;
import TMR.PageObjects.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		TermsAndConditions termsPage = new TermsAndConditions(driver);
		
		termsPage.goToUrl();
		
		ResidentialAddress addressPage = termsPage.clickAccept();
		
		
		
	}

}
