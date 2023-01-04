package General;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day3 {
	

	@AfterMethod
	public void cookieClearningDone()
	{
		System.out.println("cookies cleared");
	}
	@Test(dataProvider = "getData")
	public void HomeLoan(String username, String password)
	{
		System.out.println("Home Loan okk");
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test
	public void MobileHomeLoan()
	{
		System.out.println("Mobile Home Loan okk");
	}
	@BeforeMethod
	public void cookieClearning()
	{
		System.out.println("cookies to be cleared");
	}
	
	@DataProvider
	 public Object getData()
	 {
		 Object[][] data = new Object[3][2];
		 
		 data[0][0]= "firstusername";
		 data[0][1]= "firstpwd";
		 
		 data[1][0]= "secondusername";
		 data[1][1]= "secondpwd";
		 
		 data[2][0]= "thirdusername";
		 data[2][1]= "thirdpwd";
		 
		 return data;
		 
	 }
	 

}
