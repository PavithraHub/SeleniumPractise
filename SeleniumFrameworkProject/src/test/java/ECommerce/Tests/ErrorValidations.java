package ECommerce.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {
	@Test
	public void errorMessage()
	{
		loginPage.login("pavi@gmail.com","Pavithra!");
		Assert.assertEquals("Incorrect email or password.", loginPage.loginError());
	}

}
