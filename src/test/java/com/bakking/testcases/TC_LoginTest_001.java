package com.bakking.testcases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobject.loginpage;

public class TC_LoginTest_001 extends baseclass
 
{

	@Test
	public void logintest() throws IOException
	{
		// removed and copy pasted to base class under driver
		//driver.get(baseURL);
		// git check just for checking added this line
		
		logger.info("URL loaded");
		
		// using loginpage page object by passing parameter driver by creating object
		
		loginpage lp = new loginpage(driver);
		lp.setUserName(username);
		logger.info("User name entered");
		
		lp.setPassword(password);
		logger.info("Password entered");
		
		lp.clicksubmit();
		logger.info("Button submit clicked");
		
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		if(driver.getTitle().equals("Guru99"))
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"logintest");  // We have to pass driver name "driver" and test case nam here TC "logintest"
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
}
