package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoTest extends BaseTest{
	
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void productInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] serchData() {
		return new Object[][] {{"Macbook"},
								{"iMac"}};
	}
	@Test(dataProvider = "searchData")
	public void productCountTest(String productName) {
		searchResPage = accPage.doSearch(productName);
		Assert.assertTrue(searchResPage.getProductResultsCount()>0);
	}
	
	
//	@Test 
//	public void productCountTest() {
//		searchResPage = accPage.doSearch("Macbook");
//		Assert.assertTrue(searchResPage.getProductResultsCount() == 3);
//	}
//	
	@Test
	public void productInfoHeaderTest() {
		searchResPage = accPage.doSearch("iMac");
		productInfopage = searchResPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfopage.getProductHeaderText(), "iMac");
	}
	
	@Test
	public void productImagesTest() {
		searchResPage = accPage.doSearch("Macbook");
		productInfopage = searchResPage.selectProductFromResults("MacBook Pro");
		Assert.assertTrue(productInfopage.getProductImagesCount() == 4);
	}
	
	@Test
	public void getProductInfoTest() {
		searchResPage = accPage.doSearch("Macbook");
		productInfopage = searchResPage.selectProductFromResults("MacBook Pro");
		Map<String, String> actProductMetaData = productInfopage.getProductInformation();
		actProductMetaData.forEach((k,v) -> System.out.println(k + " : " + v));
		
		softAssert.assertEquals(actProductMetaData.get("name"), "MacBook Pro");
		softAssert.assertEquals(actProductMetaData.get("Brand"), "Apple");
		softAssert.assertEquals(actProductMetaData.get("Availability"), "Out Of Stock");
		softAssert.assertEquals(actProductMetaData.get("price"), "$2,000.00");

		softAssert.assertAll();
	}
	
	@Test
	public void addToCartTest() {
		
	}
	
	

}