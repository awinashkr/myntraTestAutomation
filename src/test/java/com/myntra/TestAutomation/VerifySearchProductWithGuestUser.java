package com.myntra.TestAutomation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.BaseTest;

public class VerifySearchProductWithGuestUser extends BaseTest{
	private MyntraPages pages;
	private WebDriver driver;
	
	public VerifySearchProductWithGuestUser() {
		super();
	}

	public void initPageFactory() {pages = new MyntraPages(super.driver);}

	@BeforeClass
	public void initPageFactor() {
		pages = new MyntraPages(super.driver);
	}
	
	@Test(priority=1, description="open myntra home page and clear cart")
	public void CheckMyntraHomePage() {		
		Assert.assertTrue(pages.home().isAT(), "Myntra home page is not loaded");
		
	}
	
	
	@Test(priority = 2,dataProvider = "products", description = "Search for Product")
//	@Parameters("product")
	public void searchForProducts(String product) {
		pages.home().searchForProduct(product);
		Assert.assertTrue(pages.productList().checkResult(), "Products are not displayed");
	}
	
	@DataProvider(name = "products")
	public static Object[][] products() {
		return new Object[][] {{"shirts"},{"pants"},{"toy"},{"shoes"}};
	}
	
	
}
