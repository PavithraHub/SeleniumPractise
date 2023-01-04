package General;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	
@AfterTest
public void afterExecuting()
{
	System.out.println("Last executed");
}
@Test(groups= {"smoke"})
public void carLoanAccept()
{
	
	System.out.println("car loan processed");
}

@Parameters({"URL"})
@Test
public void carLoanReject(String url)
{
	
	System.out.println("car loan rejected");
	System.out.println(url);
}

@BeforeSuite
public void beforeSuiteExec()
{
	System.out.println("Entry point of test");
}
}
