package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By search = By.xpath("//div[@id='search']/input[@type='text']");
	private By searchBtn = By.cssSelector("div#search button");
	//private By searchBtn=By.xpath("//div[@id='search']/button[@type='button']");
	//private By header = By.cssSelector("div#logo a");
	private By header=By.xpath("//div[@id='logo']//a");
	private By accSecList = By.cssSelector("div#content h2");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccountsPageTitle() {
		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	public boolean isAccountsPageHeaderExist() {
		return eleUtil.doIsDisplayed(header);
	}
	
	public boolean isSearchExist() {
		eleUtil.waitForElementToBeVisible(search, 20);
		return eleUtil.doIsDisplayed(search);
	}
	
	public SearchPage doSearch(String productName) {
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, productName);
			eleUtil.doClick(searchBtn);
			return new SearchPage(driver);
		}
		return null;
		
	}
		
	public List<String> getAccountsPageSectionsList() {
		List<WebElement> secList = eleUtil.getElements(accSecList);
		List<String> accSecValList = new ArrayList<String>();
		for(WebElement e : secList) {
			String text = e.getText();
			accSecValList.add(text);
		}
		return accSecValList;
	}
}
