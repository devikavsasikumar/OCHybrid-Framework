package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;

public class SearchPage {
	private WebDriver driver;
	private ElementUtil eleutil;
	private JavaScriptUtil jsutil;
	private By searchHeader=By.cssSelector("div#content h1");
	private By products=By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//h4");
	public SearchPage(WebDriver driver) 
	{
		this.driver=driver;
		jsutil=new JavaScriptUtil(driver);
		eleutil=new ElementUtil(driver);
	}
	public String getResultsPageHeaderValue()
	{
		if(eleutil.doIsDisplayed(searchHeader))
		{
			return eleutil.doElementGetText(searchHeader);
		}
		return null;
	}
	public List<String> getProductResultsList()
	{
		List<WebElement>ProductList=eleutil.waitForElementsToBeVisible(products,Constants.DEFAULT_TIME_OUT);
		List<String>productValList=new ArrayList<String>();
		for(WebElement e:ProductList)
		{
			String text=e.getText();
			productValList.add(text);
				
			}
		return productValList;
}
	public int getProductSearchCount()
	{
		//return eleutil.waitForElementsToBeVisible(products,20).size();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eleutil.getElements(products).size();
		
		
	}
	public  List<String> selectProduct(String ProductName)
	{
		List<WebElement>productList=eleutil.waitForElementsToBeVisible(products, Constants.DEFAULT_TIME_OUT);
		List<String>productValList=new ArrayList<String>();
		for(WebElement e:productList)
		{
			String text =e.getText();
			productValList.add(text);
		}
		return productValList;
	}
	

}

