package com.myntra.TestAutomation;

import org.openqa.selenium.WebDriver;


public class MyntraPages {
	private WebDriver driver;
	
	private HomePage home;
	private ProductListPage productList;
	private LoginPage login;
	private WishListPage wishList;
	private CartPage cart;
	private CheckoutPage checkout;
	private CheckoutPaymentPage checkoutPayment;
	
	private MyntraPages() {
		
	}
	
	public MyntraPages(WebDriver driver) {
		this.driver = driver;
	}
	
	public CartPage cart() {
		if(cart == null) {
			cart = new CartPage(driver);
		}
		return cart;
	}
	
	public CheckoutPage checkout() {
		if(checkout == null) {
			checkout = new CheckoutPage(driver);
			
		}
		return checkout;
	}
	
	public CheckoutPaymentPage checkoutPayment() {
		if(checkoutPayment == null) {
			checkoutPayment = new CheckoutPaymentPage(driver);
			
		}
		return checkoutPayment;
	}
	
	public HomePage home() {
		if(home == null) {
			home = new HomePage(driver);
		}
		return home;
	}
	
	public ProductListPage productList() {
		if(productList == null) {
			productList = new ProductListPage(driver);
		}
		return productList;
	}
	
	public LoginPage login() {
		if(login == null) {
			login = new LoginPage(driver);
		}
		return login;
	}
	
	public WishListPage wishList() {
		if(wishList == null) {
			wishList = new WishListPage(driver);
			
		}
		return wishList;
	}
	

}
