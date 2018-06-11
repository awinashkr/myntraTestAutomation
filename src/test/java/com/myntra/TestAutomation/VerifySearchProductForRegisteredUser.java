package com.myntra.TestAutomation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.BaseTest;

public class VerifySearchProductForRegisteredUser extends BaseTest {
	private MyntraPages pages;
	private WebDriver driver;
	
	public VerifySearchProductForRegisteredUser() {
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
	
	
}
