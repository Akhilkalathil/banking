package com.bakking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageobject.loginpage;
import com.banking.utlities.XLUtils;



public class TC_LoginDDT_002 extends baseclass
{
	@Test (dataProvider="LoginData")
	public void LoginDDT(String unmae,String pwd)
	{
		loginpage lp = new loginpage(driver);
		lp.setUserName(unmae);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clicksubmit();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
			System.out.println("Test Case Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("loggin passed");
			System.out.println("Test Case Passed");
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/banking/testdata/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}

}
