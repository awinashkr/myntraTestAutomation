package com.myntra.TestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(how = How.XPATH, using="//button[contains(text(),'CONTINUE TO PAYMENT')]")
	private WebElement continueButton;
	
	private static final String EXPECTED_URL = "checkout/address";
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAT() {
		
		try
		{
			return driver.getCurrentUrl().toLowerCase().contains(EXPECTED_URL);
		}
		catch(Exception e ) {
			throw new RuntimeException("checkout address page is not displayed" + e.getMessage(),e);
		}
	}
	
	public void clickOnContinue() {
		scrollAndClick(continueButton);
	}
}
