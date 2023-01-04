package General;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2 {
	
	@Test
	public void HomePage()
	{
		System.out.println("home page displayed");
	}
	
	@Test
	public void HomePagePositive()
	{
		System.out.println("home page postive");
		Assert.assertTrue(false);
	}
	
	@Parameters({"URL"})
	@Test
		public void PersonalLoan(String url)
	{
		System.out.println("Personal Loan ok");
		System.out.println(url);
	}
	
	@BeforeTest
	public void prelimWork()
	{
		System.out.println("First execution");
	}


}
