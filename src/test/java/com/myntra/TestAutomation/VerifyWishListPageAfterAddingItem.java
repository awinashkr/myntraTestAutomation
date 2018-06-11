package com.myntra.TestAutomation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.BaseTest;

public class VerifyWishListPageAfterAddingItem extends BaseTest{
	private MyntraPages pages;
	private WebDriver driver;
	
	public VerifyWishListPageAfterAddingItem() {
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
	
	@Test(priority = 2, description= "click on LOgin button")
	public void clickOnLOginButton() {
		pages.home().clickOnLoginButton();
		Assert.assertTrue(pages.login().isAT(), "Login page is not displayed");
		
	}
	
	@Test(priority = 3, description= "enter user credentials")
	@Parameters({"userName", "password"})
	public void enerUserCredentials(String userName, String password) {
		pages.login().enterUserCredential(userName, password);
		Assert.assertTrue(pages.home().checkLogin(), "user is not login");
		
	}
	
	@Test(priority = 4, description = "Search for Product")
	@Parameters("product")
	public void searchForProducts(String product) {
		pages.home().searchForProduct(product);
		Assert.assertTrue(pages.productList().checkResult(), "Products are not displayed");
	}
	
	@Test(priority = 5, description = "Select first product")
	public void userSelectFirstProduct() {
		pages.productList().clickOnSaveButtonForFirstProduct();
		
	}
	
	@Test(priority = 6, description = "Click on wish list option")
	public void clickOnWhishListOption() {
		pages.home().clickOnWishListOption();
		Assert.assertTrue(pages.wishList().isAT(), "wish list page is not displayed");
		
	}
	
	@Test(priority =7, description = "Check item added in wish list")
	public void checkItemAddedInWishList() {
		
		Assert.assertTrue(pages.wishList().checkItemAddInWishList(), "Item is not added in wish list");
	}
	

}
