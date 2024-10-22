package com.qa.opencart.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.utils.Constants;

public class LoginTest extends BaseTest{
@Test
	public void LoginPageTitleTest()
	{
		String actTitle=loginpage.getLoginPageTitle();
		System.out.println("Page title is" +actTitle);
		Assert.assertEquals(actTitle,Constants.LOGIN_PAGE_TITLE);
		
	}
	@Test
	public void LoginpageUrlTest()
	{
		String url=loginpage.getLoginPageUrl();
		System.out.println("The page Url is" +url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_FRACTION_URL));
	}
	@Test
	public void forgotPwdLinkTest()
		{
		
		    boolean isForgotPwdLinkPresent = loginpage.isforgotpwdLinkExist();
		    System.out.println("Forgot Password link existence: " + isForgotPwdLinkPresent);
		    Assert.assertTrue(isForgotPwdLinkPresent, "Forgot Password link is not present on the login page.");
		}
	@Test
	public void doLoginTest()
	{
		String username="devikasasikumar@gmail.com";
		String password="Dev1708";
		accpage=loginpage.doLogin(username,password);
		
	}
}
