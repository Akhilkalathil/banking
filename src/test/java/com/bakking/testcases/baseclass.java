package com.bakking.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.banking.utlities.ReadConfig;

public class baseclass {
	//public  ExtentReports extent;    //added from web
	//public ExtentTest test;    /// addes frm web
	public  ExtentReports extent;
	public ExtentTest test;
	
	ReadConfig readconfig = new ReadConfig();
	// to call url usen name and password.... first creat object
	public String baseURL = readconfig.getApplicationURl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	// pre request before executing TC
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//driver\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		if(br.equals("ie"))
		{
		System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
		driver = new InternetExplorerDriver();
		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	// teardown method
	
	@AfterClass
	public void teardown ()
	{
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
