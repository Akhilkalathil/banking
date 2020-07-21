
package com.banking.utlities;



import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class ReadConfig {
	
	// creating object for properties
	
	Properties pro;
	
	// creat constructer
	
	public ReadConfig()
	
	{
		File src = new File("./configuration/config.properties");
		
	
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
				
		//FileInputStream new = FileInputStream(src);
			pro = new Properties();	
			pro.load(fis);                    // metho to load compleat config.properties file
			} 
		catch (Exception e) 
		{
			System.out.println("Exception is" + e.getMessage());
		} 
	}

	// Adding method for each and every variable
	
	public String getApplicationURl()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chrompath");
		return chromepath;
	}
	
	public String getIEPath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
}
