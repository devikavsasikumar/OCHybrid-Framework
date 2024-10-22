
package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accpage = loginpage.doLogin("devikasasikumar@gmail.com","Dev1708");
	}

	@Test
	public void accountsPageTitleTest() {
		String actAccountPageTitle = accpage.getAccountsPageTitle();
		System.out.println("Acc page title : " + actAccountPageTitle);
		Assert.assertEquals(actAccountPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	public void accPageHeaderTest() {
		Assert.assertTrue(accpage.isAccountsPageHeaderExist());
	}

	@Test
	public void searchExistTest() {
		Assert.assertTrue(accpage.isSearchExist());
	}

	@Test
	public void accSectionsTest() {
		List<String> actSecList = accpage.getAccountsPageSectionsList();
		System.out.println("Accounts Sections list = " + actSecList);
		Assert.assertEquals(actSecList, Constants.ACCOUNTS_SECTIONS_LIST);
	}

	@Test

	public void searchHeaderTest() {
		searchresultspage = accpage.doSearch("Macbook");
		String actSearchHeader = searchresultspage.getResultsPageHeaderValue();
		Assert.assertTrue(actSearchHeader.contains("Macbook"));
	}

	@Test
	public void searchProductCountTest() {
		searchresultspage = accpage.doSearch("iMac");
		int actProductCount = searchresultspage.getProductSearchCount();
		Assert.assertEquals(actProductCount, Constants.IMAC_PRODUCT_COUNT);
	}

	@Test
	public void getSearchProductListTest() {
		searchresultspage = accpage.doSearch("iMac");
		List<String> actProductList = searchresultspage.getProductResultsList();
		System.out.println(actProductList);
	}

}