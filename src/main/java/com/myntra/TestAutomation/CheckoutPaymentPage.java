package com.myntra.TestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPaymentPage extends BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private static final String EXPECTED_URL = "checkout/payment";
	
	@FindBy(how = How.XPATH, using="//ul[@class='card-listing']")
	private WebElement cardList;
	
	public CheckoutPaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAT() {
		isDisplayed(cardList);
		System.out.println(driver.getCurrentUrl().toLowerCase());
		
		try
		{
			return driver.getCurrentUrl().toLowerCase().contains(EXPECTED_URL);
		}
		catch(Exception e ) {
			throw new RuntimeException("checkout payment page is not displayed" + e.getMessage(),e);
		}
	}
}


