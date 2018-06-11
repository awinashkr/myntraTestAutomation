package com.myntra.TestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	private WebDriver driver;
	private WebDriverWait wait;
	
	private static final String EXPECTED_URL = "https://www.myntra.com/login?";
	
	@FindBy(how = How.XPATH, using="//input[@name='email']")
	private WebElement userNameField;
	
	@FindBy(how = How.XPATH, using="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(how = How.XPATH, using="//button[@class='login-login-button']")
	private WebElement loginButton;
	
	private LoginPage() {
		
	}
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAT() {
		
//		try {
//			Thread.sleep(25000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try
		{
			return driver.getCurrentUrl().toLowerCase().contains(EXPECTED_URL);
		}
		catch(Exception e ) {
			throw new RuntimeException("Add address page is not displayed" + e.getMessage(),e);
		}
	}
	
	public void enterUserCredential(String userName, String Password) {
		typeIn(userNameField, userName);
		typeIn(passwordField, Password);
		click(loginButton);
		waitUntilLoaded();
	}

}
