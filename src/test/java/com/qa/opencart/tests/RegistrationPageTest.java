//package com.qa.opencart.tests;
//
//import java.util.Random;
//
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.qa.opencart.basetest.BaseTest;
//import com.qa.opencart.utils.Constants;
//import com.qa.opencart.utils.ExcelUtil;
//
//public class RegistrationPageTest extends BaseTest {
//	
//	@BeforeClass
//	public void regPageSetup() {
//	 regpage = loginpage.navigateToRegisterPage();
//	}
//	
//	public String getRandomEmail() {
//		Random random = new Random();
//		String email = "Janautomation"+random.nextInt(1000)+"@gmail.com";
//		return email;
//	}
//	
//	@DataProvider
//	public Object[][] getRegisterData() throws InvalidFormatException {
//		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
//		return regData;
//	}
//	
//	@Test(dataProvider = "getRegisterData")
//	public void userRegistrationTest(String firstName, String lastName, String telephone, String password, String subscribe)
//	{
//		
//		Assert.assertTrue(regpage.accountRegistration(firstName, lastName, getRandomEmail(), telephone, password, subscribe));
//	}
//	
//	
//
//}
//
