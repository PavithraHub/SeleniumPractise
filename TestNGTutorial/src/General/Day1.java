package General;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {
	
	@AfterSuite
	public void afterSuiteExec()
	{
		System.out.println("Exit point of execution");
	}
	
	@Parameters({"URL"})
	@Test
	
	public void Demo(String urlname)
	{
		System.out.println("demo test");
		System.out.println(urlname);
	}
	
	@Test(groups= {"smoke"})
	public void LoginPositive()
	{
		System.out.println("Login passed");
	}
	
	@Test(groups= {"smoke"},dependsOnMethods = {"LoginPositive"})
	public void LoginNegative()
	{
		System.out.println("Login Negative ok");
	}

}
