package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory
{ 
	public WebDriver driver;
	public Properties prop;
	public WebDriver init_driver(String browserName)
	{
		System.out.println("Browser Name is"+browserName);
		if (browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
			
		}
		else
		{
			System.out.println("please pass the correct browser"+browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get("https://www.saucedemo.com/v1/");
		return driver;	
	}
	public Properties init_prop()
	{
		prop=new Properties();
		try
		{
			FileInputStream ip=new FileInputStream(".//POMSeries/src/test/resources/Config/ConfigProperties");
					prop.load(ip);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return prop;
	}
	

}
