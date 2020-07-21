package com.banking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	WebDriver idriver;   //  idriver = locla driver
	public loginpage(WebDriver rdriver)   // constructer taken driver as parameter   rdriver = remote driver
	{
		idriver = rdriver;
		PageFactory.initElements(rdriver, this);	// initate page factory class
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]")
	@CacheLookup
	WebElement linklogout;
	
	//@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")
	//@CacheLookup
	//WebElement /html/body/div[3]/div/ul/li[10]
	
	// Action metho for above three
	
	public void setUserName(String unmae)
	{
		txtUserName.sendKeys(unmae);
	}

	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clicksubmit()
	{
		btnlogin.click();
	}
	
	public void clicklogout()
	{
		linklogout.click();
	}
	
}
