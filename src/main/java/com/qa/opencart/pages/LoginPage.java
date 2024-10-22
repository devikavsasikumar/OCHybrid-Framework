package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleutil;
	private JavaScriptUtil jsutil;
	private By emailId = By.xpath("//input[@id='input-email']");
	private By Password = By.id("input-password");
	private By LoginBtn = By.xpath("//input[@value='Login']");
	private By forgotpwd = By.xpath("//a[text()='Forgotten Password']");

	public LoginPage(WebDriver driver) {
		jsutil=new JavaScriptUtil(driver);
		eleutil = new ElementUtil(driver);
		this.driver = driver;

	}

	public String getLoginPageTitle() {
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);
	}

	public String getLoginPageUrl() {
		return eleutil.waitForUrl(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_FRACTION_URL);
	}

	public boolean isforgotpwdLinkExist() {
		eleutil.waitForElementToBeVisible(forgotpwd, 20);
		return eleutil.doIsDisplayed(forgotpwd);

	}

	public AccountsPage doLogin(String username, String password) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsutil.scrollIntoView(eleutil.getElement(emailId));
		eleutil.doActionsSendKeys(emailId,username);
		//eleutil.getElement(emailId).sendKeys(username);
		eleutil.getElement(Password).sendKeys(password);
//eleutil.waitForElementToBeVisible(LoginBtn, 20);
		//eleutil.getElement(LoginBtn).click();
//eleutil.doActionsClick(LoginBtn);
		jsutil.clickElementByJS(eleutil.getElement(LoginBtn));
		System.out.println("Clicked the login button");
		return new AccountsPage(driver);
	}

}
