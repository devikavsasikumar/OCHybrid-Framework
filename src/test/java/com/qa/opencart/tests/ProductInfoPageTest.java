package com.qa.opencart.tests;

import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchPage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

	public class ProductInfoPageTest extends BaseTest{
		private ProductInfoPage Prodpage;
		
		
		@BeforeClass
		public void productInfoSetup() {
			accpage = loginpage.doLogin("username","password");
		}																				
		@DataProvider
		public Object[][] getProductData()
		{
			try
			{
			Object productData[][] = ExcelUtil.getTestData(Constants.PRODUCT_SHEET_NAME);
			}
			catch(InvalidFormatException e)
			{
				e.printStackTrace();
			}
			return getProductData();
		}
		
		@Test(dataProvider = "getProductData")
		public void productInfoHeaderTest(String productName, String mainProductName) {
			searchresultspage = accpage.doSearch(productName);
			Assert.assertEquals(Prodpage.getProductHeaderText(), mainProductName);
		}
		
		@Test
		public void productImagesTest() {
			    SearchPage searchResultsPage = accpage.doSearch("MacBook");
			    List<String> prodList = searchResultsPage.selectProduct("MacBook Air");
			    Assert.assertEquals(prodList.size() ,Constants.MACBOOK_IMAGES_COUNT);
			
		}
		
		@Test
		public void productInfoTest() {
			searchresultspage = accpage.doSearch("MacBook");
			Prodpage = (ProductInfoPage) searchresultspage.selectProduct("MacBook Pro");
			Map<String, String> actProductInfoMap = Prodpage.getProductInfo();
			actProductInfoMap.forEach((k,v) -> System.out.println(k + ":" + v));
			
			Assert.assertEquals(actProductInfoMap.get("productname"), "MacBook Pro");
			Assert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
			Assert.assertEquals(actProductInfoMap.get("Reward Points"), "800");
			Assert.assertEquals(actProductInfoMap.get("price"), "$2,000.00");
			Assert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		}
		
	}


