package com.qa.opencart.basetest;

//import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchPage;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;


public class BaseTest {
	public AccountsPage accpage;
	public DriverFactory df;
	public WebDriver driver;
	public LoginPage loginpage;
	public ElementUtil eleutil;
	//public JavaScriptUtil jsutil;
	public SearchPage searchresultspage;
	//public RegistrationPage regpage;
	//public Properties prop;
	@BeforeTest
	public void setup()
	{
		df=new DriverFactory();
		driver=df.init_driver("chrome");
		loginpage=new LoginPage(driver);
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
