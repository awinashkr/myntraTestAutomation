package com.myntra.TestAutomation;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	private static final String EXPECTED_URL = "https://www.myntra.com/";
	
	@FindBy(how = How.XPATH, using="//span[@class='myntraweb-sprite desktop-iconUser sprites-user']")
	private WebElement menuOption;
	
	@FindBy(how = How.XPATH, using="//a[@data-track='login']")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, using="//input[@placeholder='Search']")
	private WebElement searchField;
	
	@FindBy(how = How.XPATH, using="//a[@class='desktop-submit']")
	private WebElement searchButton;
	
	@FindBy(how = How.XPATH, using ="//div[@data-track='logout']")
	private WebElement logoutButton;
	
	@FindBy(how = How.XPATH, using="//div[@class='desktop-userActionsContent']//div[1]/a[2]")
	private WebElement wishList;
	
	@FindBy(how =How.XPATH, using = "//span[@class='myntraweb-sprite desktop-iconBag sprites-bag']" )
	private WebElement cartButton;
	
	private HomePage() {
		
	}
	
	public HomePage(final WebDriver driver) {
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
			throw new RuntimeException("Add address page is not displayed" + e.getMessage(),e);
		}
	}
	
	public void clickOnLoginButton() {
		mouseOverOneElementAndClickOnButton(menuOption,loginButton);
	}
	
	public boolean checkLogoutButton() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mouseOverAndCheck(menuOption,logoutButton);
	}
	
	public void clickOnLogOutButton() {
		mouseOverOneElementAndClickOnButton(menuOption,logoutButton);
	}
	
	public void searchForProduct(String product) {
		typeIn(searchField, product);
		click(searchButton);
	}
	
	public boolean checkLogin() {

		waitUntilLoaded();
		
		return mouseOverAndCheck(menuOption,logoutButton);
			
	}
	
	public void clickOnWishListOption() {
		mouseOverOneElementAndClickOnButton(menuOption,wishList);
	}
	
	public void clickOnCartButton() {
		click(cartButton);
	}
	

}
